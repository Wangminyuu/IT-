package com.food.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.food.bean.Food;
import com.food.bean.Gys;
import com.food.bean.Jhgoods;
import com.food.service.FoodService;
import com.food.service.GysService;
import com.food.service.JhService;
import com.food.util.CommonsUtil;


public class JhServlet extends BaseServlet {
	private JhService jhService = new JhService();
	private GysService gysService = new GysService();
	private FoodService foodService = new FoodService();

	
	public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Gys> gyslist = gysService.list(0, 20);
		List<Food> foodlist = foodService.findFoodList(0, 20);
		request.setAttribute("gyslist", gyslist);
		request.setAttribute("foodlist", foodlist);
		request.getSession().setAttribute("foodlist", foodlist);
		request.getRequestDispatcher("admin/add.jsp").forward(request, response);
	}

	
	
	public void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, Exception {
		int old = 0;
		int jnum = 0;
		String test = request.getParameter("jnum");
		if (!CommonsUtil.isNum(test)) {return;}
		int fid = Integer.parseInt(request.getParameter("fid"));
		int news = Integer.parseInt(test);
		Food food = foodService.findFoodByFid(fid);
		old = food.getNum();
		if (food!=null) {
			jnum = old + news;
			food.setNum(jnum);
			foodService.updateFoodnum(food);
			HashMap properties = (HashMap) request.getParameterMap();
			Jhgoods jh = new Jhgoods();
			ConvertUtils.register(new Converter() {
				public Object convert(Class arg0, Object value) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					try {
						return sdf.parse(value.toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return null;
				}
			}, Date.class);
			BeanUtils.populate(jh, properties);
			String jid = CommonsUtil.getUUID();
			jh.setJid(jid);
			jhService.add(jh);
			request.getRequestDispatcher("jh?method=list").forward(request, response);
		}
		else {

			HashMap properties = (HashMap) request.getParameterMap();
			Jhgoods jh = new Jhgoods();
			 ConvertUtils.register(new Converter() {
			 public Object convert(Class arg0, Object value) {
			 // TODO Auto-generated method stub
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
			 try {
			 return sdf.parse(value.toString());
			 } catch (ParseException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 return null;
			 }
			 }, Date.class);
			
			 BeanUtils.populate(jh, properties);
			 String jid = CommonsUtil.getUUID();
			 jh.setJid(jid);
			 jhService.add(jh);
			
			 request.getRequestDispatcher("jh?method=list").forward(request,
			 response);
			
			
		}

	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Jhgoods> jhList = new ArrayList<>();
		
		int currentPage = 1;
		
		int pageSize = 8;
		
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
	
		int start = (currentPage - 1) * pageSize;
		
		int totalPage = jhService.totalPage(pageSize);
		jhList = jhService.list(start, pageSize);

		request.setAttribute("jhList", jhList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("admin/list.jsp").forward(request, response);
	}
	//ɾ��
	public void detelejh(HttpServletRequest request, HttpServletResponse response) throws Exception, Exception{
		String id = request.getParameter("jid");
		jhService.deletejh(id);
		request.getRequestDispatcher("jh?method=list").forward(request, response);

	}

}
