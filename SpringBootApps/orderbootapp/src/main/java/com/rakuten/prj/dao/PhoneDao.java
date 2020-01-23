/**
 * 
 */
package com.rakuten.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakuten.prj.entity.Phone;

/**
 * @author nishanth
 *
 */
public interface PhoneDao extends JpaRepository<Phone, Integer> {

}
