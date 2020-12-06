package ui;
import model.*;
import java.util.*;
public class Menu{
	private final static int EMPLOYEE_RELATED_MENU = 1;
	private final static int TEAM_RELATED_MENU = 2;
	private final static int FACILITY_RELATED_MENU = 3;
	private final static int DISPLAY_CLUB_GENERAL_INFORMATION = 4;
	private final static int EXIT = 5;
	//
	private final static int HIRE_AN_EMPLOYEE = 1;
	private final static int FIRE_AN_EMPLOYEE = 2;
	private final static int UPDATE_THE_INFORMATION_OF_AN_EMPLOYEE = 3;
	private final static int DISPLAY_EMPLOYEE_INFORMATION = 4;
	private final static int DISPLAY_ALL_EMPLOYEES_INFORMATION = 5;
	private final static int EXIT_EMPLOYEE_MENU = 6;
	//
	private final static int INITIALIZE_ONE_TEAM = 1;
	private final static int ADD_AN_EMPLOYEE_TO_A_TEAM = 2;
	private final static int ADD_A_LINEUP_TO_A_TEAM = 3;
	private final static int DISPLAY_GENERAL_TEAM_INFORMATION = 4;
	private final static int SHOW_PLAYERS_OF_THE_TEAM = 5;
	private final static int DISPLAY_TEAM_LINEUPS = 6;
	private final static int EXIT_TEAM_MENU = 7;
	//
	private final static int LOCATE_A_COACH_IN_A_OFFICE = 1;
	private final static int LOCATE_A_PLAYER_IN_A_DRESSING_ROOM = 2;
	private final static int KNOW_THE_OFFICE_OF_A_COACH = 3;
	private final static int KNOW_THE_DRESSING_ROOM_OF_A_PLAYER = 4;
	private final static int EXIT_FACILITY_MENU = 5;	


