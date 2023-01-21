package joker_app.entity;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Content {
	
	private String drawId;
	private Timestamp drawTime;
	
	private winningNumbers winningNumbers;
	
	private prizeCategories[] prizeCategories;
	
	public Content(){
		
	}

	public String getDrawId() {
		return drawId;
	}

	public void setDrawId(String drawId) {
		this.drawId = drawId;
	}

	public Timestamp getDrawTime() {
		return drawTime;
	}

	public void setDrawTime(Timestamp drawTime) {
		this.drawTime = drawTime;
	}

	public winningNumbers getwinningNumbers() {
		return winningNumbers;
	}

	public void setwinningNumbers(winningNumbers thewinningNumbers) {
		this.winningNumbers = thewinningNumbers;
	}

	public prizeCategories[] getprizeCategories() {
		return prizeCategories;
	}

	public void setprizeCategories(prizeCategories[] prizeCategories) {
		this.prizeCategories = prizeCategories;
	}
	
}
