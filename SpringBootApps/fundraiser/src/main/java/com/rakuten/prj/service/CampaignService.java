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
	@Autowired
	private CampaignDao campaignDao;

	@Autowired
	private DonationDao donationDao;

	public List<Campaign> getCampaigns() {
		return campaignDao.findAll();
	}

	public Campaign getCampaign(int id) {
		return campaignDao.findById(id).get();
	}

	public void addCampaign(Campaign c) {
		campaignDao.save(c);
	}

	public List<Campaign> getActiveCampaigns(String status) {
		return campaignDao.findByStatus(status);
	}

	public List<Donation> getDonations() {
		return donationDao.findAll();
	}

	public Donation getDonation(int id) {
		return donationDao.findById(id).get();
	}

	public void addDonations(Donation d) {
		Campaign campaign = campaignDao.findById(d.getCampaign().getId()).get();
		campaign.setReceivedAmount(campaign.getReceivedAmount() + d.getAmount());
		donationDao.save(d);
	}
}
