package com.rakuten.prj.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.rakuten.prj.entity.Product;
import com.rakuten.prj.service.OrderService;

/**
 * 
 * @author nishanth
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductRestController.class)
public class ProductRestControllerTest {
	@MockBean
	private OrderService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getProductsTest() throws Exception {
		List<Product> products = Arrays.asList(new Product(1, "a", 500.00, "c1", 100),
				new Product(2, "b", 1500.00, "c2", 100));

		// mocking
		when(service.getProducts()).thenReturn(products);

		// @formatter:off
		mockMvc.perform(get("/products"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].name", is("a")))
				.andExpect(jsonPath("$[1].id", is(2))).andExpect(jsonPath("$[1].name", is("b")));
		// @formatter:on
		verify(service, times(1)).getProducts(); // verify the service is called one time
		//verifyNoMoreInteractions(service);

	}

	@Test
	public void addProductTest() throws Exception {
		Product p = new Product(0, "b", 1500.00, "c2", 100);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p); // get JSON for Product p

		// mocking if Product type is passed to service he should not throw any
		// exception
		doNothing().when(service).addProduct(Mockito.any(Product.class));
		// @formatter:off
		mockMvc.perform(post("/products").content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		// @formatter:on
		verify(service, times(1)).addProduct(Mockito.any(Product.class));
	}
}
