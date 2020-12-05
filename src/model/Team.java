package model;
import java.util.*;
public class Team {
	private String teamName;
	private HeadCoach teamHeadCoach;
	private AssistantCoach[] teamAssistantCoachs;
	private Player[] teamPlayers;
	private arrayList<Lineup> teamLineups;
	private int teamLineupsAmount;
	/**
	Constructor method of the class "Team" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type Team <br>
	@param teamName String that indicates the name of the team
	@param teamHeadCoach object of type HeadCoach that indicates the head coach
	*/
	public Team(String teamName, HeadCoach teamHeadCoach){
		this.teamName=teamName;
		this.teamHeadCoach=teamHeadCoach;
		teamAssistantCoach=new AssistantCoach[3];
		teamPlayers = new Player[25];
		teamLineupsAmount=0;
		teamLineups=new arrayList<Lineup>();
	}
	/**
	@param teamName String that indicates the name of the team
	*/
	public void setTeamName(String teamName){
		this.teamName=teamName;
	}
	/**
	@return The name of the team
	*/
	public String getTeamName(){
		return teamName;
	}
	/**
	@param teamLineupsAmount int that indicates the of the number of lineups that the team has
	*/
	public void setTeamLineupsAmount(int teamLineupsAmount){
		this.teamLineupsAmount=teamLineupsAmount;
	}
	/**
	@return The number of lineups that the team has
	*/
	public int getTeamLineupsAmount(){
		return teamLineupsAmount;
	}
	/**
	Checks the existence of a player in the team <br>
	<b> pre: </b>It is only useful if there is at least one player in the team. <br>
	<b> post: </b> Returns true if the the indicated player exists, false if  it doesn't <br>
	@param player A player, it must be one from the players of the club
	@return true or false
	*/
	public boolean playerExists(Player player){
		for(int i=0;i<teamPlayers.length;i++){
			if(teamPlayers[i]!=null){
				if(player.getName().equalsIgnoreCase(teamPlayers[i].getName())){
					return true;
				}
			}
		}
		return false;
	}
	/**
	Add a player to the team <br>
	<b> pre: </b><br>
	<b> post: </b> Returns true if the player was added to the team, false if not <br>
	@param player A player, it must be one from the players of the club
	@return true or false
	*/
	public boolean addAPlayer(Player player){
		if(!(playerExists(player))){
			for(int i=0;i<teamPlayers.length;i++){
				if(teamPlayers[i]==null){
					teamPlayers[i]=player;
					return true;
				}	
			}
		}	
		return false;
	}
	/**
	Checks the existence of an assistantCoach in the team <br>
	<b> pre: </b>It is only useful if there is at least one assistant coach in the team. <br>
	<b> post: </b> Returns true if the the indicated assistant coach exists, false if  it doesn't <br>
	@param player A player, it must be one from the assistant coachs of the club
	@return true or false
	*/
	public boolean assistantCoachExists(AssistantCoach assistantCoach){
		for(int i=0;i<teamAssistantCoachs.length;i++){
			if(teamAssistantCoachs[i]!=null){
				if(assistantCoach.getName().equalsIgnoreCase(teamAssistantCoachs[i].getName())){
					return true;
				}
			}
		}
		return false;
	}
	/**
	Add an assistant coach to the team <br>
	<b> pre: </b><br>
	<b> post: </b> Returns true if the assistant coach was added to the team, false if not <br>
	@param assistantCoach An AssistantCoach, it must be one from the assistant coachs of the club
	@return true or false
	*/
	public boolean addAnAssistantCoach(AssistantCoach assistantCoach){
		if(!(assistantCoachExists(assistantCoach))){
			for(int i=0;i<teamAssistantCoachs.length;i++){
				if(teamAssistantCoachs[i]==null){
					teamAssistantCoachs[i]=assistantCoach;
					return true;
				}	
			}
		}	
		return false;
	}
	/**
	Checks the existence of a lineup in the team <br>
	<b> pre: </b>It is only useful if there is at least one lineup in the team. <br>
	<b> post: </b> Returns true if the the indicated lineup exists, false if  it doesn't <br>
	@param lineup An object of type lineup
	@return true or false
	*/
	public boolean lineupExists(Lineup lineup){
		for(int i=0;i<teamLineupsAmount;i++){
			if(teamLineups.get(i)!=null){
				if(lineup.getName().equalsIgnoreCase(teamLineups.get(i).getName())){
					return true;
				}
			}
		}
		return false;
	}
	/**
	Add a lineup to the team <br>
	<b> pre: </b><br>
	<b> post: </b> Returns true if the lineup was added to the team, false if not <br>
	@param lineup An object of type lineup
	@return true or false
	*/
	public boolean addAnAssistantCoach(AssistantCoach assistantCoach){
		if(!(assistantCoachExists(assistantCoach))){
			teamLineups.add(assistantCoach);
			teamLineupsAmount++;
		}	
		return false;
	}
	/**
	Returns a String with the names of the assistant coaches <br>
	<b> pre: </b><br>
	<b> post: </b> A String with the names of the assistant coaches is obtained  <br>
	@return info
	*/
	public String getAssistantCoachs(){
		String info="";
		for(int i=0;i<teamAssistantCoachs;i++){
			info+=teamAssistantCoachs[i].getName()+", ";
		}
		return info;
	}
	/**
	Returns the basic information of the Team <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on the information of the team, a String with all the basic information is obtained <br>
	@return info
	*/
	public String getBasicInformation(){
		String info = "";
		info += "**************  Team **************"+"\n";
		info += "Name: "+getTeamName()+"\n";
		info += "Head Coach: "+teamHeadCoach.getName()+"\n";
		info += "Assistant coachs: "+getSalary()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}