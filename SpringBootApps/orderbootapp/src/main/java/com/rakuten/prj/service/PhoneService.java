/**
 * 
 */
package com.rakuten.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.prj.dao.PhoneDao;
import com.rakuten.prj.entity.Phone;

/**
 * @author nishanth
 *
 */
@Service

public class PhoneService {
	@Autowired
	private PhoneDao phoneDao;
	
	public List<Phone> getPhones() {
		return phoneDao.findAll();
	}
	
	public Phone getPhone(int id) {
		return phoneDao.findById(id).get();
	}
	
	@Transactional
	public void addPhone(Phone p) {
		phoneDao.save(p);
	}
}
