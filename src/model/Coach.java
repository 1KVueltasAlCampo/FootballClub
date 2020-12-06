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
	@param experienceYears int that indicates the years of experience of the coach
	*/
	public Coach(String name,String identifier,int salary,int experienceYears){
		super(name,identifier,salary);
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