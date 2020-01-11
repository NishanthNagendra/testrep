package com.rakuten.prj.client;

import com.rakuten.prj.dao.MobileDao;
import com.rakuten.prj.dao.MobileDaoMongoImpl;
import com.rakuten.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args) {
		Mobile m = new Mobile();
		MobileDao mobileDao = new MobileDaoMongoImpl();
		// MobileDao mobileDao = new MobileDaoMySQLImpl();
		// to change back-end use MobileDaoMySQLImpl();
		mobileDao.addMobile(m);
	}

}
