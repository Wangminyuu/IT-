package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.food.bean.Gys;
import com.food.util.DataSourceUtils;


public class GysDao {



	// ��ӹ�Ӧ��
	public int addGys(Gys gys) {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into gys values(?,?,?,?,?)";
		try {
			int update = queryRunner.update(sql, gys.getId(),gys.getGysname(),gys.getLxr(),
					gys.getTel(),gys.getAddress()
					);
			return update;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// ��ѯ��Ӧ����Ϣ
	public List<Gys> gyslist(int start, int pageSize) {
		String sql = "select * from gys limit ?,?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanListHandler<Gys>(Gys.class), start, pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * ��ȡ��Ӧ�̵�������
	 * 
	 * @return int
	 */
	public int TotalCount() {
		String sql = "select count(*) as totalCount from gys";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return Integer.parseInt(runner.query(sql, new ScalarHandler()).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// ��ݹ�Ӧ�̵�ID��ѯ
	public Gys gysId(String id) {
		String sql = "select * from gys where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<Gys>(Gys.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �޸Ĺ�Ӧ����Ϣ
	 */

	public boolean updateGys(Gys gys) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int count = 0;
		String sql = "update gys set gysname=?,lxr=?,tel=?,address=? where id=?";
		count = runner.update(sql, gys.getGysname(),gys.getLxr(),gys.getTel(),
				gys.getAddress(),gys.getId());

		return count > 0 ? true : false;
	}

	// ɾ��Ӧ��
	public boolean deleteGys(String id) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from gys where id=?";
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
