package com.wikitrends.front;
import java.awt.List;
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


@Controller
public class indexNew {

	
	@RequestMapping(value="/{LANG}/index.idx",method = RequestMethod.GET)
	public String home(ModelMap modelMap) throws UnknownHostException {
		MongoClient mongoclient1 = new MongoClient("localhost:27017");
		MongoOperations mongoops = new MongoTemplate(mongoclient1,"wc");
		
		List result = mongoops.find(query(where()), link.class,"en_threehour");
		
		
		return "home";
		
	}
	
	
	
}
