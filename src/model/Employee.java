package model;
public abstract class Employee {
	private String name;
	private String identifier;
	private int salary;
	private int statusIndicator;
	private Status employeeStatus;
	/**
	Constructor method of the class "Employee" <br>
	<b> pre: </b> This constructor should never be used. <br>
	<b> post: </b> Create an object of type Employee <br>
	@param name String that indicates the name of the employee
	@param identifier String that indicates the identifier of the employee
	@param salary int that indicates the salary of the employee
	*/
	public Employee(String name,String identifier,int salary){
		this.name=name;
		this.identifier=identifier;
		this.salary=salary;
		statusIndicator=1;
		employeeStatus = Status.values()[statusIndicator-1];
	}
	/**
	@param name String that indicates the name of the employee
	*/
	public void setName(String name){
		this.name=name;
	}
	/**
	@return The name of the employee
	*/
	public String getName(){
		return name;
	}
	/**
	@param identifier String that indicates the identifier of the employee
	*/
	public void setIdentifier(String identifier){
		this.identifier=identifier;
	}
	/**
	@return The identifier of the employee
	*/
	public String getIdentifier(){
		return identifier;
	}
	/**
	@param salary String that indicates the salary of the employee
	*/
	public void setSalary(int salary){
		this.salary=salary;
	}
	/**
	@return The salary of the employee
	*/
	public int getSalary(){
		return salary;
	}
	/**
	@param statusIndicator int that indicates the status of the employee. Must be 1 if the employee is active, 0 if not
	*/
	public void setStatusIndicator(int statusIndicator){
		this.statusIndicator=statusIndicator;
	}
	/**
	@return The status indicator of the employee
	*/
	public int getStatusIndicator(){
		return statusIndicator;
	}
	/**
	@return The status of the user (active or inactive)
	*/
	public String getStatus(){
		String info = employeeStatus.toString();
		return info;
	}
	/**
	Updates the employee status <br>
	<b> pre: </b> <br>
	<b> post: </b> The employee status is updated <br>
	*/
	public void updateStatus(){
		employeeStatus = Status.values()[statusIndicator-1];
	}
	/**
	Returns the basic information of the employee <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on the information that all employees must have, a String with all the basic information is obtained <br>
	@return info
	*/
	public String getBasicInformation(){
		updateStatus();
		String info = "";
		info += "**************  Employee **************"+"\n";
		info += "Name: "+getName()+"\n";
		info += "Identifier: "+getIdentifier()+"\n";
		info += "Salary: "+getSalary()+"\n";
		info += "Status: "+getStatus()+"\n";
		return info;
	}
	public abstract String getAllInformation();
}