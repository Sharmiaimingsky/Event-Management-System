package com.sunbeam.ems.dtos;

public class EventsVendorsDTO {

	private int eventsid;
	private int vendorid;
	public int getEventsid() {
		return eventsid;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setEventsid(int eventsid) {
		this.eventsid = eventsid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public EventsVendorsDTO(int eventsid, int vendorid) {
		super();
		this.eventsid = eventsid;
		this.vendorid = vendorid;
	}
	@Override
	public String toString() {
		return "EventsVendorsDTO [eventsid=" + eventsid + ", vendorid=" + vendorid + "]";
	}
	public EventsVendorsDTO() {
		super();
	}
	
	
}
