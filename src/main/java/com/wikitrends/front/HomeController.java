package com.wikitrends.front;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.MongoClient;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
    /**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnknownHostException 
	 */

    /*note:                 /{SampleSha}  or new var name replacing goes here when site ready */
	@RequestMapping(value = "/spamweb/{Language}/{ShaHash}", method = RequestMethod.GET)
	public String home(@PathVariable("Language") String Lang, 
			@PathVariable("ShaHash") String SHA,
			ModelMap modelMap) throws UnknownHostException {
		
        MongoClient mongoclient1 = new MongoClient("10.219.4.172:27017");
        MongoOperations mongoOps = new MongoTemplate(mongoclient1,"wc");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		modelMap.addAttribute("serverTime", formattedDate );
        modelMap.addAttribute("name", Lang);
        modelMap.addAttribute("sha", SHA);

        mongoOps.insert(new article(SHA,Lang,SHA));
		return "spamweb";
	}
	
}
