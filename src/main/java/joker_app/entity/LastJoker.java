package joker_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastJoker {
	

	private Last last;
	
	public LastJoker(){
		
	}
	
	public Last getLast() {
		return last;
	}

	public void setLast(Last last) {
		this.last = last;
	}

}
