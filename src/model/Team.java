package model;
import java.util.*;
public class Team {
	private String teamName;
	private HeadCoach teamHeadCoach;
	private AssistantCoach[] teamAssistantCoachs;
	private Player[] teamPlayers;
	private ArrayList<Lineup> teamLineups;
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
		teamAssistantCoachs=new AssistantCoach[3];
		teamPlayers = new Player[25];
		teamLineupsAmount=0;
		teamLineups=new ArrayList<Lineup>();
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
		checkPlayersFired();
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
	@param assistantCoach An assistant coach, it must be one from the assistant coachs of the club
	@return true or false
	*/
	public boolean assistantCoachExists(AssistantCoach assistantCoach){
		checkAssistantCoachesFired();
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
		if(!teamLineups.isEmpty()){
			for(int i=0;i<teamLineupsAmount;i++){
					if(lineup.getLineupDate().equalsIgnoreCase(teamLineups.get(i).getLineupDate())){
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
	public boolean addALineup(Lineup lineup){
		if(!(lineupExists(lineup))){
			teamLineups.add(lineup);
			teamLineupsAmount++;
			return true;
		}	
		return false;
	}
	/**
	Add a head coach to the team <br>
	<b> pre: </b><br>
	<b> post: </b> Returns true if the head Coach was added to the team, false if not <br>
	@param headCoach A head coach, it must be one from the head coaches of the club
	@return true or false
	*/
	public boolean addAHeadCoach(HeadCoach headCoach){
		checkHeadCoachFired();
		if(teamHeadCoach==null){
			teamHeadCoach=headCoach;
			return true;
		}
		return false;
	}
	/**
	Checks if the head coach in the team is fired <br>
	<b> pre: </b><br>
	<b> post: </b> The head coach is deleted from the team  <br>
	*/
	public void checkHeadCoachFired(){
		if(teamHeadCoach != null){
			if(teamHeadCoach.getStatusIndicator()==2){
				teamHeadCoach=null;
			}
		}
	}
	/**
	Checks if one of the assistant coaches in the team is fired <br>
	<b> pre: </b><br>
	<b> post: </b> The assistant coach is deleted from the team  <br>
	*/
	public void checkAssistantCoachesFired(){
		for(int i=0;i<teamAssistantCoachs.length;i++){
			if(teamAssistantCoachs[i]!=null){
				if(teamAssistantCoachs[i].getStatusIndicator()==2){
					teamAssistantCoachs[i]=null;
				}
			}
		}
	}
	/**
	Checks if one of the players in the team is fired <br>
	<b> pre: </b><br>
	<b> post: </b> The player is deleted from the team  <br>
	*/
	public void checkPlayersFired(){
		for(int i=0;i<teamPlayers.length;i++){
			if(teamPlayers[i]!=null){
				if(teamPlayers[i].getStatusIndicator()==2){
					teamPlayers[i]=null;
				}
			}
		}
	}
	/**
	Returns a String with the names of the assistant coaches <br>
	<b> pre: </b><br>
	<b> post: </b> A String with the names of the assistant coaches is obtained  <br>
	@return info
	*/
	public String getAssistantCoachs(){
		checkAssistantCoachesFired();
		String info="";
		for(int i=0;i<teamAssistantCoachs.length;i++){
			if(teamAssistantCoachs[i]!=null){
				info+=teamAssistantCoachs[i].getName()+", ";
			}
		}
		return info;
	}
	/**
	Returns the players of the Team <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on the information of the team, a String with all the players is obtained <br>
	@return info
	*/
	public String getPlayersOfTheTeam(){
		checkPlayersFired();
		String info = "";
		for(int i=0;i<teamPlayers.length;i++){
			if(teamPlayers[i]!=null){
				info+=teamPlayers[i].getName()+" ";
				if(i%5==0){
					info += "\n";
				}
			}	
		}
		info += "\n";
		return info;
	}
	/**
	Returns the lineups of the Team <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on the information of the team, a String with all the lineups is obtained <br>
	@return info
	*/
	public String getLineupsOfTheTeam(){
		String info = "";
		for(int i=0;i<teamLineupsAmount;i++){
			info+=teamLineups.get(i).getInfo();
		}
		return info;
	}
	/**
	Returns the name of the head coach of the Team <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on the information of the team, a String with the name of the head coach is obtained <br>
	@return info
	*/
	public String getHeadCoachName(){
		String info = "";
		if(teamHeadCoach!=null){
			info += teamHeadCoach.getName();
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
		checkHeadCoachFired();
		checkAssistantCoachesFired();
		checkPlayersFired();
		String info = "";
		info += "**************  Team **************"+"\n";
		info += "Name: "+getTeamName()+"\n";
		info += "Head Coach: "+getHeadCoachName()+"\n";
		info += "Assistant coachs: "+getAssistantCoachs()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}