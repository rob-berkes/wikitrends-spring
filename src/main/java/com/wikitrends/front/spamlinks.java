package com.wikitrends.front;

import org.springframework.data.annotation.Id;

public class spamlinks {
	
	@Id
	String id;
	String title;
	String language;
	
	public spamlinks(String id, String title, String language) {
		this.id = id;
		this.title = title;
		this.language = language;
	
	}
}
