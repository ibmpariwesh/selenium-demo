package com.order.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.entity.OrderVO;
import com.order.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {
	@Autowired
	OrderRepository orderRepo;

	@Override
	public Integer save(OrderVO order) {
		// business logic
		float price = order.getPrice();
		if ((price > 100 && price < 200 )
				|| (price > 300 && price < 400 ))
			order.setPrice((float) (price * 0.9F));
		OrderVO savedOrder = orderRepo.save(order);

		return savedOrder.getId();
	}

	@Override
	public List<OrderVO> getAllOrders() {
		// logic

		return orderRepo.findAll();
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deleteOrder(Integer id) throws Exception {
		orderRepo.deleteById(id);
//		throw new Exception();
	}

}
