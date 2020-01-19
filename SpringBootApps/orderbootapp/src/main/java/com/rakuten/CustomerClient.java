/**
 * 
 */
package com.rakuten;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rakuten.prj.entity.Customer;

/**
 * @author nishanth
 *
 */
public class CustomerClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String uri = "http://localhost:8080/customers";
        RestTemplate template = new RestTemplate(); // template to make REST calls

        getCustomerJson(template, uri);
        getCustomerList(template, uri);
        addCustomer(template, uri);	// add product to database
	}

	private static void addCustomer(RestTemplate template, String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        Customer c = new Customer("nishanth1998@gmail.com", "Nishanth");

        ResponseEntity<Customer> response = template.postForEntity(uri, c, Customer.class);
        System.out.println(response.getStatusCode());
        System.out.println("Saved Customer : " + response.getBody().getEmail());
    }

    private static void getCustomerList(RestTemplate template, String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        ResponseEntity<List<Customer>> response = template.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>() {
                });

        System.out.println(response.getStatusCode());
        List<Customer> customers = response.getBody();
        for (Customer c : customers) {
            System.out.println(c.getFirstName() + "," + c.getEmail());
        }
    }

    private static void getCustomerJson(RestTemplate template, String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String customerjson = template.getForObject(uri, String.class);
        System.out.println(customerjson);
    }

}
