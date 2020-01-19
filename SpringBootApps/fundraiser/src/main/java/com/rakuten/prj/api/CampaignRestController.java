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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.prj.entity.Campaign;
import com.rakuten.prj.service.CampaignService;

/**
 * @author nishanth
 *
 */
@RestController
@RequestMapping("campaigns")
public class CampaignRestController {
	@Autowired
	private CampaignService service;

	@GetMapping()
	public @ResponseBody List<Campaign> getCampaigns(@RequestParam(name = "status", required = false) String status) {
		if (status == null)
			return service.getCampaigns();
		else
			return service.getActiveCampaigns(status);
	}

	@GetMapping("/{id}")
	public @ResponseBody Campaign getCampaignById(@PathVariable("id") int id) {
		return service.getCampaign(id);
	}

	@PostMapping()
	public ResponseEntity<Campaign> addCompaign(@RequestBody Campaign c) {
		service.addCampaign(c);
		return new ResponseEntity<Campaign>(c, HttpStatus.CREATED);
	}
}
