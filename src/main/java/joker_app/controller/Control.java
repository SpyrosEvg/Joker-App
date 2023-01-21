package joker_app.controller;



import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.fasterxml.jackson.databind.ObjectMapper;

import joker_app.entity.Content;
import joker_app.entity.Joker;
import joker_app.entity.LastJoker;
import joker_app.entity.MonthJokers;
import joker_app.entity.prizeCategories;



@Controller
@RequestMapping("/joker")
public class Control {
	

	


	@GetMapping("/SpecificDrawInput")
	public void SpecificDrawInput(@RequestParam("drawId") String tempDrawId , Model theModel)  {
		SpecificDraw(tempDrawId,theModel);
	}
	
	@GetMapping("/SpecificDraw")
	public String SpecificDraw(String drawId ,Model theModel){
		try {
			
			URL jsonUrl = new URL("https://api.opap.gr/draws/v3.0/5104/"+drawId);
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read Json file and convert to java pojo
			Joker theJoker =mapper.readValue(jsonUrl,Joker.class);
			
		    String id=theJoker.getDrawId();
		    Timestamp drawTime=theJoker.getDrawTime();
		    ArrayList<Integer> numberList = theJoker.getwinningNumbers().getlist();
		    ArrayList<Integer> bonus = theJoker.getwinningNumbers().getBonus();
		    prizeCategories[] prizeList = theJoker.getprizeCategories();
		    
		    
		    theModel.addAttribute("id",id);
		    theModel.addAttribute("drawTime",drawTime);
		    theModel.addAttribute("numberList", numberList);
		    theModel.addAttribute("bonus", bonus);
		    theModel.addAttribute("prize", prizeList);
		}
	
		catch (Exception e ) {
			e.printStackTrace();
		} 
		

		return "SpecificDraw";
	}
	
	@GetMapping("/lastGame")
	public String lastGame(Model theModel) {
		
		try {
			
			URL jsonUrl = new URL("https://api.opap.gr/draws/v3.0/5104/last-result-and-active");
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read Json file and convert to java pojo
			LastJoker theLastJoker =mapper.readValue(jsonUrl,LastJoker.class);
			
			String id=theLastJoker.getLast().getDrawId();
		    Timestamp drawTime=theLastJoker.getLast().getDrawTime();
		    ArrayList<Integer> numberList = theLastJoker.getLast().getwinningNumbers().getlist();
		    ArrayList<Integer> bonus = theLastJoker.getLast().getwinningNumbers().getBonus();
		    prizeCategories[] prizeList = theLastJoker.getLast().getprizeCategories();
		    
		    
		    theModel.addAttribute("id",id);
		    theModel.addAttribute("drawTime",drawTime);
		    theModel.addAttribute("numberList", numberList);
		    theModel.addAttribute("bonus", bonus);
		    theModel.addAttribute("prize", prizeList);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "LastGame";
	}
	
	@GetMapping("/JokerMonth")
	public String JokerMonth(Model theModel) {
		try {
			
			URL jsonUrl = new URL("https://api.opap.gr/draws/v3.0/5104/draw-date/2022-01-01/2022-01-15");
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read Json file and convert to java pojo
			MonthJokers theMonthJokers =mapper.readValue(jsonUrl,MonthJokers.class);
			
				int length = theMonthJokers.getContent().length;
				
				Content[] theContent = theMonthJokers.getContent();
				
				theModel.addAttribute("content",theContent);
				
				for(int i=1;i<length;i++) {
					String id=theContent[i].getDrawId();
				    Timestamp drawTime=theContent[i].getDrawTime();
				    ArrayList<Integer> numberList = theContent[i].getwinningNumbers().getlist();
				    ArrayList<Integer> bonus = theContent[i].getwinningNumbers().getBonus();
				    prizeCategories[] prizeList = theContent[i].getprizeCategories();
				    
				   
				    theModel.addAttribute("id",id);
				    theModel.addAttribute("drawTime",drawTime);
				    theModel.addAttribute("numberList", numberList);
				    theModel.addAttribute("bonus", bonus);
				    theModel.addAttribute("prize", prizeList);
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "JokerMonth";
	}
	
}
