package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.food.bean.Food;
import com.food.bean.Gys;
import com.food.bean.Jhgoods;
import com.food.util.DataSourceUtils;



public class JhDao {

	// ���
	public int add(Jhgoods jh) {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into jhgoods values(?,?,?,?,?,?,?)";
		
		try {
			int update = queryRunner.update(sql, jh.getJid(),jh.getFid(),
					jh.getJprice(),jh.getJnum(),jh.getJtotal(),jh.getJhdate(),jh.getGysid()
					);
			return update;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// ��ѯ
	public List<Jhgoods> list(int start, int pageSize) {
		String sql = "select * from jhgoods order by jhdate desc limit ?,?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
		  List<Jhgoods> listgoods= runner.query(sql, new BeanListHandler<Jhgoods>(Jhgoods.class), start, pageSize);
	
			for(Jhgoods jh : listgoods){
				 sql="select * from food where fid='"+jh.getFid()+"'";
				Food food= runner.query(sql, new BeanHandler<Food>(Food.class));
				
			   jh.setFood(food);;
			}
			for(Jhgoods jh : listgoods){
				 sql="select * from gys where id='"+jh.getGysid()+"'";
				Gys gys= runner.query(sql, new BeanHandler<Gys>(Gys.class));
				
			   jh.setGys(gys);
			}
		return listgoods;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 *
	 * ��ȡ������
	 * @return int
	 */
	public int TotalCount() {
		String sql = "select count(*) as totalCount from jhgoods";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return Integer.parseInt(runner.query(sql, new ScalarHandler()).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//ɾ��
	public boolean deletejh(String id) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from jhgoods where jid=?";
		int count = 0;
		try {
			count = runner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count > 0 ? true : false;
	}
}
