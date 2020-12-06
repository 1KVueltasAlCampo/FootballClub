package model;
public class AssistantCoach extends Coach{
	private boolean wasAPlayer;
	private int expertiseIndicator;
	private Expertise coachExpertise;
	/**
	Constructor method of the class "AssistantCoach" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type AssistantCoach <br>
	@param name String that indicates the name of the assistant coach
	@param identifier String that indicates the identifier of the assistant coach
	@param salary int that indicates the salary of the assistant coach
	@param experienceYears int that indicates the years of experience of the assistant coach
	@param wasAPlayer boolean that indicates if the coach was a proffesional player or not
	@param expertiseIndicator int that indicates the expertise of the coach. 1 for offensive, 2 for deffensive, 3 for possesion, 4 for lab plays
	*/
	public AssistantCoach(String name,String identifier,int salary,int experienceYears,boolean wasAPlayer, int expertiseIndicator){
		super(name,identifier,salary,experienceYears);
		this.wasAPlayer=wasAPlayer;
		this.expertiseIndicator=expertiseIndicator;
		coachExpertise = Expertise.values()[expertiseIndicator-1];
	}
	
	/**
	@param wasAPlayer boolean that indicates if the coach was a proffesional player or not
	*/
	public void setWasAPlayer(boolean wasAPlayer){
		this.wasAPlayer=wasAPlayer;
	}
	/**
	@return true if the coach was a proffesional player, false if not 
	*/
	public boolean getWasAPlayer(){
		return wasAPlayer;
	}
	/**
	@param expertiseIndicator int that indicates the expertise of the coach. 1 for offensive, 2 for deffensive, 3 for possesion, 4 for lab plays
	*/
	public void setExpertiseIndicator(int expertiseIndicator){
		this.expertiseIndicator=expertiseIndicator;
	}
	/**
	@return the expertise indicator of the coach
	*/
	public int getExpertiseIndicator(){
		return expertiseIndicator;
	}
	/**
	@return the expertise indicator of the coach
	*/
	public String getCoachExpertise(){
		String info = coachExpertise.toString();
		return info;
	}
	/**
	Returns all the information of the assistant coach <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on all the information of the assistant coach, a String with all the information is obtained <br>
	@return info
	*/
	@Override
	public String getAllInformation(){
		String info = getBasicInformation();
		info += "Years of experience: "+getExperienceYears()+"\n";
		info += "Was a player?: "+getWasAPlayer()+"\n";
		info += "Expertise: "+getCoachExpertise()+"\n";
		info += "***************************************"+"\n";
		return info;
	}
	
}