package com.food.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.fileupload.FileUploadException;

import com.food.bean.Admin;
import com.food.bean.User;
import com.food.service.AdminService;
import com.food.service.UserService;


public class AdminServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminService();
	private UserService userService=new UserService();
	public void findFoodList(HttpServletRequest request,HttpServletResponse response) throws Exception, IOException{
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");	
		 
		 
		 String valcode=request.getParameter("valcode");
		 HttpSession session=request.getSession();
		 String sessionCode=(String)session.getAttribute("valcode");
		
		if(! valcode.equalsIgnoreCase(sessionCode)){
			response.sendRedirect("admin/login.jsp?msg=1");
			return;
		}
	
		 Admin admin =adminService.login(username, password);
		 if(admin==null){
		
			  String message = String.format(
					                     "对不起，用户名或密码有误！！请重新登录！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'", 
					                      request.getContextPath()+"/admin/login.jsp");
					            request.setAttribute("message",message);
					           request.getRequestDispatcher("admin/message.jsp").forward(request, response);
					              return;
		 }else{
			  session.setAttribute("admin", admin);
			     String message = String.format(
			    	      "恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'", 
			    						                  admin.getUname(),
			    						                  request.getContextPath()+"/admin/index.jsp");
			    						         request.setAttribute("message",message);
			    						         request.getRequestDispatcher("admin/message.jsp").forward(request, response);
				 

		 }
	}
	
	public void guanliUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int pageSize=5;
	
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int start=(currentPage-1)*pageSize;
		
		int totalPage=adminService.findAdminAllCount(pageSize);
		List<Admin> adminList=adminService.findAdminList(start, pageSize);
		request.setAttribute("adminList", adminList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("admin/user.jsp").forward(request, response);
	
}
	public void updatePassword(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {
		 String userName = request.getParameter("uname");
		 String mpass = request.getParameter("mpass");
		 String newpass = request.getParameter("newpass");
		 Admin admin = adminService.login(userName, mpass);
		 if(admin == null){
			 response.sendRedirect("admin/pass.jsp?msg=6");//msg=5 ����Ա�����޸�ʧ��
		 }else{
			 adminService.updatePassword(newpass,userName);
			 response.sendRedirect("admin?method=guanliUser&currentPagae=1");//msg=5 ����Ա�����޸ĳɹ�
		 }
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id=request.getParameter("id");
		adminService.deleteAdmin(id);
		response.sendRedirect("admin?method=guanliUser&currentPagae=1");
	}
	 public void addUser(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException, FileUploadException, IllegalAccessException, InvocationTargetException {
		
	
		 HashMap<String, String[]> properties=(HashMap<String, String[]>) request.getParameterMap();
			Admin admin=new Admin();
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

	    BeanUtils.populate(admin, properties);
			boolean result=adminService.addAdmins(admin);
			
			if(result){
				response.sendRedirect("admin?method=guanliUser&currentPagae=1");
			
			}else{
				request.getRequestDispatcher("admin/add_user.jsp").forward(request, response);
			}
			
		}
	 //会员列表
		public void selectUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			int pageSize=5;
		
			int currentPage=1;
			if(request.getParameter("currentPage")!=null){
				currentPage=Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int start=(currentPage-1)*pageSize;
			
			int totalPage=userService.findUserAllCount(pageSize);
			List<User> userList=userService.findUserList(start, pageSize);
			request.setAttribute("userList", userList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPage", totalPage);
			request.getRequestDispatcher("admin/users.jsp").forward(request, response);
		
	}
}
