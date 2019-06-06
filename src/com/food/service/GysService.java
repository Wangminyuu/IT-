package com.food.service;

import java.sql.SQLException;
import java.util.List;

import com.food.bean.Gys;
import com.food.dao.GysDao;


public class GysService {
 private GysDao gysDao=new GysDao();
	// ��ӹ�Ӧ��
	public boolean addGys(Gys gys) {
		int date = gysDao.addGys(gys);
		return date > 0 ? true : false;
	}

	// ��ѯ��Ӧ����Ϣ
	public List<Gys> list(int start, int pageSize) {
		return gysDao.gyslist(start, pageSize);
	}

	/**
	 * ��Ӧ�̵���ҳ��
	 * 
	 * @return int
	 */
	public int totalPage(int pageSize) {
		int totalCount = gysDao.TotalCount();
		// ������ҳ��
		int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
		return totalPage;
	}

	// ��ݹ�Ӧ��ID��ѯ
	public Gys gysId(String id) {
		return gysDao.gysId(id);
	}

	/**
	 * �޸Ĺ�Ӧ����Ϣ
	 */

	public boolean updatePs(Gys gys) throws SQLException {
		return gysDao.updateGys(gys);
	}

	// ɾ��Ӧ����Ϣ
	public boolean deletePs(String id) {
		return gysDao.deleteGys(id);
	}
}
