package com.food.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.food.bean.User;
import com.food.service.UserService;



public class UserServlet extends BaseServlet {
	 private UserService userService=new UserService();
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=userService.login(username, password);
		if(user!=null){	
			 request.getSession().setAttribute("user",user);
			 request.getRequestDispatcher("default.jsp").forward(request, response);

	//	response.sendRedirect("default.jsp");
		}else{
			response.sendRedirect("login_login.jsp");
		}

	}
	public void add(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HashMap<String, String[]> properties=(HashMap<String, String[]>) request.getParameterMap();
	    User user=new User();
	    ConvertUtils.register(new Converter() {
			
			@Override
			public Object convert(Class cla, Object value) {
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
	    BeanUtils.populate(user, properties);
	    
        if(user.getUname()!=null){
        	boolean result= userService.addUser(user);
        	if(result){
    			response.sendRedirect("login_login.jsp");
    		}else{
    			request.getRequestDispatcher("regist.jsp").forward(request, response);
    		}
        }

	}
	public void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		 User user=(User) request.getSession().getAttribute("user");
		 if(user!=null){
			 
			 request.getSession().removeAttribute("user");
			
			 Cookie [] cookies= request.getCookies();
			 if(cookies!=null){
				   for(Cookie cookie : cookies){
					   
					   if("cookie_username".equals(cookie.getName())){
						   cookie.setMaxAge(0);
						   response.addCookie(cookie);
					   }
					   
					   if("cookie_password".equals(cookie.getName())){
						   cookie.setMaxAge(0);
						   response.addCookie(cookie);
					   }
				   }
			 }
	
		 }
		  response.sendRedirect("default.jsp");
	}
	public void logins(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=userService.login(username, password);
		if(user!=null){	
			request.getSession().setAttribute("user",user);
			
		response.sendRedirect("default.jsp");
		}else{
			response.sendRedirect("login_login.jsp");
		}

	}
	
	public void addAddress(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		 User user=(User) request.getSession().getAttribute("user");
		
		if(user!=null){	
		     
	         String address=request.getParameter("address");
	         String name=request.getParameter("name");
	         String tel=request.getParameter("tel");
	         
	         user.setAddress(address);
	         user.setName(name);
	         user.setTel(tel);
	         userService.addUserAddress(user);
	       	request.setAttribute("user",user);
	         request.getRequestDispatcher("order?method=addOrder").forward(request, response);
	         
				}else{
			response.sendRedirect("login_login.jsp");
		}

	}
	public void orderAddress(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
	
		 User user=(User) request.getSession().getAttribute("user");
		
		if(user!=null){	
		
			request.getSession().setAttribute("user",user);
		
	        request.getRequestDispatcher("orderaddress.jsp").forward(request, response);
	         
       	}else{
       		response.sendRedirect("login_login.jsp");
       	}
	


	}
	
}
