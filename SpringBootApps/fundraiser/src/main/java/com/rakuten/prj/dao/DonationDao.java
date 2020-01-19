/**
 * 
 */
package com.rakuten.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakuten.prj.entity.Donation;

/**
 * @author nishanth
 *
 */
public interface DonationDao extends JpaRepository<Donation, Integer> {

}
