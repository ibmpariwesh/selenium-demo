package com.order.service;

import java.util.List;

import com.order.entity.OrderVO;

public interface IOrderService {
	Integer save(OrderVO order);

	List<OrderVO> getAllOrders();

	void deleteOrder(Integer id) throws Exception;
}
