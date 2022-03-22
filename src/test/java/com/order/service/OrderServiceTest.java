package com.order.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.order.entity.OrderVO;
import com.order.repository.OrderRepository;
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
	@InjectMocks
	OrderService service;
	
	@Mock
	OrderRepository repo;
	@Test
	void testSave() {
		OrderVO order = new OrderVO();
		order.setId(1);
		when(repo.save(order )).thenReturn(order);
		Integer id = service.save(order);
		assertEquals(1, id);
	}
	@Test
	void testSaveWithPriceBetween100And200() {
		OrderVO order = new OrderVO();
		order.setId(1);
		order.setPrice(150);
		when(repo.save(order )).thenReturn(order);
		Integer id = service.save(order);
		assertEquals(1, id);

	}
	
	@Test
	void testSaveWithPriceBetween300And400() {
		OrderVO order = new OrderVO();
		order.setId(1);
		order.setPrice(350);
		when(repo.save(order )).thenReturn(order);
		Integer id1 = service.save(order);
		assertEquals(1, id1);

	}

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
