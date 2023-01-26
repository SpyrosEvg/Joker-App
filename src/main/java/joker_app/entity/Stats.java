package joker_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Stats {

	private Numbers[] numbers;
	
	public Stats() {
		
	}

	public  Numbers[] getNumbers() {
		return numbers;
	}

	public void setNumbers(Numbers[] numbers) {
		this.numbers = numbers;
	}
	
	
	
}
