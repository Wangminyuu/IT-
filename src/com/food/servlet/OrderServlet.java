package com.food.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.bean.Cart;
import com.food.bean.CartItem;
import com.food.bean.Jhgoods;
import com.food.bean.OrderItem;
import com.food.bean.Orders;
import com.food.bean.Transfer;
import com.food.bean.User;
import com.food.service.JhService;
import com.food.service.OrderService;
import com.food.util.CommonsUtil;

public class OrderServlet extends BaseServlet {
	   private OrderService orderService=new OrderService();
	   private JhService jhService=new JhService();
	
		public void addOrder(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
			
		HttpSession session=request.getSession();		
		User user=(User) session.getAttribute("user");
		
			 if(user==null){
				 request.getRequestDispatcher("login_login.jsp").forward(request, response);
				// response.sendRedirect("login_login.jsp");
				 return; 
			  }
			 Cart cart =(Cart) session.getAttribute("cart");
			 Orders order=new Orders();
                order.setOid(CommonsUtil.getUUID());
				order.setOrdertime(new Date());
				order.setTotal(cart.getTotal());
	      		order.setState(0);
	      		 String address=request.getParameter("address");
	    		 String name=request.getParameter("name");
	    		 String tel=request.getParameter("tel");
	    		
	    		 order.setAddress(address);
	    		 order.setName(name);
	    		 order.setTelephone(tel);
				 order.setUid(user.getUid());
				 orderService.addOrder(order);

				
				
				ArrayList<OrderItem> cartItemList=new ArrayList<OrderItem>();
				HashMap<Integer,CartItem> cartItems=cart.getCartItems();
				for(Map.Entry<Integer, CartItem> entry: cartItems.entrySet()){
					CartItem cartItem=	entry.getValue();
					OrderItem orderitem=new OrderItem();
				  
					orderitem.setCount(cartItem.getBuyNum());
					orderitem.setSubtotal(cartItem.getSubTotal());
					orderitem.setFid(cartItem.getFood().getFid());
					
					orderitem.setFood(cartItem.getFood());
					orderitem.setOid(order.getOid());
					orderService.addOrderItem(orderitem);
					
					cartItemList.add(orderitem);
				}
				order.setItems(cartItemList);
				
				request.setAttribute("order", order);
				request.getRequestDispatcher("order_info.jsp").forward(request, response);
				
		}	
		public void myOrder(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
			
			int pageSize=10;
			int currentPage=1;
			if(request.getParameter("currentPage")!=null){
				currentPage=Integer.parseInt(request.getParameter("currentPage"));
			}
			int start=(currentPage-1)*pageSize;
			
			User user=(User) request.getSession().getAttribute("user");
			
			int totalPage=orderService.findOrderTotalPageByUid(user.getUid(), pageSize);
			List<Orders> ordersList=orderService.findOrderByUid(user.getUid(), start, pageSize);
			request.setAttribute("ordersList", ordersList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPage", totalPage);
			request.getRequestDispatcher("order_list.jsp").forward(request, response);
		}
		public void dispact(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
			HttpSession session=request.getSession();		
			User user=(User) session.getAttribute("user");
			String orderid=request.getParameter("orderid");
			
			String address=request.getParameter("address");
			String name=request.getParameter("name");
			String tel=request.getParameter("tel");
			 Cart cart =(Cart) session.getAttribute("cart");
			 Orders order=new Orders();
		     order.setOid(CommonsUtil.getUUID());
			 order.setOrdertime(new Date());
			 order.setTotal(cart.getTotal());
      		 order.setState(0);
			 order.setAddress(address);
    		 order.setName(name);
    		 order.setTelephone(tel);
			 order.setUid(user.getUid());
		
			List<Transfer> transferList=orderService.findTransferByTid();
			 orderService.addOrder(order);
			request.setAttribute("transferList", transferList);
	
			request.getRequestDispatcher("dispact.jsp").forward(request, response);
		}
		public void myOrders(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int pageSize=3;
			int currentPage=1;
			if(request.getParameter("currentPage")!=null){
				currentPage=Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int start=(currentPage-1)*pageSize;
			int totalPage=orderService.totalPage(pageSize);
			List<Orders> ordersList=orderService.findOrder(start, pageSize);
			request.setAttribute("ordersList", ordersList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPage", totalPage);
			request.getRequestDispatcher("admin/order.jsp").forward(request, response);
		}
		
		public void hotOrderFood(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int pageSize=3;
			int currentPage=1;
			if(request.getParameter("currentPage")!=null){
				currentPage=Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int start=(currentPage-1)*pageSize;
			int totalPage=orderService.totalPage(pageSize);
			List<OrderItem> ordersList=orderService.findHotFood(start, pageSize);
			request.setAttribute("ordersList", ordersList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPage", totalPage);
			request.getRequestDispatcher("admin/hot.jsp").forward(request, response);
		}
		
		public void deletehotOrderFood(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String oid = request.getParameter("oid");
			orderService.deleteHot(oid);
			request.getRequestDispatcher("order?method=hotOrderFood&currentPage=1").forward(request, response);
		}
}
