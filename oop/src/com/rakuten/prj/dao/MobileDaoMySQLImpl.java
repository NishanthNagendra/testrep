package com.rakuten.prj.dao;

import com.rakuten.prj.entity.Mobile;

public class MobileDaoMySQLImpl implements MobileDao {

	@Override
	public void addMobile(Mobile m) {
		System.out.println("Stored in MySQL");
	}

}
