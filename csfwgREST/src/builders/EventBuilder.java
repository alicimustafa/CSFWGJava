package builders;

import java.sql.Date;

import entities.Event;

public class EventBuilder {

	private Event ev;
	
	public EventBuilder() {
		ev = new Event();
	}
	
	public EventBuilder id(int id) {
		ev.setId(id);
		return this;
	}
	
	public EventBuilder title(String title) {
		ev.setTitle(title);
		return this;
	}
	
	public EventBuilder date(Date date) {
		ev.setDate(date);
		return this;
	}
	
	public EventBuilder evetEnd(Date date) {
		ev.setEventEnd(date);
		return this;
	}
	
	public EventBuilder repeatType(int type) {
		ev.setRepeatType(type);
		return this;
	}
	
	public EventBuilder description(String desc) {
		ev.setDescription(desc);
		return this;
	}
	
	public Event build() {
		return ev;
	}
}
