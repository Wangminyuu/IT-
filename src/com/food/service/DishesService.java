package com.food.service;

import java.util.List;

import com.food.bean.Dishes;
import com.food.bean.Food;
import com.food.dao.DishDao;
import com.food.dao.FoodDao;

public class DishesService {
	private DishDao dishDao=new DishDao();
	private FoodDao foodDao=new FoodDao();
	/**
	 * 查询分类
	 * @return
	 */
 
	  public List<Dishes> findDishesList(){
		return  dishDao.findDishesList();
	  }
	  /**
	   * 分类查询
	   * @param start
	   * @param pageSize
	   * @return
	   */
	  public List<Food> findFoodListByDid(int start,int pageSize,int did){
		return dishDao.findFoodListByDid(start, pageSize, did);
	  }
}
