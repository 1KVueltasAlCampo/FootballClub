package ui;
import model.*;
import java.util.*;
public class Menu{
	private final static int EMPLOYEE_RELATED_MENU = 1;
	private final static int TEAM_RELATED_MENU = 2;
	private final static int FACILITY_RELATED_MENU = 3;
	private final static int EXIT = 4;
	//
	private final static int HIRE_AN_EMPLOYEE = 1;
	private final static int FIRE_AN_EMPLOYEE = 2;
	private final static int DISPLAY_EMPLOYEE_INFORMATION = 3;
	private final static int EXIT_EMPLOYEE_MENU = 4;
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


	private footballClub=club;
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
		System.out.println("Enter 4 to exit ");
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
		System.out.println("Enter 3 to display employee information");
		System.out.println("Enter 4 to exit this menu ");
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
	
}