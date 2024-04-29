package com.model;

import java.util.List;

public abstract class AdoptionEvent {
	//event_id,event_name,event_date,location
	private int eventId;
	private String eventName;
	private String eventDate;
	private String EventLocation;
	
	public abstract int addParticipant();
	public abstract List<Participant> listParticipant();
	public abstract Event hostEvent();
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate
				+ ", EventLocation=" + EventLocation + "]";
	}
	public Event(int eventId, String eventName, String eventDate, String eventLocation) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		EventLocation = eventLocation;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventLocation() {
		return EventLocation;
	}
	public void setEventLocation(String eventLocation) {
		EventLocation = eventLocation;
	}
}
