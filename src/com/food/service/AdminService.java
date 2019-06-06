package com.food.service;

import java.util.List;

import com.food.bean.Admin;
import com.food.dao.AdminDao;


public class AdminService {
	private AdminDao adminDao = new AdminDao();
	

	public List<Admin> findAdminList(int start,int pageSize){
		return adminDao.findAdminList(start, pageSize);
	}
	
	
	public int findAdminAllCount(int pageSize){
		int allCount=adminDao.findAdminAllCount();
		return allCount%pageSize > 0 ? allCount/pageSize+1 : allCount/pageSize;
	}
	
	
	 public Admin login(String userName, String password){
			Admin admin= adminDao.login(userName, password);
			return admin;
	 }
	 
	 public void addAdmin(String userName,String password){
		 adminDao.addAdmin(userName,password);
		
		  }
	 
	 
	 public Boolean addAdmins(Admin admin){
		 int count=adminDao.addAdmins(admin);
		  return count > 0 ? true : false;
		  }
	 
	public void updatePassword(String newpass,String userName) {
		adminDao.updatePassword(newpass,userName);
	}
	
    public boolean deleteAdmin(String id){
    	int count=adminDao.deleteAdmin(id);
    	return count>0?true:false;
    }
}

