package com.wikitrends.front;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.MongoClient;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnknownHostException 
	 */

    /*note:                 /{SampleSha}  or new var name replacing goes here when site ready */
	@RequestMapping(value = "/spamweb", method = RequestMethod.GET)
	public String home(ModelMap modelMap) throws UnknownHostException {

        MongoClient mongoclient1 = new MongoClient("localhost:27017");
        MongoOperations mongoOps = new MongoTemplate(mongoclient1,"wc");

		String aTitle = "Spammy_Wikipedia_Article";
        String SampleSha = "1eaacdb1231234536dfeac32ac32d78a";
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		modelMap.addAttribute("serverTime", formattedDate );
        modelMap.addAttribute("name", aTitle);
        modelMap.addAttribute("sha", SampleSha);

        mongoOps.insert(new article(SampleSha,aTitle,formattedDate));
		return "spamweb";
	}
	
}
