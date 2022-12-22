package joker_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class prizeCategories {
	
	private int id;
	private float divident;
	private int winners;
	private double distributed;
	private double jackpot;
	
	public prizeCategories() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getDivident() {
		return divident;
	}

	public void setDivident(float divident) {
		this.divident = divident;
	}

	public int getWinners() {
		return winners;
	}

	public void setWinners(int winners) {
		this.winners = winners;
	}

	public double getDistributed() {
		return distributed;
	}

	public void setDistributed(double distributed) {
		this.distributed = distributed;
	}

	public double getJackpot() {
		return jackpot;
	}

	public void setJackpot(double jackpot) {
		this.jackpot = jackpot;
	}
	
	
}
