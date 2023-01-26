package joker_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MonthJokers {

	
	private Content[] content;
	
	public MonthJokers() {
		
	}

	public Content[] getContent() {
		return content;
	}

	public void setContent(Content[] content) {
		this.content = content;
	}

	
}
