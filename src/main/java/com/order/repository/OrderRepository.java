package com.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.entity.OrderVO;

@Repository
public interface OrderRepository extends JpaRepository<OrderVO, Integer> {
//	@Query(nativeQuery = true, value = "SELECT item from ordervo ")
//	List<OrderVO> myCustomQuery();
}
