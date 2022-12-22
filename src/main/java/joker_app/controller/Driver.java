package joker_app.controller;


import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import joker_app.entity.Joker;
import joker_app.entity.prizeCategories;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			URL jsonUrl = new URL("https://api.opap.gr/draws/v3.0/5104/2400");
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read Json file and convert to java pojo
			Joker theJoker =mapper.readValue(jsonUrl,Joker.class);
			
			//Joker theJoker =mapper.readValue(new File("data/data.json"),Joker.class);

			System.out.println(theJoker.getDrawId());
			System.out.println(theJoker.getDrawTime());
			
			
			for(Integer tempList : theJoker.getwinningNumbers().getlist()) {
				System.out.print(tempList+" ");
			}
			
			System.out.println();
			
			for(prizeCategories tempPrize : theJoker.getprizeCategories()) {
				System.out.print(tempPrize.getId()+" ");
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
