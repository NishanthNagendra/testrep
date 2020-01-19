/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakuten.prj.entity.Campaign;

/**
 * @author nishanth
 *
 */
public interface CampaignDao extends JpaRepository<Campaign, Integer> {
	List<Campaign> findByStatus(String status);
}