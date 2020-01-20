/**
 * 
 */
package com.rakuten.prj.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakuten.prj.entity.Campaign;
import com.rakuten.prj.entity.Donation;
import com.rakuten.prj.service.CampaignService;

/**
 * @author nishanth
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DonationRestController.class)
public class DonationRestControllerTest {
	@MockBean
	private CampaignService service;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getDonationsTest() throws Exception {
		String deadline = "26/01/2020";
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Campaign campaign = new Campaign(1, "Fund for flood relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active");
		List<Donation> donations = Arrays.asList(new Donation(1, campaign, "nishanth", "nish@gmail.com", "1234567890", new Date(), 156.0, "Paytm", "Paid"),
				new Donation(2, campaign, "nishanth", "nish@gmail.com", "1234567890", new Date(), 156.0, "Paytm", "Paid"));

		when(service.getDonations()).thenReturn(donations);

		// @formatter:off
		mockMvc.perform(get("/donations"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].name", is("nishanth")))
				.andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].name", is("nishanth")));
		// @formatter:on
		verify(service, times(1)).getDonations(); 
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void getDonationsByIdTest() throws Exception {
		String deadline = "26/01/2020";
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Campaign campaign = new Campaign(1, "Fund for flood relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active");
		Donation donation = new Donation(2, campaign, "nishanth", "nish@gmail.com", "1234567890", new Date(), 156.0, "Paytm", "Paid");
		when(service.getDonation(2)).thenReturn(donation);

		// @formatter:off
		mockMvc.perform(get("/donations/2"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(2)))
				.andExpect(jsonPath("$.name", is("nishanth")));
		// @formatter:on
		verify(service, times(1)).getDonation(2); 
		verifyNoMoreInteractions(service);

	}

	@Test
	public void addDonationTest() throws Exception {
		String deadline = "26/01/2020";
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Campaign c = new Campaign(1, "Fund for flood relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active");
		Donation d = new Donation(1, c, "nishanth", "nish@gmail.com", "1234567890", new Date(), 156.0, "Paytm", "Paid");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(d); 
		doNothing().when(service).addDonations(Mockito.any(Donation.class));
		// @formatter:off
		mockMvc.perform(post("/donations")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		// @formatter:on
		verify(service, times(1)).addDonations(Mockito.any(Donation.class));
	}
}
