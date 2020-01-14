/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import com.rakuten.prj.entity.Order;

/**
 * @author nishanth
 *
 */
public interface OrderDao {
	void placeOrder(Order order);
	List<Order> getOrders();
}
