package com.wikitrends.front;

import org.springframework.data.annotation.Id;

public class article {

	@Id
	private String id;
	private String aTitle;
    private String date;

	public article (String id, String aTitle, String date) {
        this.id = id;
        this.aTitle = aTitle;
        this.date = date;
    }

}
