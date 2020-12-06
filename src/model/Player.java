package model;
public class Player extends Employee implements PriceAndLevel{
	private int tShirtNumber;
	private int goalsScored;
	private double averageRating;
	private int positionIndicator;
	private Positions playerPosition;
	private double playerPrice;
	private double playerLevel;
	/**
	Constructor method of the class "Player" <br>
	<b> pre: </b>  <br>
	<b> post: </b> Create an object of type Player <br>
	@param name String that indicates the name of the player
	@param identifier String that indicates the identifier of the player
	@param salary int that indicates the salary of the player
	@param tShirtNumber int that indicates the t-shirt number of the player
	@param goalsScored int that indicates the goals scored by the player
	@param averageRating double that indicates the average rating of the player. Must be a number from 1 to 5.
	@param positionIndicator int that indicates the position of the player. 1 for GoalKeeper, 2 for Defender,3 for midfielder, 4 for striker.
	*/
	public Player(String name,String identifier,int salary,int tShirtNumber,int goalsScored,double averageRating, int positionIndicator){
		super(name,identifier,salary);
		this.tShirtNumber=tShirtNumber;
		this.goalsScored=goalsScored;
		this.averageRating=averageRating;
		this.positionIndicator=positionIndicator;
		playerPosition = Positions.values()[positionIndicator-1];
		playerPrice=calculatePrice();
	}
	/**
	@param tShirtNumber int that indicates the t-shirt number of the player
	*/
	public void setTShirtNumber(int tShirtNumber){
		this.tShirtNumber=tShirtNumber;
	}
	/**
	@return The t-shirt number of the player
	*/
	public int getTShirtNumber(){
		return tShirtNumber;
	}
	/**
	@param goalsScored int that indicates the goals scored by the player
	*/
	public void setGoalsScored(int goalsScored){
		this.goalsScored=goalsScored;
	}
	/**
	@return The goals scored by the player
	*/
	public int getGoalsScored(){
		return goalsScored;
	}
	/**
	@param averageRating double that indicates the average rating of the player. Must be a number from 1 to 5.
	*/
	public void setAverageRating(double averageRating){
		this.averageRating=averageRating;
	}
	/**
	@return The average rating of the player
	*/
	public double getAverageRating(){
		return averageRating;
	}
	/**
	@param positionIndicator int that indicates the position of the player. 1 for GoalKeeper, 2 for Defender,3 for midfielder, 4 for striker.
	*/
	public void setPositionIndicator(int positionIndicator){
		this.positionIndicator=positionIndicator;
	}
	/**
	@return The position indicator of the player
	*/
	public int getPositionIndicator(){
		return positionIndicator;
	}
	/**
	@return The position of the player
	*/
	public String getPosition(){
		String info = playerPosition.toString();
		return info;
	}
	/**
	Calculates the player price <br>
	<b> pre: </b> The player must previously have a salary, an average rating and a number of goals scored <br>
	<b> post: </b> Based on the salary, the average rating and the number of goals scored by the player, a double representing the player price is obtained <br>
	@return price
	*/
	@Override
	public double calculatePrice(){
		double price;
		switch(positionIndicator){
			case 1:
				price = (getSalary()*12)+(getAverageRating()*150);
				break;
			case 2:
				price = (getSalary()*13)+(getAverageRating()*125)+(getGoalsScored()*100);
				break;
			case 3:
				price = (getSalary()*14)+(getAverageRating()*135)+(getGoalsScored()*125);
				break;
			case 4:
				price = (getSalary()*15)+(getAverageRating()*145)+(getGoalsScored()*150);
				break;
			default:
				price=0;
				break;
		}
		return price;
	}
	/**
	Updates the player price <br>
	<b> pre: </b> The player must previously have a salary, an average rating and a number of goals scored <br>
	<b> post: </b> Based on the salary, the average rating and the number of goals scored by the player, updates the price of the player <br>
	*/
	@Override
	public void updatePrice(){
		playerPrice=calculatePrice();
	}
	/**
	@return The price of the player
	*/
	@Override
	public double getPrice(){
		return playerPrice;
	}
	/**
	Calculates the player level <br>
	<b> pre: </b> The player must previously have a an average rating and a number of goals scored <br>
	<b> post: </b> Based on the average rating and the number of goals scored by the player, a double representing the player level is obtained <br>
	@return level
	*/
	@Override
	public double calculateLevel(){
		double level;
		switch(positionIndicator){
			case 1:
				level = averageRating*0.9;
				break;
			case 2:
				level = (averageRating*0.9)+(goalsScored/100);
				break;
			case 3:
				level = (averageRating*0.9)+(goalsScored/90);
				break;
			case 4:
				level = (averageRating*0.9)+(goalsScored/80);
				break;
			default:
				level=0;
				break;
		}
		return level;
	}
	/**
	Updates the player level <br>
	<b> pre: </b> The player must previously have a an average rating and a number of goals scored <br>
	<b> post: </b> Based on the average rating and the number of goals scored by the player, updates the level of the player <br>
	*/
	@Override
	public void updateLevel(){
		playerLevel=calculateLevel();
	}
	/**
	@return The level of the player
	*/
	@Override
	public double getLevel(){
		return playerLevel;
	}
	/**
	Returns all the information of the player <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on all the information of the player, a String with all the information is obtained <br>
	@return info
	*/
	@Override
	public String getAllInformation(){
		String info = getBasicInformation();
		updatePrice();
		updateLevel();
		info += "T-Shirt Number: "+getTShirtNumber()+"\n";
		info += "Goals scored: "+getGoalsScored()+"\n";
		info += "Average rating: "+getAverageRating()+"\n";
		info += "Position: "+getPosition()+"\n";
		info += "Player price: "+getPrice()+"\n";
		info += "Player level: "+getLevel()+"\n";
		info += "***************************************"+"\n";
		return info;
	}
}