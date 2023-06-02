package tokacode.todoplanner.model;

public class AppResponse {

	private String answer;
	private Long hoursPerDay;
	
	public AppResponse(String answer, Long hoursPerDay) {
		this.answer = answer;
		this.hoursPerDay = hoursPerDay;
	}

	public String getAnswer() {
		return answer;
	}

	public Long getHoursPerDay() {
		return hoursPerDay;
	}

	
	
}
