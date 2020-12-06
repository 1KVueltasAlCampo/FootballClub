package model;
import java.util.*;
public class Club{
	private String clubName;
	private String clubNIT;
	private String clubFundationDate;
	private ArrayList<Employee> clubEmployees;
	private int clubEmployeesAmount;
	private Team[] clubTeams;
	private Player[][] dressingRoomA;
	private Player[][] dressingRoomB;
	private Coach[][] clubOffices;
	/**
	Constructor method of the class "Club" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type Club <br>
	@param clubName String that indicates the name of the club
	@param clubNIT String that indicates the NIT of the club
	@param clubFundationDate String that indicates the fundation date of the club
	*/
	public Club(String clubName,String clubNIT,String clubFundationDate){
		this.clubName=clubName;
		this.clubNIT=clubNIT;
		this.clubFundationDate=clubFundationDate;
		clubEmployees=new ArrayList<Employee>();
		clubEmployeesAmount=0;
		clubTeams=new Team[2];
		dressingRoomA=new Player[7][6];
		dressingRoomB=new Player[7][7];
		clubOffices=new Coach[6][6];
	}
	/**
	@param clubName String that indicates the name of the club
	*/
	public void setClubName(String clubName){
		this.clubName=clubName;
	}
	/**
	@return The name of the club
	*/
	public String getClubName(){
		return clubName;
	}
	/**
	@param clubName String that indicates the NIT of the club
	*/
	public void setClubNIT(String clubNIT){
		this.clubNIT=clubNIT;
	}
	/**
	@return The NIT of the club
	*/
	public String getClubNIT(){
		return clubNIT;
	}
	/**
	@param clubName String that indicates the fundation date of the club
	*/
	public void setClubFundationDate(String clubFundationDate){
		this.clubFundationDate=clubFundationDate;
	}
	/**
	@return The fundation date of the club
	*/
	public String getClubFundationDate(){
		return clubFundationDate;
	}
	/**
	Hires a player <br>
	<b> pre: </b>  <br>
	<b> post: </b> A player is hired <br>
	@param name String that indicates the name of the player
	@param identifier String that indicates the identifier of the player
	@param salary int that indicates the salary of the player
	@param tShirtNumber int that indicates the t-shirt number of the player
	@param goalsScored int that indicates the goals scored by the player
	@param averageRating double that indicates the average rating of the player. Must be a number from 1 to 5.
	@param positionIndicator int that indicates the position of the player. 1 for GoalKeeper, 2 for Defender,3 for midfielder, 4 for striker.
	*/
	public void hireAnEmployee(String employeeName,String employeeID,int employeeSalary,int playerTShirtNumber,int playerGoalsScored,double playerAverageRating, int playerPositionIndicator){
		Player footballPlayer = new Player(employeeName,employeeID,employeeSalary,playerTShirtNumber,playerGoalsScored,playerAverageRating,playerPositionIndicator);
		clubEmployees.add(footballPlayer);
		clubEmployeesAmount++;
	}
	/**
	Hires a head coach <br>
	<b> pre: </b>  <br>
	<b> post: </b> A head coach is hired <br>
	@param name String that indicates the name of the player
	@param identifier String that indicates the identifier of the player
	@param salary int that indicates the salary of the player
	@param experienceYears int that indicates the years of experience of the head coach
	@param teamsInCharge int that indicates the number of teams the head coach has in charge
	@param championshipsAchieved int that indicates the number of championships achieved by the head coach
	*/
	public void hireAnEmployee(String employeeName,String employeeID,int employeeSalary,int experienceYears,int teamsInCharge,int championshipsAchieved){
		HeadCoach clubHeadCoach = new HeadCoach(employeeName,employeeID,employeeSalary,experienceYears,teamsInCharge,championshipsAchieved);
		clubEmployees.add(clubHeadCoach);
		clubEmployeesAmount++;
	}
	/**
	Hires an assistant coach <br>
	<b> pre: </b>  <br>
	<b> post: </b> An assistant coach is hired <br>
	@param name String that indicates the name of the player
	@param identifier String that indicates the identifier of the player
	@param salary int that indicates the salary of the player
	@param experienceYears int that indicates the years of experience of the head coach
	@param wasAPlayer boolean that indicates if the coach was a proffesional player or not
	@param expertiseIndicator int that indicates the expertise of the coach. 1 for offensive, 2 for deffensive, 3 for possesion, 4 for lab plays
	*/
	public void hireAnEmployee(String employeeName,String employeeID,int employeeSalary,int experienceYears,boolean wasAPlayer, int expertiseIndicator){
		AssistantCoach clubAssistantCoach = new AssistantCoach(employeeName,employeeID,employeeSalary,experienceYears,wasAPlayer,expertiseIndicator);
		clubEmployees.add(clubAssistantCoach);
		clubEmployeesAmount++;
	}
	/**
	Finds an employee int the club <br>
	<b> pre: </b>It is only useful if there is at least one employee in the club. <br>
	<b> post: </b> Returns an int, if it is "-1" then the employee doesn't exist. If is another number, indicates the position in which the employee is <br>
	@param name String that indicates the name of the user
	@param password String that indicates the password of the user
	@return index
	*/
	public int findEmployee(String employeeName){
		int index=-1;
		if(!clubEmployees.isEmpty()){
			for(int i=0;i<clubEmployeesAmount;i++){
				if(employeeName.equalsIgnoreCase(clubEmployees.get(i).getName())){
					index=i;
				}
			}	
		}
		return index;	
	}
	/**
	Given an index, changes the state of an employee to inactive <br>
	<b> pre: </b>Don't fire an employee that is already fired <br>
	<b> post: </b> fires an employee<br>
	@param index int that indicates what employee do you want to fire.
	*/
	public boolean fireAnEmployee(int index){
		if(index!=-1){
			clubEmployees.get(index).setStatusIndicator(2);
			return true;
		}
		return false;
	}
	/**
	Initicialize a team of the club <br>
	<b> pre: </b> There must be at least one head coach in the club <br>
	<b> post: </b>Returns true if the team was initialized correctly, false if  it doesn't <br>
	@param teamName String that indicates the name of the team
	@param teamHeadCoach bject of type HeadCoach that indicates the head coach of the team	
	@return true or false
	*/
	public boolean initializeATeam(String teamName,HeadCoach teamHeadCoach){
		for(int i=0;i<clubTeams.length;i++){
			if(clubTeams[i]==null){
				clubTeams[i]=new Team(teamName,teamHeadCoach);
				return true;
			}
		}
		return false;
	}
	/**
	Add a player to the team <br>
	<b> pre: </b> <br>
	<b> post: </b>Returns true if the player was added correctly, false if  it doesn't <br>
	@param playerName String that indicates the name of the player	
	@return true or false
	*/
	public String addAPlayerToTheTeam(String teamName,String playerName){
		int employeeIndex = findEmployee(playerName);
		String info="";
		int employeeType = 0;
		int teamIndex = findTeam(teamName);
			if(teamIndex != -1){
				if(employeeIndex!=-1){
					employeeType= employeeInstanceOf(employeeIndex);
					if(employeeType==1){
						Player teamPlayer = giveAPlayerWithIndex(employeeIndex);
						boolean aux=clubTeams[teamIndex].addAPlayer(teamPlayer);
						if(aux){
							info+="The player was added to the team"+"\n";
						}
						else{
						info+="Could not add the player, full storage"+"\n";
						}
					}
					else{
						info+="Could not add the player, the employee entered is not a player"+"\n";
					}
				}
				else{
					info+="Could not add the player, entered player does not exist"+"\n";
				}		
			}
			else {
				info += "The team entered does not exist"+"\n";
			}
			return info;
	}
	/**
	Add an assistant coach to the team <br>
	<b> pre: </b> <br>
	<b> post: </b>Returns true if the player was added correctly, false if  it doesn't <br>
	@param playerName String that indicates the name of the player	
	@return true or false
	*/
	public String addAnAssistantCoachToTheTeam(String teamName,String assistantCoachName){
		int employeeIndex = findEmployee(assistantCoachName);
		String info="";
		int employeeType = 0;
		int teamIndex = findTeam(teamName);
			if(teamIndex != -1){
				if(employeeIndex!=-1){
					employeeType= employeeInstanceOf(employeeIndex);
					if(employeeType==1){
						AssistantCoach teamAssistantCoach = giveAnAssistantCoachWithIndex(employeeIndex);
						boolean aux=clubTeams[teamIndex].addAnAssistantCoach(teamAssistantCoach);
						if(aux){
							info+="The assistant coach was added to the team"+"\n";
						}
						else{
						info+="Could not add the assistant coach, full storage"+"\n";
						}
					}
					else{
						info+="Could not add the assistant coach, the employee entered is not an assistant coach"+"\n";
					}
				}
				else{
					info+="Could not add the assistant coach, entered assistant coach does not exist"+"\n";
				}		
			}
			else {
				info += "The team entered does not exist"+"\n";
			}
			return info;
	}
	/**
	Finds a team in the club <br>
	<b> pre: </b>It is only useful if there is at least one team initialized in the club. <br>
	<b> post: </b> Returns an int, if it is "-1" then the team isn't initialized. If is another number, indicates the position in which the team is <br>
	@param teamName String that indicates the name of the team
	@return index
	*/
	public int findTeam(String teamName){
		int index=-1;
		for(int i=0;i<clubTeams.length;i++){
			if(clubTeams[i]!=null){
				if((teamName.equalsIgnoreCase(clubTeams[i].getTeamName()))){
					index=i;
				}
			}
		}
		return index;
	}
	/**
	Adds a lineup to the team <br>
	<b> pre: </b> <br>
	<b> post: </b>Returns true if the lineup was added correctly, false if  it doesn't <br>
	@param playerName String that indicates the name of the player	
	@return true or false
	*/
	public String addALineup(String teamName,Lineup lineup){
		String info = "";
			int teamIndex = findTeam(teamName);
			if(teamIndex != -1){
				boolean aux=clubTeams[teamIndex].addALineup(lineup);
				if(aux){
					info+= "The lineup was added correctly"+"\n";
				}
				else{
					info+= "The lineup was not added because one already exists with the same date"+"\n";
				}
			}
			else {
				info += "The team entered does not exist"+"\n";
			}
			return info;
	}
	/**
	Displays the information of a team <br>
	<b> pre: </b><br>
	<b> post: </b> Displays the information of a team<br>
	@param index int that indicates the team
	*/
	public String getInfoOfATeam(int index){
		String info="";
		if(index!=-1){
			info += clubTeams[index].getBasicInformation();
		}
		else{
			info += "The team you entered does not exist"+"\n";
		}
		return info;
	}
	/**
	Displays the players of a team <br>
	<b> pre: </b><br>
	<b> post: </b> Displays the players of a team<br>
	@param index int that indicates the team
	*/
	public String getPlayersOfATeam(int index){
		String info="";
		if(index!=-1){
			info += clubTeams[index].getPlayersOfTheTeam();
		}
		else{
			info += "The team you entered does not exist"+"\n";
		}
		return info;
	}
	/**
	Displays the players of a team <br>
	<b> pre: </b><br>
	<b> post: </b> Displays the players of a team<br>
	@param index int that indicates the team
	*/
	public String getLineupsOfATeam(int index){
		String info="";
		if(index!=-1){
			info += clubTeams[index].getLineupsOfTheTeam();
		}
		else{
			info += "The team you entered does not exist"+"\n";
		}
		return info;
	}
	/**
	Given an index, identify what type of employee it is <br>
	<b> pre: </b> <br>
	<b> post: </b> Returns an int, if is 1 the employee is a player, if is 2 the employee is a head coach, if is 3 the playlist is an assistant coach <br>
	@param index int that indicates what employee do you want to know its type.
	@return 1 or 2 or 3
	*/
	public int employeeInstanceOf(int index){
		if(clubEmployees.get(index) instanceof Player){
			return 1;
		}
		else if(clubEmployees.get(index) instanceof HeadCoach){
			return 2;
		}
		return 3;
	}
	/**
	Given an index, returns a player<br>
	<b> pre: </b> The index entered must belong to one of the players <br>
	<b> post: </b> Returns the player with the index indicated <br>
	@param index int that indicates what player are you going to return.
	@return clubEmployees[index]
	*/
	public Player giveAPlayerWithIndex(int index){
		return (Player) clubEmployees.get(index);
	}
	/**
	Given an index, returns a HeadCoach<br>
	<b> pre: </b> The index entered must belong to one of the head coaches <br>
	<b> post: </b> Returns the head coach with the index indicated <br>
	@param index int that indicates what head coach are you going to return.
	@return clubEmployees[index]
	*/
	public HeadCoach giveAHeadCoachWithIndex(int index){
		return (HeadCoach) clubEmployees.get(index);
	}
	/**
	Given an index, returns an assistant coach<br>
	<b> pre: </b> The index entered must belong to one of the assistant coaches <br>
	<b> post: </b> Returns the assistant coach with the index indicated <br>
	@param index int that indicates what assistant coach are you going to return.
	@return clubEmployees[index]
	*/
	public AssistantCoach giveAnAssistantCoachWithIndex(int index){
		return (AssistantCoach) clubEmployees.get(index);
	}
	/**
	Given an index, displays the information of that employee <br>
	<b> pre: </b><br>
	<b> post: </b> Displays the information of an employee<br>
	@param index int that indicates the employee
	*/
	public String getInfoOfAnEmployee(int index){
		String info="";
		if(index!=-1){
			info += clubEmployees.get(index).getAllInformation();
		}
		else{
			info += "The employee you entered does not exist"+"\n";
		}
		return info;
	}
	/**
	Returns all information of all the employees <br>
	<b> pre: </b> <br>
	<b> post: </b>Based on all the information of all the employees in the club, a String with all the information of all the employees is obtained <br>
	@return info
	*/
	public String getInfoOfAllEmployees(){
		String info="";
		for(int i=0;i<clubEmployeesAmount;i++){
			info += clubEmployees.get(i).getAllInformation();
		}
		return info;
	}
	/**
	Returns the general information of the club <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on the general information of the club, a String with all the information is obtained <br>
	@return info
	*/
	public String showGeneralInfo(){
		String info = "|||||||||||||||||CLUB|||||||||||||||||"+"\n";
		info += "Club Name : "+getClubName()+"\n";
		info += "Club NIT: "+getClubNIT()+"\n";
		info += "Club fundation date: "+getClubFundationDate()+"\n";
		info += "||||||||||||||||||||||||||||||||||||||"+"\n";
		return info;
	}
}