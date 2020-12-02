package model;
public abstract class Coach extends Employee{
	private int experienceYears;
	/**
	Constructor method of the class "Coach" <br>
	<b> pre: </b> This constructor should never be used. <br>
	<b> post: </b> Create an object of type Coach <br>
	@param name String that indicates the name of the coach
	@param identifier String that indicates the identifier of the coach
	@param salary int that indicates the salary of the coach
	@param statusIndicator int that indicates the status of the coach. Must be 1 if the coach is active, 0 if not
	@param experienceYears int that indicates the years of experience of the coach
	*/
	public Coach(String name,String identifier,int salary,int statusIndicator, int experienceYears){
		super(name,identifier,salary,statusIndicator);
		this.experienceYears=experienceYears;
	}
	/**
	@param experienceYears int that indicates the years of experience of the coach
	*/
	public void setExperienceYears(int experienceYears){
		this.experienceYears=experienceYears;
	}
	/**
	@return The years of experience of the coach
	*/
	public int getExperienceYears(){
		return experienceYears;
	}

}