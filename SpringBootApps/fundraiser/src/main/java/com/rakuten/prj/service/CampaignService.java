/**
 * 
 */
package com.rakuten.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.prj.dao.CampaignDao;
import com.rakuten.prj.dao.DonationDao;
import com.rakuten.prj.entity.Campaign;
import com.rakuten.prj.entity.Donation;

/**
 * @author nishanth
 *
 */
@Service
@Transactional
public class CampaignService {
	/**
	 * 
	 */
	@Autowired
	private CampaignDao campaignDao;

	/**
	 * 
	 */
	@Autowired
	private DonationDao donationDao;

	/**
	 * @return
	 */
	public List<Campaign> getCampaigns() {
		return campaignDao.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	public Campaign getCampaign(int id) {
		return campaignDao.findById(id).get();
	}

	/**
	 * @param c
	 */
	public void addCampaign(Campaign c) {
		campaignDao.save(c);
	}

	/**
	 * @param status
	 * @return
	 */
	public List<Campaign> getActiveCampaigns(String status) {
		return campaignDao.findByStatus(status);
	}

	/**
	 * @return
	 */
	public List<Donation> getDonations() {
		return donationDao.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	public Donation getDonation(int id) {
		return donationDao.findById(id).get();
	}

	/**
	 * @param d
	 */
	public void addDonations(Donation d) {
		Campaign campaign = campaignDao.findById(d.getCampaign().getId()).get();
		campaign.setReceivedAmount(campaign.getReceivedAmount() + d.getAmount());
		donationDao.save(d);
	}
}
