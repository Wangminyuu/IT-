package com.food.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.food.bean.Dishes;
import com.food.bean.Food;
import com.food.util.DataSourceUtils;

public class DishDao {
	/**
	 * 查询分类
	 * @return
	 */
	  public List<Dishes> findDishesList(){
		   QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		   String sql="select * from dishes";
		   try {
			return runner.query(sql, new BeanListHandler<Dishes>(Dishes.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return null;
	   }
	  /**
	   * 分类查询
	   * @param start
	   * @param pageSize
	   * @return
	   */
	  public List<Food> findFoodListByDid(int start,int pageSize,int did){
		   QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		   String sql="select * from food where did=? limit ?,?";
		   try {
			return runner.query(sql, new BeanListHandler<Food>(Food.class), start,pageSize,did);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return null;
	   }
}
