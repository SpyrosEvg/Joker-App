package joker_app.controller;



import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mchange.lang.ArrayUtils;

import joker_app.entity.Content;
import joker_app.entity.Joker;
import joker_app.entity.LastJoker;
import joker_app.entity.MonthJokers;
import joker_app.entity.prizeCategories;



@Controller
@RequestMapping("/joker")
public class Control {
	
	

	
	@GetMapping("/SpecificDraw")
	public String SpecificDraw(String drawId , Model theModel) throws FileNotFoundException{
		try {
			
			URL jsonUrl = new URL("https://api.opap.gr/draws/v3.0/5104/"+drawId);
			
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read Json file and convert to java pojo
			Joker theJoker =mapper.readValue(jsonUrl,Joker.class);
			
			System.out.println(jsonUrl);
			
		    String id=theJoker.getDrawId();
		    Timestamp drawTime=theJoker.getDrawTime();
		    ArrayList<Integer> numberList = theJoker.getwinningNumbers().getlist();
		    ArrayList<Integer> bonus = theJoker.getwinningNumbers().getBonus();
		    prizeCategories[] prizeList = theJoker.getprizeCategories();
		    
		    
		    SwitchIdWithCategories(prizeList);
		    
		    theModel.addAttribute("id",id);
		    theModel.addAttribute("drawTime",drawTime);
		    theModel.addAttribute("numberList", numberList);
		    theModel.addAttribute("bonus", bonus);
		    theModel.addAttribute("prize", prizeList);
		    
			
	
		}
		catch (Exception e ) {
			
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
		    
		    SwitchIdWithCategories(prizeList);
		    
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
	
	@GetMapping("/JokerMonthInput")
	public String  JokerMonthInput(@RequestParam("year") String Year ,@RequestParam("month") String Month, Model theModel) throws FileNotFoundException {

		JokerMonth(Year,Month,theModel);
		
		return "JokerMonth";
	}
	
	@GetMapping("/JokerMonth")
	public String JokerMonth(String Year, String Month ,Model theModel) {
		if(Year!=null) {
			try {
				URL jsonUrlFirstHalf = new URL("https://api.opap.gr/draws/v3.0/5104/draw-date/"+Year+"-"+Month+"-01/"+Year+"-"+Month+"-15");
				URL jsonUrlSecondHalf = new URL("https://api.opap.gr/draws/v3.0/5104/draw-date/"+Year+"-"+Month+"-15/"+Year+"-"+Month+"-31");

				System.out.println(jsonUrlFirstHalf);
				System.out.println(jsonUrlSecondHalf);

				//create object mapper
				ObjectMapper mapper = new ObjectMapper();

				//read Json file and convert to java pojo
				MonthJokers theMonthJokersFirstHalf =mapper.readValue(jsonUrlFirstHalf,MonthJokers.class);
				MonthJokers theMonthJokersSecondHalf =mapper.readValue(jsonUrlSecondHalf,MonthJokers.class);

				int lengthA = theMonthJokersFirstHalf.getContent().length;
				int lengthB	= theMonthJokersSecondHalf.getContent().length;
				int totalLength= lengthA + lengthB; 
				
				Content[] theContent = new Content[totalLength];
				
				//merge the json Data into one array
				System.arraycopy(theMonthJokersSecondHalf.getContent(), 0, theContent, 0, lengthB);
				System.arraycopy(theMonthJokersFirstHalf.getContent(), 0, theContent, lengthB, lengthA);
				
				//Reverse the array order
				Collections.reverse(Arrays.asList(theContent));
				
				
				theModel.addAttribute("content",theContent);
				
				
				for(int i=0;i<=totalLength;i++) {
					String id=theContent[i].getDrawId();
				    Timestamp drawTime=theContent[i].getDrawTime();
				    ArrayList<Integer> numberList = theContent[i].getwinningNumbers().getlist();
				    ArrayList<Integer> bonus = theContent[i].getwinningNumbers().getBonus();
				    prizeCategories[] prizeList = theContent[i].getprizeCategories();
				    
				    SwitchIdWithCategories(prizeList);
				   
				    theModel.addAttribute("id",id);
				    theModel.addAttribute("drawTime",drawTime);
				    theModel.addAttribute("numberList", numberList);
				    theModel.addAttribute("prize", prizeList);
				}
			}
			catch(Exception e) {
				
			}
		
		}
		
		return "JokerMonth";
	}
	
public void SwitchIdWithCategories(prizeCategories[] prizeList) {
		
		for(int i=0;i<prizeList.length;i++) {
			
			switch(prizeList[i].getId()) {
			case "1":
				prizeList[i].setId("5+1");
				break;
			case "2":
				prizeList[i].setId("5");
				break;
			case "3":
				prizeList[i].setId("4+1");
				break;
			case "4":
				prizeList[i].setId("4");
				break;
			case "5":
				prizeList[i].setId("3+1");
				break;
			case "6":
				prizeList[i].setId("3");
				break;
			case "7":
				prizeList[i].setId("2+1");
				break;
			case "8":
				prizeList[i].setId("1+1");
				break;
		}
			
		}
	}
	
	
		
	
}
