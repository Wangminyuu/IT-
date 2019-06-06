package com.food.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.food.bean.User;
import com.food.dao.UserDao;
import com.food.util.DataSourceUtils;


public class UserService {
	private UserDao userDao = new UserDao();

    public User login(String uname,String upass){
    	try {
			return userDao.login(uname, upass);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }

	public boolean addUser(User user) {
		int count=userDao.addUser(user);
		  return count > 0 ? true : false;
	}
	
	  public List<User> findUserList(int start,int pageSize){
			
			return userDao.findUserList(start, pageSize);
		}
		

		public int findUserAllCount(int pageSize){
			int allCount=userDao.findUserAllCount();
			return allCount%pageSize > 0 ? allCount/pageSize+1 : allCount/pageSize;
		}
		
		  public boolean addUserAddress(User user){
			 int count= userDao.addUserAddress(user);
			  return count > 0 ? true : false;
		  }
		   public User orderAddress(int uid){
			return userDao.orderAddress(uid);
		  }
}
