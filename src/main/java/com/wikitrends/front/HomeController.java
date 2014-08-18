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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.MongoClient;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
       private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	

    /*note:                 /{SampleSha}  or new var name replacing goes here when site ready */
	@RequestMapping(value = "/spamweb/{Language}/{id}/{ArticleTitle}", method = RequestMethod.GET)
	public String home(@PathVariable("Language") String Lang, 
			@PathVariable("id") String ID,
			@PathVariable("ArticleTitle") String ArticleTitle,
			ModelMap modelMap) throws UnknownHostException {
		
        MongoClient mongoclient1 = new MongoClient("10.221.135.154:27017");
        MongoOperations mongoOps = new MongoTemplate(mongoclient1,"wc");

	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		 
	    String formattedDate = dateFormat.format(date);
		
	    modelMap.addAttribute("serverTime", formattedDate );
        modelMap.addAttribute("name", Lang);
        modelMap.addAttribute("sha", ID);
        modelMap.addAttribute("title", ArticleTitle);

        mongoOps.insert(new spamlinks(ID,ArticleTitle,Lang));
		return "home";
	}
	
}
