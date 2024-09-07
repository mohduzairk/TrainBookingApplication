package com.trainbookingapplication.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Receipt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fromLocation;
	private String toLocation;
	private double pricePaid;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Seat seat;

	public Receipt() {
		
	}

	public Receipt(String fromLocation, String toLocation, double pricePaid, User user, Seat seat) {
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.pricePaid = pricePaid;
		this.user = user;
		this.seat = seat;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public double getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	

}
