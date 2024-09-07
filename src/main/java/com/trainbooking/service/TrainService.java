package com.trainbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainbooking.dao.ReceiptRepository;
import com.trainbooking.dao.UserRepository;
import com.trainbooking.model.Receipt;
import com.trainbooking.model.Seat;
import com.trainbooking.model.User;

@Service
public class TrainService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	public Receipt purchaseTcket(User user) {
		
		userRepository.save(user);
		
		String section = (receiptRepository.count() % 2 == 0) ? "A" : "B";
		int seatNumber = (int) (receiptRepository.count() + 1);
		Seat seat = new Seat(section, seatNumber);
		
		Receipt receipt = new Receipt("London", "France", 20.0, user, seat);
		return receiptRepository.save(receipt);
			
	}
	
	public Receipt getReceipt(String email) {
		return receiptRepository.findByUserEmail(email);
	}
	
	public List<Receipt> getAllReceipts(){
		return receiptRepository.findAll();
	}
	
	public boolean removeUser(String email) {
		Receipt receipt = receiptRepository.findByUserEmail(email);
		if (receipt != null) {
			receiptRepository.delete(receipt);
			return true;
		}
		return false;
	}
	
	public String modifySeat(String email, String newSection) {
		Receipt receipt = receiptRepository.findByUserEmail(email);
		if (receipt == null) {
			return "User Not Found";
		}
		Seat newSeat = new Seat(newSection, receipt.getSeat().getSeatNumber());
		receipt.setSeat(newSeat);
		
		receiptRepository.save(receipt);
		return "Seat modified successfully";
	}	

}
