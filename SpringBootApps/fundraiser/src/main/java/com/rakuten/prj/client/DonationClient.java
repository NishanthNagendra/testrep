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

import com.rakuten.prj.entity.Donation;

/**
 * @author nishanth
 *
 */
public class DonationClient {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String uri = "http://localhost:8080/donations";
		RestTemplate template = new RestTemplate();
//		addDonation(template, uri);
		getDonationJson(template, uri);
		getDonationList(template, uri);
	}

	/**
	 * 
	 * @param template
	 * @param uri
	 */
//	public static void addDonation(RestTemplate template, String uri) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		String deadline = "26/01/2020";
//		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//		Campaign c = new Campaign(1, "Fund for flood relief", date.parse(deadline), 0.0, 100000, "Non-refundable", "active");
//		Donation d = new Donation(0, c, "ABC", "abc@gmail.com", "1234567890", new Date(), 2349, "Google Pay", "Paid");
//		
//		ResponseEntity<Donation> response = template.postForEntity(uri, d, Donation.class);
//		System.out.println(response.getStatusCode());
//		System.out.println("Saved Donation : " + response.getBody().getEmail());
//	}
	/**
	 * 
	 * @param template
	 * @param uri
	 */
	private static void getDonationList(RestTemplate template, String uri) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		ResponseEntity<List<Donation>> response = template.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Donation>>() {
				});

		System.out.println(response.getStatusCode());
		List<Donation> donations = response.getBody();
		for (Donation d : donations) {
			System.out.println(d.getName() + "," + d.getAmount());
		}
	}

	/**
	 * 
	 * @param template
	 * @param uri
	 */
	private static void getDonationJson(RestTemplate template, String uri) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String donationjson = template.getForObject(uri, String.class);
		System.out.println(donationjson);
	}
}
