package com.order.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.order.entity.OrderVO;
import com.order.service.IOrderService;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
	@InjectMocks
	OrderController controller;// dependent
	@Mock
	IOrderService service;// dependency

	@Test
	void testCreateOrder() {
		// A-Arrange
		System.out.println(controller.service);
		OrderVO order = new OrderVO();
		order.setPrice(100);
		when(service.save(order)).thenReturn(1);
//		Act
		Integer id = controller.createOrder(order);
		// Assertion
		assertEquals(1, id);
	}

	@Test
	void testCreateOrderWhenPriceIsNegative() {
		OrderVO order = new OrderVO();
		order.setPrice(-100);
		assertThrows(IllegalArgumentException.class, () -> {
			controller.createOrder(order);
		});
	}

	@Test
	void testHandleException() {
		Exception exception = new IllegalAccessException("Something wrong");
		String message = controller.handleException(exception );
		assertEquals("Something wrong", message);
	}
//
//	@Test
//	void testGetAllOrders() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteOrder() {
//		fail("Not yet implemented");
//	}

}
