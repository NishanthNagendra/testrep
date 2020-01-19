/**
 * 
 */
package com.rakuten;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakuten.prj.entity.Product;

/**
 * @author nishanth
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Product p = new Product(44, "mouse", 40.0, "computer", 4);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(System.out, p);
	}

}
