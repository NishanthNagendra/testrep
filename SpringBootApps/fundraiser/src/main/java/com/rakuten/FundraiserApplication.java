package com.rakuten;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rakuten.prj.entity.Donation;
import com.rakuten.prj.service.CampaignService;

/**
 * 
 * @author nishanth
 *
 */
@SpringBootApplication
public class FundraiserApplication implements CommandLineRunner {
	@Autowired
	private CampaignService campaignService;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(FundraiserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String deadline = "26/01/2020";
//		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//		Campaign campaign = new Campaign(0, "Fund for flood relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active");
//		campaignService.addCampaign(campaign);
		
//		Donation d = new Donation(0, campaignService.getCampaign(1), "nishanth", "nish@gmail.com", "1234567890", new Date(), 156.0, "Paytm", "Paid");
//		campaignService.addDonations(d);
	}

}
