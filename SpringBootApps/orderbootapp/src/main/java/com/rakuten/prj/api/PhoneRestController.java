/**
 * 
 */
package com.rakuten.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.prj.entity.Phone;
import com.rakuten.prj.service.PhoneService;

/**
 * @author nishanth
 *
 */
@RestController
@RequestMapping("phones")
// CORS can be removed after npm run build ad pasting contents to static in resuources
//@CrossOrigin(origins = "http://localhost:3000")
public class PhoneRestController {
	@Autowired
	private PhoneService service;
	
	@GetMapping()
	public @ResponseBody List<Phone> getPhones() {
		return service.getPhones();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Phone getPhone(@PathVariable("id") int id) {
		return service.getPhone(id);
	}
	
	@PostMapping()
	public ResponseEntity<Phone> addPhone(@RequestBody Phone p){
		service.addPhone(p);
		return new ResponseEntity<Phone>(p, HttpStatus.CREATED);
	}
}