	private Club footballClub;
	private static Scanner sc = new Scanner(System.in);
	/**
	Constructor method of the class "Menu" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type Menu <br>
	*/
	public Menu(){
		footballClub=createTheClub();
	}
	/**
	Creates a club object to start the program <br>
	<b> pre: </b><br>
	<b> post: </b> A club object is created <br>
	@return createClub
	*/
	public Club createTheClub(){
		System.out.println("Welcome to the football club program ");
		System.out.println("To get started, enter the club information");
		System.out.println("Enter the name of the club: ");
		String clubName=sc.nextLine();
		System.out.println("Enter the NIT of the club: ");
		String clubNit=sc.nextLine();
		System.out.println("Enter the fundation date of the club (use a format DD/MM/YYYY) : ");
		String clubFundationDate=sc.nextLine();
		Club createClub = new Club(clubName,clubNit,clubFundationDate);
		return createClub;
	}
	/**
	Shows the general menu options <br>
	<b> pre: </b><br>
	<b> post: </b> Menu options are displayed <br>
	*/
	public void showGeneralMenu(){
		System.out.println("______________________________________________________________");
		System.out.println("Enter 1 to perform employee related operations");
		System.out.println("Enter 2 to perform team related operations");
		System.out.println("Enter 3 to perform facility-related operations");
		System.out.println("Enter 4 to display the general information of the club ");
		System.out.println("Enter 5 to exit ");
		System.out.println("______________________________________________________________");
	}
	/**
	Shows the employee menu options <br>
	<b> pre: </b><br>
	<b> post: </b> Menu options are displayed <br>
	*/
	public void showEmployeeMenu(){
		System.out.println("______________________________________________________________");
		System.out.println("Enter 1 to hire an employee");
		System.out.println("Enter 2 to fire an employee");
		System.out.println("Enter 3 to update the information of an employee");
		System.out.println("Enter 4 to display the information of an employee");
		System.out.println("Enter 5 to display the information of all employees");
		System.out.println("Enter 6 to exit this menu ");
		System.out.println("______________________________________________________________");
	}
	/**
	Shows the team menu options <br>
	<b> pre: </b><br>
	<b> post: </b> Menu options are displayed <br>
	*/
	public void showTeamMenu(){
		System.out.println("______________________________________________________________");
		System.out.println("Enter 1 to initialize one of the teams");
		System.out.println("Enter 2 to add an employee to a team (assistant coaches or players)");
		System.out.println("Enter 3 to add a lineup to a team");
		System.out.println("Enter 4 to display general team information");
		System.out.println("Enter 5 to show the players of a team");
		System.out.println("Enter 6 to display team lineups ");
		System.out.println("Enter 7 to exit this menu ");
		System.out.println("______________________________________________________________");
	}
	/**
	Shows the facility menu options <br>
	<b> pre: </b><br>
	<b> post: </b> Menu options are displayed <br>
	*/
	public void showFacilityMenu(){
		System.out.println("______________________________________________________________");
		System.out.println("Enter 1 to locate a coach in the offices");
		System.out.println("Enter 2 to locate a player in the dressing rooms");
		System.out.println("Enter 3 to know in which office is a coach");
		System.out.println("Enter 4 to know in which part of the dressing rooms is a player");
		System.out.println("Enter 5 to exit this menu ");
		System.out.println("______________________________________________________________");
	}
	/**
	Read an option <br>
	<b> pre: </b><br>
	<b> post: </b> The option has been read <br>
	@return choice
	*/
	public int readOption(){
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	/**
	One of the general menu options that are requested is made <br>
	<b> pre: </b><br>
	<b> post: </b> Given a number, the operation that the number indicates is done <br>
	@param choice int that indicates the option choosen by the user
	*/
	public void doGeneralMenuOperation(int choice){
		int option=0;
		switch(choice){
			case EMPLOYEE_RELATED_MENU:
				do{
					showEmployeeMenu();
					option=readOption();
					doEmployeeMenuOperation(option);
				}
				while(option!=EXIT_EMPLOYEE_MENU);
				break;
			case TEAM_RELATED_MENU:
				do{
					showTeamMenu();
					option=readOption();
					doTeamMenuOperation(option);
				}
				while(option!=EXIT_TEAM_MENU);
				break;
			case FACILITY_RELATED_MENU:
				do{
					showFacilityMenu();
					option=readOption();
					doFacilityMenuOperation(option);
				}
				while(option!=EXIT_FACILITY_MENU);
				break;
			case DISPLAY_CLUB_GENERAL_INFORMATION:
				System.out.println(footballClub.showGeneralInfo());
				break;
			case EXIT:
				break;
			default:
				System.out.println("Please enter a valid option");	
		}
	}
	
	/**
	One of the employee menu options that are requested is made <br>
	<b> pre: </b><br>
	<b> post: </b> Given a number, the operation that the number indicates is done <br>
	@param choice int that indicates the option choosen by the user
	*/
	public void doEmployeeMenuOperation(int choice){
		switch(choice){
			case HIRE_AN_EMPLOYEE:
				hireAnEmployee();
				break;
			case FIRE_AN_EMPLOYEE:
				fireAnEmployee();
				break;
			case UPDATE_THE_INFORMATION_OF_AN_EMPLOYEE:
				updateTheInformationOfAnEmployee();
				break;
			case DISPLAY_EMPLOYEE_INFORMATION:
				displayAnEmployeeInformation();
				break;
			case DISPLAY_ALL_EMPLOYEES_INFORMATION:
				System.out.println(footballClub.getInfoOfAllEmployees());
				break;	
			case EXIT_EMPLOYEE_MENU:
				break;
			default:
				System.out.println("Please enter a valid option");
		}		
	}
	/**
	Hires an employee for the club <br>
	<b> pre: </b>Don't add a employee that is already in the club<br>
	<b> post: </b> Given the data a employee is hired<br>
	*/
	public void hireAnEmployee(){
		int option=0;
		System.out.println("Enter the employee's name: ");
		String employeeName=sc.nextLine();
		System.out.println("Enter the employee ID: ");
		String employeeID= sc.nextLine();
		System.out.println("Enter the employee salary: ");
		int employeeSalary= sc.nextInt();
		sc.nextLine();
		System.out.println("Enter what type of employee is going to be added. Enter 1 for a player, 2 for a head coach and 3 for an assistant coach");
		option=sc.nextInt();
		sc.nextLine();
		switch(option){
			case 1:
				hireAPlayer(employeeName,employeeID,employeeSalary);
				break;
			case 2:
				hireAHeadCoach(employeeName,employeeID,employeeSalary);
				break;
			case 3:
				hireAnAssistantCoach(employeeName,employeeID,employeeSalary);
				break;
			default:
				System.out.println("Please enter a valid option");
		}		
	}
	/**
	Hires a player for the club <br>
	<b> pre: </b>Don't add a player that is already in the club<br>
	<b> post: </b> Given the data a player is hired<br>
	@param employeeName String that indicates the name of the employee
	@param employeeID String that indicates the identifier of the employee
	@param employeeSalary int that indicates the salary of the employee
	*/
	public void hireAPlayer(String employeeName,String employeeID,int employeeSalary){
		System.out.println("Enter the T-Shirt number of the player ");
		int playerTShirtNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the number of goals the player has scored");
		int playerGoalsScored = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the average rating of the player. Must be a number from 1 to 5. ");
		double playerAverageRating = sc.nextDouble();
		System.out.println("Enter the position of the player. Use 1 for goalkeeper, 2 for defender, 3 for midfielder and 4 for striker ");
		int playerPositionIndicator=sc.nextInt();
		sc.nextLine();
		footballClub.hireAnEmployee(employeeName,employeeID,employeeSalary,playerTShirtNumber,playerGoalsScored,playerAverageRating,playerPositionIndicator);
	}
	/**
	Hires a head coach for the club <br>
	<b> pre: </b>Don't add a head coach that is already in the club<br>
	<b> post: </b> Given the data a head coach is hired<br>
	@param employeeName String that indicates the name of the employee
	@param employeeID String that indicates the identifier of the employee
	@param employeeSalary int that indicates the salary of the employee
	*/
	public void hireAHeadCoach(String employeeName,String employeeID,int employeeSalary){
		System.out.println("Enter the years of experience of the coach");
		int coachExperienceYears=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the number of teams the coach has taken care of");
		int coachNumberOfTeamsInCharge = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the number of championships the trainer has managed to win leading a team");
		int coachNumberOfChampionshipsAchieved = sc.nextInt();
		sc.nextLine();
		footballClub.hireAnEmployee(employeeName,employeeID,employeeSalary,coachExperienceYears,coachNumberOfTeamsInCharge,coachNumberOfChampionshipsAchieved);
	}
	/**
	Hires an assistant coach for the club <br>
	<b> pre: </b>Don't add an assistant coach that is already in the club<br>
	<b> post: </b> Given the data an assistant coach is hired<br>
	@param employeeName String that indicates the name of the employee
	@param employeeID String that indicates the identifier of the employee
	@param employeeSalary int that indicates the salary of the employee
	*/
	public void hireAnAssistantCoach(String employeeName,String employeeID,int employeeSalary){
		System.out.println("Enter the years of experience of the coach");
		int coachExperienceYears=sc.nextInt();
		sc.nextLine();
		System.out.println("Indicate if the coach was a player or not. Enter true or false");
		boolean wasAPlayer = sc.nextBoolean();
		sc.nextLine();
		System.out.println("Enter the expertise of the coach. 1 for offensive, 2 for deffensive, 3 for possesion, 4 for lab plays");
		int coachExpertiseIndicator = sc.nextInt();
		sc.nextLine();
		footballClub.hireAnEmployee(employeeName,employeeID,employeeSalary,coachExperienceYears,wasAPlayer,coachExpertiseIndicator);
	}
	/**
	Fires an employee <br>
	<b> pre: </b><br>
	<b> post: </b> Given the name, fires the employee with that name <br>
	*/
	public void fireAnEmployee(){
		System.out.println("Enter the name of the employee you want to fire: ");
		String employeeName = sc.nextLine();
		int employeeIndex = footballClub.findEmployee(employeeName);
		boolean success = footballClub.fireAnEmployee(employeeIndex);
		if(success){
			System.out.println("The employee "+employeeName+" has been fired");
		}
		else{
			System.out.println("The employee "+employeeName+" could not be fired because he doesn't exist ");
		}
	}
	/**
	Updates the information of an employee <br>
	<b> pre: </b><br>
	<b> post: </b> Given the name, updates the information of that employee <br>
	*/
	public void updateTheInformationOfAnEmployee(){
		System.out.println("Enter the name of the employee you want to update: ");
		String employeeName = sc.nextLine();
		int employeeIndex = footballClub.findEmployee(employeeName);
		System.out.println("What do you want to update? 1 for name, 2 for id, 3 for salary: ");
		int decision = sc.nextInt();
		sc.nextLine();
		switch(decision){
			case 1:
				System.out.println("Enter the new name ");
				String newName = sc.nextLine();
				System.out.println(footballClub.updateNameOfAnEmployee(employeeIndex,newName));
				break;
			case 2:
				System.out.println("Enter the new ID ");
				String newID = sc.nextLine();
				System.out.println(footballClub.updateIDOfAnEmployee(employeeIndex,newID));
				break;
			case 3:
				System.out.println("Enter the new salary ");
				int newSalary = sc.nextInt();
				sc.nextLine();
				System.out.println(footballClub.updateSalaryOfAnEmployee(employeeIndex,newSalary));
				break;
			default:
				System.out.println("Enter a valid option");
		}
	}
	/**
	Displays the information of an employee <br>
	<b> pre: </b><br>
	<b> post: </b> Given the name, displays the information of that employee <br>
	*/
	public void displayAnEmployeeInformation(){
		System.out.println("Enter the name of the employee whose information you want to see");
		String employeeName=sc.nextLine();
		int employeeIndex = footballClub.findEmployee(employeeName);
		System.out.println(footballClub.getInfoOfAnEmployee(employeeIndex));
	}
	/**
	One of the team menu options that are requested is made <br>
	<b> pre: </b><br>
	<b> post: </b> Given a number, the operation that the number indicates is done <br>
	@param choice int that indicates the option choosen by the user
	*/
	public void doTeamMenuOperation(int choice){
		switch(choice){
			case INITIALIZE_ONE_TEAM:
				initializeATeam();
				break;
			case ADD_AN_EMPLOYEE_TO_A_TEAM:
				addAnEmployeeToATeam();
				break;
			case ADD_A_LINEUP_TO_A_TEAM:
				addALineupToATeam();
				break;	
			case DISPLAY_GENERAL_TEAM_INFORMATION:
				displayATeamGeneralInformation();
				break;
			case SHOW_PLAYERS_OF_THE_TEAM:
				displayATeamPlayers();
				break;
			case DISPLAY_TEAM_LINEUPS:
				displayATeamLineups();
				break;
			case EXIT_TEAM_MENU:
				break;
			default:
				System.out.println("Please enter a valid option");
		}		
	}
	/**
	Initializes a team of the club <br>
	<b> pre: </b><br>
	<b> post: </b> Given the data a team is initialized <br>
	*/
	public void initializeATeam(){
		System.out.println("Enter the name you want to give to the team: ");
		String teamName=sc.nextLine();
		System.out.println("Enter the name of the head coach ");
		String headCoachName = sc.nextLine();
		int employeeIndex = footballClub.findEmployee(headCoachName);
		int employeeType = 0;
		boolean aux=false;
		if(employeeIndex!=-1){
			employeeType= footballClub.employeeInstanceOf(employeeIndex);
			if(employeeType==2){
				HeadCoach teamHeadCoach = footballClub.giveAHeadCoachWithIndex(employeeIndex);
				aux=footballClub.initializeATeam(teamName,teamHeadCoach);
				if(aux){
					System.out.println("The team has been initialized correctly");
				}
				else{
					System.out.println("ERROR: The teams were already initialized");
				}
			} 
			else{
				System.out.println("The team could not be initialized, the employee entered is not a head coach");
			}
		}
		else{
			System.out.println("Could not initialize team, entered head coach does not exist");
		}
	}
	/**
	Adds an employee to the team <br>
	<b> pre: </b><br>
	<b> post: </b> Given the data an employee is added to a team <br>
	*/
	public void addAnEmployeeToATeam(){
		String info = "";
		System.out.println("Enter the team name: ");
		String teamName=sc.nextLine();
		System.out.println("Enter the name of the employee");
		String employeeName = sc.nextLine();
		System.out.println("Enter if the employee is a player or a technical assistant. 1 for player, 2 for assistant coach");
		int employeeType = sc.nextInt();
		sc.nextLine();
		switch(employeeType){
			case 1:
				info = footballClub.addAPlayerToTheTeam(teamName,employeeName);
				System.out.println(info);
				break;
			case 2:
				info = footballClub.addAnAssistantCoachToTheTeam(teamName,employeeName);
				System.out.println(info);
				break;
			default:
				System.out.println("Please enter a valid option ");
		}
	}
	/**
	Adds a lineup to a team <br>
	<b> pre: </b><br>
	<b> post: </b> Given the data a lineup is added to a team <br>
	*/
	public void addALineupToATeam(){
		String info = "";
		System.out.println("Enter the name of the team to which you want to add a lineup");
		String teamName = sc.nextLine();
		System.out.println("Enter the creation date of the lineup. Use a format DD/MM/YYYY ");
		String lineupDate = sc.nextLine();
		System.out.println("Enter the tactic of the lineup. Use 1 for possesion, 2 for counterattack, 3 for high pressure.");
		int lineupTacticIndicator = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the formation of the lineup. Use minimum 3 digits (like 4-4-2) and maximum 6 (like 2-2-2-1-2-1");
		String lineupFormationString = sc.nextLine();
		Lineup teamLineup = new Lineup(lineupDate,lineupTacticIndicator,lineupFormationString);
		info = footballClub.addALineup(teamName,teamLineup);
		System.out.println(info);
	}
	/**
	Displays the information of a team <br>
	<b> pre: </b><br>
	<b> post: </b> Given the name, displays the general information of that team <br>
	*/
	public void displayATeamGeneralInformation(){
		System.out.println("Enter the name of the team whose information you want to see");
		String teamName=sc.nextLine();
		int teamIndex = footballClub.findTeam(teamName);
		System.out.println(footballClub.getInfoOfATeam(teamIndex));
	}
	/**
	Displays the players of a team <br>
	<b> pre: </b><br>
	<b> post: </b> Given the name, displays the players of that team <br>
	*/
	public void displayATeamPlayers(){
		System.out.println("Enter the name of the team whose information you want to see");
		String teamName=sc.nextLine();
		int teamIndex = footballClub.findTeam(teamName);
		System.out.println(footballClub.getPlayersOfATeam(teamIndex));
	}
	/**
	Displays the lineups of a team <br>
	<b> pre: </b><br>
	<b> post: </b> Given the name, displays the lineups of that team <br>
	*/
	public void displayATeamLineups(){
		System.out.println("Enter the name of the team whose information you want to see");
		String teamName=sc.nextLine();
		int teamIndex = footballClub.findTeam(teamName);
		System.out.println(footballClub.getLineupsOfATeam(teamIndex));
	}
	/**
	One of the facility-related menu options that are requested is made <br>
	<b> pre: </b><br>
	<b> post: </b> Given a number, the operation that the number indicates is done <br>
	@param choice int that indicates the option choosen by the user
	*/
	public void doFacilityMenuOperation(int choice){
		switch(choice){
			case LOCATE_A_COACH_IN_A_OFFICE:
				
				break;
			case LOCATE_A_PLAYER_IN_A_DRESSING_ROOM:
				
				break;
			case KNOW_THE_OFFICE_OF_A_COACH:
				
				break;	
			case KNOW_THE_DRESSING_ROOM_OF_A_PLAYER:
				
				break;
			case EXIT_FACILITY_MENU:
				
				break;
			default:
				System.out.println("Please enter a valid option");
		}		
	}
	
	/**
	Starts the program <br>
	<b> pre: </b><br>
	<b> post: </b> Starts the program <br>
	*/
	public void startProgram(){
		int option=0;
		do{
			showGeneralMenu();
			option=readOption();
			doGeneralMenuOperation(option);
		}while(option!=EXIT);
	}
	
}