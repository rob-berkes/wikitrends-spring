package com.wikitrends.front;

import org.springframework.data.annotation.Id;

public class article {

	@Id
	private String id;
	private String LANG;
    private String DATE;
 
	public article (String id, String LANG, String date) {
        this.id = id;
        this.LANG = LANG;
        this.DATE = date;
    }

}
