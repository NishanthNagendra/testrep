/**
 * 
 */
package com.rakuten.prj.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
import com.rakuten.prj.service.CampaignService;

/**
 * @author nishanth
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CampaignRestController.class)
public class CampaignRestControllerTest {
	@MockBean
	private CampaignService service;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getCampaignsTest() throws Exception {
		String deadline = "26/01/2020";
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		List<Campaign> campaigns = Arrays.asList(new Campaign(1, "Fund for cancer relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active"),
				new Campaign(2, "Fund for flood relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active"));

		when(service.getCampaigns()).thenReturn(campaigns);

		// @formatter:off
		mockMvc.perform(get("/campaigns"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].title", is("Fund for cancer relief")))
				.andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].title", is("Fund for flood relief")));
		// @formatter:on
		verify(service, times(1)).getCampaigns(); 
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void getCampaignByIdTest() throws Exception {
		String deadline = "26/01/2020";
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		List<Campaign> campaign = Arrays.asList(new Campaign(1, "Fund for cancer relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active"));

		when(service.getActiveCampaigns("active")).thenReturn(campaign);

		// @formatter:off
		mockMvc.perform(get("/campaigns?status=active"))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].status", is("active")));
		// @formatter:on
		verify(service, times(1)).getActiveCampaigns("active"); 
		verifyNoMoreInteractions(service);

	}

	@Test
	public void getActiveCampaignByTest() throws Exception {
		String deadline = "26/01/2020";
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Campaign campaign = new Campaign(1, "Fund for cancer relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active");

		when(service.getCampaign(1)).thenReturn(campaign);

		// @formatter:off
		mockMvc.perform(get("/campaigns/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.title", is("Fund for cancer relief")));
		// @formatter:on
		verify(service, times(1)).getCampaign(1); 
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void addCampaignTest() throws Exception {
		String deadline = "26/01/2020";
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Campaign c = new Campaign(1, "Fund for flood relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(c); 
		doNothing().when(service).addCampaign(Mockito.any(Campaign.class));
		// @formatter:off
		mockMvc.perform(post("/campaigns")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		// @formatter:on
		verify(service, times(1)).addCampaign(Mockito.any(Campaign.class));
	}
}
