package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.food.bean.Admin;
import com.food.util.DataSourceUtils;



public class AdminDao{

	public List<Admin> findAdminList(int start,int pageSize){
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from admin limit ?,?";
		try {
			return runner.query(sql, new BeanListHandler<Admin>(Admin.class),start,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public int findAdminAllCount(){
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from Admin";
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
	
	
      public Admin login(String userName, String password){
  	    String sql="select * from admin where uname=? and upass=?";

    	    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    	    try {

				return	runner.query(sql, new BeanHandler<Admin>(Admin.class), userName,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    return null;
      }

      
      public void addAdmin(String userName, String password) {
    		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
     	    String sql="insert into admin values(?,?)";
     	    try {
     	    	runner.update(sql,userName,password);
    			} catch (SQLException e) {
    				e.printStackTrace();
    		}
     	    
    	}
  
      public int addAdmins(Admin admin) {
  		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
   	    String sql="insert into admin (uname,upass) values(?,?)";
   	    try {
   	    	return runner.update(sql,admin.getUname(),admin.getUpass());
  			} catch (SQLException e) {
  				e.printStackTrace();
  		}
   	    return 0;
  	}
      
  	public void updatePassword(String newpass,String userName) {
  		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
   	    String sql="update admin set upass = ? where uname = ?";
   	    try {
   	    	runner.update(sql,new String[]{newpass,userName});
  			} catch (SQLException e) {
  				e.printStackTrace();
  		}
  	}
	
	
  public int deleteAdmin(String id){
  	QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
  	String sql="delete from admin where id=?";
  	try {
			return runner.update(sql, id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	return 0;
  }
  	
  }
