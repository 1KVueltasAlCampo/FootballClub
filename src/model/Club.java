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
		this.clubNit=clubNit;
		this.clubFundationDate=clubFundationDate;
		clubEmployees=new ArrayList<Employee>();
		clubEmployeesAmount=0;
		clubTeams=new Team[2];
		dressingRoomA=new Player[7][6];
		dressingRoomB=new Player[7][7]:
		clubOffices=new Coach[6][6]:
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
}