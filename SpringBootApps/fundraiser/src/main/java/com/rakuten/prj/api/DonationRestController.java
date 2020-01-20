/**
 * 
 */
package com.rakuten.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.prj.entity.Donation;
import com.rakuten.prj.service.CampaignService;

/**
 * @author nishanth
 *
 */
@RestController
@RequestMapping("donations")
public class DonationRestController {
	/**
	 * 
	 */
	@Autowired
	private CampaignService service;

	/**
	 * @return
	 */
	@GetMapping()
	public @ResponseBody List<Donation> getDonations() {
			return service.getDonations();
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public @ResponseBody Donation getDonationById(@PathVariable("id") int id) {
		return service.getDonation(id);
	}

	/**
	 * @param d
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<Donation> addDonation(@RequestBody Donation d) {
		service.addDonations(d);
		return new ResponseEntity<Donation>(d, HttpStatus.CREATED);
	}
}
