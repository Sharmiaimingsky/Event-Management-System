package com.sunbeam.ems.dtos;

public class EventsDTO {
	//OrderId	Event	Venue	venueCapacity	Duration	Amount	Ratings	Feedback
		private int eventid;
		
		private String payment_status;
		private int  amount;
		
		public EventsDTO() {
			super();
		}

		public int getEventid() {
			return eventid;
		}

		public void setEventid(int eventid) {
			this.eventid = eventid;
		}

		public String getPayment_status() {
			return payment_status;
		}

		public void setPayment_status(String payment_status) {
			this.payment_status = payment_status;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public EventsDTO(int eventid, String payment_status, int amount) {
			super();
			this.eventid = eventid;
			this.payment_status = payment_status;
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "EventsDTO [eventid=" + eventid + ", payment_status=" + payment_status + ", amount=" + amount + "]";
		}

		
		
	}

