package spring.DependencyInjectionAdvancedSetter;

public class TrackCoach implements Coach {

	private FortuneServiceInterface fortuneService;

	private String email;
	private String team;

	@Override
	public void setFortuneService(FortuneServiceInterface fortuneService){
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setTeam(String team){
		this.team = team;
	}

	public String getEmail(){
		return email;
	}

	public String getTeam() {
		return team;
	}

}










