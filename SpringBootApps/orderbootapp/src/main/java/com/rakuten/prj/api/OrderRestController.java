/**
 * 
 */
package com.rakuten.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.prj.entity.Order;
import com.rakuten.prj.service.OrderService;

/**
 * @author nishanth
 *
 */
@RestController
public class OrderRestController {
	@Autowired
	private OrderService service;
	
	@PostMapping()
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		service.placeOrder(order);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public @ResponseBody List<Order> getOrders() {
			return service.viewOrders();
	}
	
//	{
//        "customer": {
//            "email" : "nishanth1998@gmail.com"
//        },
//        "items" : [
//            {
//                "product" : {
//                    "id": 1
//                },
//                "quantity" : 1,
//                "amount" : 13500.00
//            },
//            {
//                "product" : {
//                    "id": 5
//                },
//                "quantity" : 2,
//                "amount" : 32000.00
//            }
//        ],
//        "total": 45500.00
//
//    }
//	To place order
}
