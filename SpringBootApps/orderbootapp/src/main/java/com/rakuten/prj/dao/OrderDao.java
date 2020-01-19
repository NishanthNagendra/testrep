package com.rakuten.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakuten.prj.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
