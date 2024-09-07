package com.trainbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainbooking.model.Receipt;
import com.trainbooking.model.User;
import com.trainbooking.service.TrainService;

@RestController
@RequestMapping("/api/train")
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	
	@PostMapping("/purchase")
	public Receipt purchaseTicket(@RequestBody User user) {
		return trainService.purchaseTcket(user);
	}
	
	@GetMapping("/receipts/{email}")
	public Receipt getReceipt(@PathVariable String email) {
		return trainService.getReceipt(email);
	}
	
	@GetMapping()
	public List<Receipt> getAllReceipts() {
		return trainService.getAllReceipts();
	}
	
	@DeleteMapping("/remove/{email}")
	public String removeUser(String email) {
		boolean removed = trainService.removeUser(email);
		return removed ? "User removed successfully." : "User not found.";
	}
	
	@PutMapping("/modify/{email}")
	public String modifySeat(@PathVariable String email, @RequestParam String newSection) {
		return trainService.modifySeat(email, newSection);
	}

}
