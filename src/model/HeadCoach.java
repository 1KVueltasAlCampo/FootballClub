package model;
public class HeadCoach extends Coach implements PriceAndLevel{
	private int teamsInCharge;
	private int championshipsAchieved;
	private double coachPrice;
	private double coachLevel;
	/**
	Constructor method of the class "HeadCoach" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type HeadCoach <br>
	@param name String that indicates the name of the head coach
	@param identifier String that indicates the identifier of the head coach
	@param salary int that indicates the salary of the head coach
	@param experienceYears int that indicates the years of experience of the head coach
	@param teamsInCharge int that indicates the number of teams the head coach has in charge
	@param championshipsAchieved int that indicates the number of championships achieved by the head coach
	*/
	public HeadCoach(String name,String identifier,int salary,int experienceYears,int teamsInCharge,int championshipsAchieved){
		super(name,identifier,salary,experienceYears);
		this.teamsInCharge=teamsInCharge;
		this.championshipsAchieved=championshipsAchieved;
	}
	/**
	@param teamsInCharge int that indicates the number of teams the head coach has in charge
	*/
	public void setTeamsInCharge(int teamsInCharge){
		this.teamsInCharge=teamsInCharge;
	}
	/**
	@return The number of teams the head coach has in charge
	*/
	public int getTeamsInCharge(){
		return teamsInCharge;
	}
	/**
	@param championshipsAchieved int that indicates the number of championships achieved by the head coach
	*/
	public void setChampionshipsAchieved(int championshipsAchieved){
		this.championshipsAchieved=championshipsAchieved;
	}
	/**
	@return The number of championships achieved by the head coach
	*/
	public int getChampionshipsAchieved(){
		return championshipsAchieved;
	}
	/**
	Calculates the coach price <br>
	<b> pre: </b> The coach must previously have a salary, years of experience and a number of championships achieved <br>
	<b> post: </b> Based on the salary, the years of experience and the number of championships achieved, a double representing the coach price is obtained <br>
	@return price
	*/
	@Override
	public double calculatePrice(){
		double price = (getSalary()*10)+(getExperienceYears()*100)+(getChampionshipsAchieved()*50);
		return price;
	}
	/**
	Updates the coach price <br>
	<b> pre: </b> The coach must previously have a salary, years of experience and a number of championships achieved <br>
	<b> post: </b> Based on the salary, the years of experience and the number of championships achieved, updates the price of the coach <br>
	*/
	@Override
	public void updatePrice(){
		coachPrice=calculatePrice();
	}
	/**
	@return The price of the coach
	*/
	@Override
	public double getPrice(){
		return coachPrice;
	}
	/**
	Calculates the coach level <br>
	<b> pre: </b> The coach must previously have a an average rating and a number of goals scored <br>
	<b> post: </b> Based on the average rating and the number of goals scored by the coach, a double representing the coach level is obtained <br>
	@return level
	*/
	@Override
	public double calculateLevel(){
		double level = 5+(championshipsAchieved/10);
		return level;
	}
	/**
	Updates the coach level <br>
	<b> pre: </b> The coach must previously have a an average rating and a number of goals scored <br>
	<b> post: </b> Based on the average rating and the number of goals scored by the coach, updates the level of the coach <br>
	*/
	@Override
	public void updateLevel(){
		coachLevel=calculateLevel();
	}
	/**
	@return The level of the coach
	*/
	@Override
	public double getLevel(){
		return coachLevel;
	}
	/**
	Returns all the information of the head coach <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on all the information of the head coach, a String with all the information is obtained <br>
	@return info
	*/
	@Override
	public String getAllInformation(){
		String info = getBasicInformation();
		info += "Years of experience: "+getExperienceYears()+"\n";
		info += "Number of teams in charge: "+getTeamsInCharge()+"\n";
		info += "Championships achieved: "+getChampionshipsAchieved()+"\n";
		info += "***************************************"+"\n";
		return info;
	}
	
	
	
}