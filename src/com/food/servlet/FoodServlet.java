package com.food.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.bean.Cart;
import com.food.bean.CartItem;
import com.food.bean.Dishes;
import com.food.bean.Food;
import com.food.service.DishesService;
import com.food.service.FoodService;
import com.google.gson.Gson;


public class FoodServlet extends BaseServlet {
	private FoodService foodService=new FoodService();
	private DishesService dishesService=new DishesService();
	public void findFoodList(HttpServletRequest request,HttpServletResponse response) throws Exception, IOException{
		int currentPage=1;
		int pageSize=6;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		int start=(currentPage-1)*pageSize;
		int allPages=foodService.findFoodAllCount(pageSize);
		List<Food> foodList=foodService.findFoodList(start, pageSize);
		request.setAttribute("foodList", foodList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("allPages", allPages);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int fid=Integer.parseInt(request.getParameter("fid"));
	     Food food=foodService.findFoodDetail(fid);
		 request.setAttribute("food", food);
		 request.getRequestDispatcher("detail.jsp").forward(request, response);
		 
	}
	public void addCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int fid=Integer.parseInt(request.getParameter("fid"));
		
		Food food=foodService.findFoodByFid(fid);

	
		CartItem cartItem=new CartItem();
		cartItem.setBuyNum(quantity);
		cartItem.setFood(food);
		cartItem.setSubTotal(food.getF_price()*quantity);
		HttpSession session=request.getSession();
		
		Cart cart =(Cart) session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
		}
		
	    HashMap<Integer ,CartItem> cartItems=cart.getCartItems();
	    double newSubTotal=0;
	    double oldSubTotal=0;
		if(cartItems.containsKey(fid)){
		
		    CartItem item=cartItems.get(fid);
		    oldSubTotal= item.getSubTotal();
		    int newBuyNum= item.getBuyNum()+quantity;
		    item.setBuyNum(newBuyNum);
		    newSubTotal=newBuyNum*item.getFood().getF_price();
		    item.setSubTotal(newSubTotal);
		    
		}else{
			cartItems.put(fid, cartItem);
			newSubTotal=food.getF_price()*quantity;
		}
		
		cart.setCartItems(cartItems);
		double total=cart.getTotal()-oldSubTotal+newSubTotal;
		cart.setTotal(total);
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	public void deleteCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		int fid=Integer.parseInt(request.getParameter("fid"));

		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		HashMap<Integer,CartItem> cartItems=cart.getCartItems();
		double subTotal=0;
		if(cartItems.containsKey(fid)){
			CartItem cartItem=cartItems.get(fid);
			subTotal=cartItem.getSubTotal();
			cartItems.remove(fid);
		}
		
		cart.setCartItems(cartItems);
		double total=cart.getTotal()-subTotal;
		cart.setTotal(total);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	public void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart!=null){
			session.removeAttribute("cart");
		}
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	
	public void updateCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int num=Integer.parseInt(request.getParameter("num"));
		int fid=Integer.parseInt(request.getParameter("fid"));
		Food food=foodService.findFoodByFid(fid);
		HttpSession session=request.getSession();
		Cart cart =(Cart) session.getAttribute("cart");
	    HashMap<Integer ,CartItem> cartItems=cart.getCartItems();
	    double newSubTotal=0;
	    double oldSubTotal=0;
		if(cartItems.containsKey(fid)){
		    CartItem item=cartItems.get(fid);
		    oldSubTotal=item.getFood().getF_price()*item.getBuyNum();
			item.setBuyNum(num);
			newSubTotal=food.getF_price()*num;
			item.setSubTotal(newSubTotal);	    
		}
	
		double total=cart.getTotal()-oldSubTotal+newSubTotal;
		cart.setTotal(total);
		cart.setCartItems(cartItems);
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	public void foodListByDishes(HttpServletRequest request,HttpServletResponse response) throws Exception, IOException{
		int did=Integer.parseInt(request.getParameter("did"));
		int currentPage=1;
		int pageSize=6;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		int start=(currentPage-1)*pageSize;
		int allPages=foodService.findFoodAllCount(pageSize);
		List<Food> foodList=foodService.findFoodList(start, pageSize);
		List<Dishes> dishesList=dishesService.findDishesList();
		List<Food> foodListByDishes=dishesService.findFoodListByDid(start, pageSize, did);
		request.setAttribute("foodListByDishes", foodListByDishes);	
		request.setAttribute("dishesList", dishesList);	
		request.setAttribute("foodList", foodList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("allPages", allPages);
		request.setAttribute("did", did);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}
	
	public void foodList(HttpServletRequest request,HttpServletResponse response) throws Exception, IOException{
		
		int currentPage=1;
		int pageSize=6;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		int start=(currentPage-1)*pageSize;
		int allPages=foodService.findFoodAllCount(pageSize);
		List<Food> foodList=foodService.findFoodList(start, pageSize);
		List<Dishes> dishesList=dishesService.findDishesList();
		
	
		request.setAttribute("dishesList", dishesList);	
		request.setAttribute("foodList", foodList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("allPages", allPages);
		
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}
	 public void findkcfood(HttpServletRequest request, HttpServletResponse response) 
	 			throws ServletException, IOException {
	 	 List<Food> foodList = new ArrayList<>();
	 	
	 		int currentPage=1;
	 		
	 		int pageSize=5;
	 		
	 		if(request.getParameter("currentPage")!=null){
	 			currentPage=Integer.parseInt(request.getParameter("currentPage"));
	 		}
	 		
	 		int start=(currentPage-1)*pageSize;
	 		
	 		int totalPage=foodService.findFoodAllCount(pageSize);
	 	    foodList=foodService.findFoodList(start, pageSize);
	 	 
	 		request.setAttribute("foodList", foodList);
	 		request.setAttribute("currentPage", currentPage);
	 		request.setAttribute("totalPage", totalPage);
	 		request.getRequestDispatcher("admin/kc.jsp").forward(request, response);
	 	}

		
}
