package com.food.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.food.bean.Food;

import com.food.bean.OrderItem;
import com.food.bean.Orders;
import com.food.bean.Transfer;
import com.food.util.DataSourceUtils;

public class OrderDao {
	public List<Orders> findOrder(int start, int pageSize) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders limit ?,?";
		List<Orders> orderList = runner.query(sql, new BeanListHandler<Orders>(Orders.class), start, pageSize);
		for (Orders order : orderList) {
			sql = "select * from orderitem where oid=?";
			ArrayList<OrderItem> orderItemList = (ArrayList<OrderItem>) runner.query(sql,
					new BeanListHandler<OrderItem>(OrderItem.class), order.getOid());
			for (OrderItem orderItem : orderItemList) {
				sql = "select * from food where fid=?";
				Food food = runner.query(sql, new BeanHandler<Food>(Food.class), orderItem.getFid());
				orderItem.setFood(food);
			}
			order.setItems(orderItemList);
		}
		return orderList;
	}


	public int findOrderTotalCount() throws NumberFormatException, SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from orders";
		return Integer.parseInt(runner.query(sql, new ScalarHandler()).toString());
	}

	public void addOrder(Orders order) throws SQLException { 
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into orders values(?,?,?,?,?,?,?,?)";
		
		runner.update(sql,order.getOid(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
				format(order.getOrdertime()),
				order.getTotal(), order.getState(), order.getAddress(), order.getName(), 
				order.getTelephone(),order.getUid());
		}

	public void addOrderItem(OrderItem orderItem) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into orderitem(count,subtotal,fid,oid) values(?,?,?,?)";
		runner.update(sql,orderItem.getCount(), orderItem.getSubtotal(),
				orderItem.getFid(),
				orderItem.getOid());
	}
	
	public void updateOrderState(String oid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update orders set state=1 where oid=?";
		runner.update(sql, oid);
	}
	

	public List<Orders> findOrderByUid(int uid,int start, int pageSize) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders where uid=? limit ?,?";
		List<Orders> orderList = runner.query(sql, new BeanListHandler<Orders>(Orders.class), uid,start, pageSize);
		for (Orders order : orderList) {
			sql = "select * from orderitem where oid=?";
			ArrayList<OrderItem> orderItemList = (ArrayList<OrderItem>) runner.query(sql,
					new BeanListHandler<OrderItem>(OrderItem.class), order.getOid());
			for (OrderItem orderitem : orderItemList) {
				sql = "select * from food where fid=?";
				Food food = runner.query(sql, new BeanHandler<Food>(Food.class), orderitem.getFid());
				orderitem.setFood(food);
			}
			order.setItems(orderItemList);
		}
		return orderList;
	}

	public int findOrderTotalCountByUid(int uid) throws NumberFormatException, SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from orders where uid=?";
		return Integer.parseInt(runner.query(sql, new ScalarHandler(),uid).toString());
	}
	
	public List<Transfer> findTransferByTid() throws NumberFormatException, SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from transfer";
		return runner.query(sql, new BeanListHandler<Transfer>(Transfer.class));
	}
	public void addOrdersByOid(Orders orders) throws SQLException{
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into orders(address,name,telephone) values(?,?,?) where oid=?";
		runner.update(sql,orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getOid());
	}
	
	
	public List<Orders> findHotOrder(int start, int pageSize) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders limit ?,?";
		List<Orders> orderList = runner.query(sql, new BeanListHandler<Orders>(Orders.class), start, pageSize);
		for (Orders order : orderList) {
			sql = "select sum(count),fid from orderitem group by fid order by sum(count) desc limit ?,?";
			ArrayList<OrderItem> orderItemList = (ArrayList<OrderItem>) runner.query(sql,
					new BeanListHandler<OrderItem>(OrderItem.class),start, pageSize);
			for (OrderItem orderItem : orderItemList) {
				sql = "select * from food where fid=?";
				Food food = runner.query(sql, new BeanHandler<Food>(Food.class), orderItem.getFid());
				orderItem.setFood(food);
			}
			order.setItems(orderItemList);
		}
		return orderList;
	}
	
	public List<OrderItem> findHotFood(int start,int pageSize) throws SQLException{
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select sum(count) as allHotCount,fid,oid from orderitem group by fid order by sum(count) desc limit ?,?";
		ArrayList<OrderItem> orderItemList=(ArrayList<OrderItem>) runner.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),start,pageSize);
		for(OrderItem orderitem:orderItemList){
			sql="select * from food where fid=?";
			Food food=runner.query(sql, new BeanHandler<Food>(Food.class),orderitem.getFid());
		    orderitem.setFood(food);
		}
		return orderItemList;
	}
	
	public boolean deleteHot(String oid) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from orderitem where oid=?";
		int count = 0;
		try {
			count = runner.update(sql, oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count > 0 ? true : false;
	}
	
}
