package com.trainbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainbooking.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long>{
	Receipt findByUserEmail(String email);

}
