package com.food.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.food.bean.OrderItem;
import com.food.bean.Orders;
import com.food.bean.Transfer;
import com.food.dao.OrderDao;

public class OrderService {
	private OrderDao orderDao=new OrderDao();
	 public List<Orders> findOrder(int start,int pageSize){
		 try {
			return orderDao.findOrder(start, pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }

	 public int totalPage(int pageSize){
		 try {
			int totalCount=orderDao.findOrderTotalCount();
			int totalPage=totalCount%pageSize>0 ?totalCount/pageSize+1:totalCount/pageSize;
			return totalPage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 return 0;
	 } 

		public void addOrder(Orders order){
			try {
			
				orderDao.addOrder(order);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		public void addOrderItem(OrderItem orderItem) {
			try {
				orderDao.addOrderItem(orderItem);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void updateOrderState(String oid) {
			try {
				orderDao.updateOrderState(oid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public List<Orders> findOrderByUid(int uid,int start, int pageSize){
			
			try {
				return orderDao.findOrderByUid(uid, start, pageSize);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		public int findOrderTotalPageByUid(int uid,int pageSize) {
			try {
				int totalCount=orderDao.findOrderTotalCountByUid(uid);
				
				int totalPage=totalCount%pageSize>0 ?totalCount/pageSize+1:totalCount/pageSize;
			
				return totalPage;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		public List<Transfer> findTransferByTid(){
			try {
				return orderDao.findTransferByTid();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		public void addOrdersByOid(Orders orders) throws SQLException{
			orderDao.addOrdersByOid(orders);
		}
		public List<Orders> findHotOrder(int start, int pageSize){
			 try {
				return orderDao.findHotOrder(start, pageSize);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return null;
		 }
		
		public List<OrderItem> findHotFood(int start,int pageSize){
			try {
				return orderDao.findHotFood(start, pageSize);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public boolean deleteHot(String oid) {
			return orderDao.deleteHot(oid);
		}
}
