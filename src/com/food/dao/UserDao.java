package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.food.bean.Admin;
import com.food.bean.Food;
import com.food.bean.User;
import com.food.util.DataSourceUtils;

public class UserDao {
	
	public User login(String uname,String upass) throws NumberFormatException, SQLException{
       	QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
       	String sql="select * from user where uname=? and upass=?";
       	return runner.query(sql, new BeanHandler<User>(User.class),uname,upass);
       } 
	  public int addUser(User user){
	    	QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
	    	String sql="insert into user(uname,upass,email,telephone) values(?,?,?,?)";
	    	try {
				int update=runner.update(sql,user.getUname(),user.getUpass(),user.getEmail(),user.getTelephone());
				return update;
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return 0;
	    }
	  
	  public List<User> findUserList(int start,int pageSize){
			QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from user limit ?,?";
			try {
				return runner.query(sql, new BeanListHandler<User>(User.class),start,pageSize);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		

		public int findUserAllCount(){
			QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select count(*) from user";
			try {
				return Integer.parseInt(runner.query(sql, new ScalarHandler()).toString());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		  public int addUserAddress(User user){
		    	QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		    	String sql="insert into user(address,name,tel) values(?,?,?) where uid=?";
		    	try {
					int update=runner.update(sql,user.getAddress(),user.getName(),user.getTel(),user.getUid());
					return update;
		    	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	return 0;
		    }
		  
		   public User orderAddress(int uid){
			   QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
			   String sql="select * from user where uid=?";
			   try {
				return runner.query(sql,new BeanHandler<User>(User.class),uid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   return null;
		   }
		  
		  
}
