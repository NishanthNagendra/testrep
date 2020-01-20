/**
 * 
 */
package com.rakuten.prj.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rakuten.prj.entity.Campaign;

/**
 * @author nishanth
 *
 */
public class CampaignClient {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String uri = "http://localhost:8080/campaigns";
		RestTemplate template = new RestTemplate(); // template to make REST calls

		getCampaignJson(template, uri);
		getCampaignList(template, uri);
//        addCampaign(template, uri);	
	}

	/**
	 * 
	 * @param template
	 * @param uri
	 */
//	private static void addCampaign(RestTemplate template, String uri) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		String deadline = "26/01/2020";
//		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//		Campaign c = new Campaign(0, "Fund for Orphans", date.parse(deadline), 0.0, 100000, "Non-refundable", "active");
//
//		ResponseEntity<Campaign> response = template.postForEntity(uri, c, Campaign.class);
//		System.out.println(response.getStatusCode());
//		System.out.println("Saved Campaign : " + response.getBody().getTitle());
//	}
	/**
	 * 
	 * @param template
	 * @param uri
	 */
	private static void getCampaignList(RestTemplate template, String uri) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		ResponseEntity<List<Campaign>> response = template.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Campaign>>() {
				});

		System.out.println(response.getStatusCode());
		List<Campaign> campaigns = response.getBody();
		for (Campaign c : campaigns) {
			System.out.println(c.getTitle() + "," + c.getDeadline());
		}
	}

	/**
	 * 
	 * @param template
	 * @param uri
	 */
	private static void getCampaignJson(RestTemplate template, String uri) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String campaignjson = template.getForObject(uri, String.class);
		System.out.println(campaignjson);
	}
}
