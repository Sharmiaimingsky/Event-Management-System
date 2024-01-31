package com.sunbeam.ems.dtos;

public class EventsEntryDTO {

	private int id;
	private int sid;
	private int uid;
	public EventsEntryDTO() {
		super();
	}
	public EventsEntryDTO(int id, int sid, int uid) {
		super();
		this.id = id;
		this.sid = sid;
		this.uid = uid;
	}
	public int getId() {
		return id;
	}
	public int getSid() {
		return sid;
	}
	public int getUid() {
		return uid;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "EventsEntryDTO [id=" + id + ", sid=" + sid + ", uid=" + uid + "]";
	}
	
	
}
