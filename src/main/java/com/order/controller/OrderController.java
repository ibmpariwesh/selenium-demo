package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.OrderVO;
import com.order.service.IOrderService;

@RequestMapping("order")
@RestController
public class OrderController {
	@Autowired
	IOrderService service;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Integer createOrder(@RequestBody OrderVO order) {
		System.out.println(order.getItem());
		if (order.getPrice() <= 0) {
			throw new IllegalArgumentException();
		}
		return service.save(order);
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	String handleException(Exception exception) {
		return exception.getMessage();
	}

	@GetMapping
	List<OrderVO> getAllOrders() {
		return service.getAllOrders();
	}

	@DeleteMapping("/{id}")
	void deleteOrder(@PathVariable Integer id) throws Exception {
		service.deleteOrder(id);

	}
}
