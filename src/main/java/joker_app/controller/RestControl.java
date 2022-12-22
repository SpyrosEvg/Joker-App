package joker_app.controller;


import java.net.URL;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import joker_app.entity.Joker;
import joker_app.entity.prizeCategories;
import joker_app.entity.winningNumbers;


@Controller
@RequestMapping("/joker")
public class RestControl {
	
	@GetMapping("/test")
	public String Test(Model theModel) {
		String id= null;
		try {
			
			URL jsonUrl = new URL("https://api.opap.gr/draws/v3.0/5104/2400");
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read Json file and convert to java pojo
			Joker theJoker =mapper.readValue(jsonUrl,Joker.class);
			
			//Joker theJoker =mapper.readValue(new File("data/data.json"),Joker.class);

		    id=theJoker.getDrawId();
		    winningNumbers winlist = theJoker.getwinningNumbers();
		    ArrayList<Integer> numberList = theJoker.getwinningNumbers().getlist();
		    ArrayList<Integer> bonus = theJoker.getwinningNumbers().getBonus();
		    prizeCategories[] prizeList = theJoker.getprizeCategories();
		    
		    
		    theModel.addAttribute("id",id);
		    theModel.addAttribute("test", winlist);
			/*
			 * theModel.addAttribute("FirstNum",numberList[0]);
			 * theModel.addAttribute("SecondNum",numberList[1]);
			 * theModel.addAttribute("ThirdNum",numberList[2]);
			 * theModel.addAttribute("ForthNum",numberList[3]);
			 * theModel.addAttribute("FifthNum",numberList[4]);
			 * theModel.addAttribute("bonus",bonus[0]);
			 */
		    theModel.addAttribute("numberList", numberList);
		    theModel.addAttribute("prize", prizeList);
		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
		

		return "test";
	}
}
