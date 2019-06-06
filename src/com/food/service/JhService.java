package com.food.service;

import java.util.List;

import com.food.bean.Jhgoods;
import com.food.dao.JhDao;


public class JhService {
	private JhDao jhDao = new JhDao();

	// ���
	public int add(Jhgoods jh) {
		return jhDao.add(jh);
	}

	// ��ѯ
	public List<Jhgoods> list(int start, int pageSize) {
		return jhDao.list(start, pageSize);
	}

	// ��ҳ��
	public int totalPage(int pageSize) {
		int totalCount = jhDao.TotalCount();
		// ������ҳ��
		int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
		return totalPage;
	}
	//ɾ��
		public boolean deletejh(String id) {
			return jhDao.deletejh(id);
		}
}
