package com.wikitrends.front;

import org.springframework.data.annotation.Id;

public class link {
	
	@Id
	String id;
	String title;
	int rollavg;
	int place;
	
	public link(String id, String title, int rollavg, int place) {
		this.id = id;
		this.title = title;
		this.rollavg = rollavg;
		this.place = place;
	}
}
