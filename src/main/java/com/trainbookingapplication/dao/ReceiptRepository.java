package com.trainbookingapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainbookingapplication.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long>{
	Receipt findByUserEmail(String email);

}
