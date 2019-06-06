package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.food.bean.Food;
import com.food.util.DataSourceUtils;

public class FoodDao {
	/**
	 * 列表food查询所有
	 * @param start
	 * @param pageSize
	 * @return
	 */
	   public List<Food> findFoodList(int start,int pageSize){
		   QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		   String sql="select * from food limit ?,?";
		   try {
			return runner.query(sql, new BeanListHandler<Food>(Food.class), start,pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return null;
	   }
	   /**
	    * 查询food总条数
	    * @return
	    */
		public int findFoodAllCount(){
			QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select count(*) from food";
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
		//查询food详情
		   public Food findFoodDetail(int fid){
			   QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
			   String sql="select f.*,d.* from food f,dishes d where f.did=d.did and f.fid=?";
			   try {
				return runner.query(sql,new BeanHandler<Food>(Food.class),fid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   return null;
		   }

		   public Food findFoodByFid(int fid){
			   QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
			   String sql="select * from food where fid=?";
			   try {
				return runner.query(sql,new BeanHandler<Food>(Food.class),fid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   return null;
		   }
			 public boolean updateFoodnum(Food food) throws SQLException{
				 QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
				 int count=0;
				 String sql ="update food set num=? where fid=?";
				 count=	runner.update(sql,food.getNum(), food.getFid());
				 return count>0?true:false;
			 }
	
}
