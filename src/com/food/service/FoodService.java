package com.food.service;

import java.sql.SQLException;
import java.util.List;


import com.food.bean.Food;
import com.food.dao.FoodDao;

public class FoodService {
  private FoodDao foodDao=new FoodDao();
	/**
	 * 列表查询所有
	 * @param start
	 * @param pageSize
	 * @return
	 */
	   public List<Food> findFoodList(int start,int pageSize){
		 return foodDao.findFoodList(start, pageSize);
	   }

	   /**
	    * 查询food总条数
	    * @return
	    */
		public int findFoodAllCount(int pageSize){
			int allCount=foodDao.findFoodAllCount();
			return allCount%pageSize > 0 ? allCount/pageSize+1 : allCount/pageSize;
		}
		/**
		 * 查询food详情
		 * @param fid
		 * @return
		 */
		public Food findFoodDetail(int fid){
			return foodDao.findFoodDetail(fid);

		}
		   public Food findFoodByFid(int fid){
			return  foodDao.findFoodByFid(fid);
		   }
		   public boolean updateFoodnum(Food food){
				try {
					return foodDao.updateFoodnum(food);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
				
			}
}
