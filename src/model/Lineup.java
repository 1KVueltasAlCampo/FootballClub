package model;
public class Lineup {
	public final static int ROWS = 10;
	private final static int COLUMNS = 7;
	private String lineupDate;
	private int lineupTacticIndicator;
	private Tactic lineupTactic;
	private int[][] formationMatrix;
	private String formationString;
	
	/**
	Constructor method of the class "Lineup" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type Lineup <br>
	@param lineupDate String that indicates the date of the lineup
	@param lineupTacticIndicator int that indicates the tactic of the lineup. 1 for possesion, 2 for counterattack, 3 for high pressure.
	@param formationString String that indicates the formation of the lineup
	*/
	public Lineup(String lineupDate, int lineupTacticIndicator, String formationString){
		this.lineupDate=lineupDate;
		this.lineupTacticIndicator=lineupTacticIndicator;
		this.formationString = formationString;
		lineupTactic = Tactic.values()[lineupTacticIndicator-1];
		formationMatrix = new int [ROWS] [COLUMNS];
		createFormationMatrix();
		
	}
	/**
	@param lineupDate String that indicates the date of the lineup
	*/
	public void setLineupDate(String lineupDate) {
		this.lineupDate=lineupDate;
	}
	/**
	@return The date of the lineup
	*/
	public String getLineupDate(){
		return lineupDate;
	}
	/**
	@param lineupTacticIndicator int that indicates the tactic indicator of the lineup
	*/
	public void setLineupTacticIndicator(int lineupTacticIndicator){
		this.lineupTacticIndicator=lineupTacticIndicator;
	}
	/**
	@return The tactic indicator of the lineup
	*/
	public int getLineupTacticIndicator(){
		return lineupTacticIndicator;
	}
	/**
	@return The tactic of the lineup
	*/
	public String getLineupTactic(){
		String info = lineupTactic.toString();
		return info;
	}
	/**
	@param formationString String that indicates the formation of the lineup
	*/
	public void setFormationString(String formationString){
		this.formationString=formationString;
	}
	/**
	@return The formation of the lineup
	*/
	public String getFormationString(){
		return formationString;
	}
	/**
	Converts a String with the formation to an array of integers in order to facilitate the following operations<br>
	<b> pre: </b> <br>
	<b> post: </b> Returns an array of integers with the formation of the players <br>
	@return playersPerRow
	*/
	public int[] getPlayersPerRow(){
		String auxA= getFormationString();
		String[] aux = auxA.split("-");
		int[] playersPerRow = new int[aux.length];
		for(int i=0;i<aux.length;i++){
			playersPerRow[i]=Integer.parseInt(aux[i]);
		}
		return playersPerRow;
	}
	/**
	Creates the formation matrix<br>
	<b> pre: </b> <br>
	<b> post: </b> The class now has a formation matrix based on the information the user gave <br>.30100
	*/
	public void createFormationMatrix(){
		int[] formationIndicator = getPlayersPerRow();
		switch(formationIndicator.length){
			case 3:
				organizeRows(2,formationIndicator[2]);
				organizeRows(5,formationIndicator[1]);
				organizeRows(8,formationIndicator[0]);
				break;
			case 4:
				organizeRows(2,formationIndicator[3]);
				organizeRows(4,formationIndicator[2]);
				organizeRows(6,formationIndicator[1]);
				organizeRows(8,formationIndicator[0]);
				break;
			case 5:
				organizeRows(2,formationIndicator[4]);
				organizeRows(3,formationIndicator[3]);
				organizeRows(5,formationIndicator[2]);
				organizeRows(6,formationIndicator[1]);
				organizeRows(8,formationIndicator[0]);
				break;
			case 6:
				organizeRows(2,formationIndicator[5]);
				organizeRows(3,formationIndicator[4]);
				organizeRows(4,formationIndicator[3]);
				organizeRows(5,formationIndicator[2]);
				organizeRows(6,formationIndicator[1]);
				organizeRows(8,formationIndicator[0]);
				break;
		}
	}
	/**
	Organizes the players according to the row they should be in<br>
	<b> pre: </b> <br>
	<b> post: </b> Players are ordered in their respective row in the matrix <br>
	@param rowIndicator Int that indicates the row in which the players are
	@param playersPerRow Int that indicates the number of players that are for each row
	*/
	public void organizeRows(int rowIndicator,int playersPerRow){
		switch(playersPerRow){
			case 1:
				formationMatrix[rowIndicator][3]=1;
				break;
			case 2:
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][4]=1;
				break;
			case 3:
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][3]=1;
				formationMatrix[rowIndicator][4]=1;
				break;
			case 4:
				formationMatrix[rowIndicator][1]=1;
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][4]=1;
				formationMatrix[rowIndicator][5]=1;
				break;
			case 5:
				formationMatrix[rowIndicator][1]=1;
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][3]=1;
				formationMatrix[rowIndicator][4]=1;
				formationMatrix[rowIndicator][5]=1;
				break;
			case 6:
				formationMatrix[rowIndicator][1]=1;
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][3]=1;
				formationMatrix[rowIndicator][4]=1;
				formationMatrix[rowIndicator][5]=1;
				formationMatrix[rowIndicator][6]=1;
				break;
			case 7:
				for(int i=0;i<6;i++){
					formationMatrix[rowIndicator][i]=1;
				}
				break;
		}
	}
	/**
	Returns the number of strikers the formation has <br>
	<b> pre: </b> <br>
	<b> post: </b> The number of strikers has been returned <br>
	@return count
	*/
	public int getStrikers(){
		int count=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<COLUMNS;j++){
				if(formationMatrix[i][j]==1){
					count++;
				}
			}
		}
		return count;
	}
	/**
	Returns the number of midfielders the formation has <br>
	<b> pre: </b> <br>
	<b> post: </b> The number of midfielders has been returned <br>
	@return count
	*/
	public int getMidfielders(){
		int count=0;
		for(int i=4;i<7;i++){
			for(int j=0;j<COLUMNS;j++){
				if(formationMatrix[i][j]==1){
					count++;
				}
			}
		}
		return count;
	}
	/**
	Returns the number of defenders the formation has <br>
	<b> pre: </b> <br>
	<b> post: </b> The number of defenders has been returned <br>
	@return count
	*/
	public int getDefenders(){
		int count=0;
		for(int i=7;i<10;i++){
			for(int j=0;j<COLUMNS;j++){
				if(formationMatrix[i][j]==1){
					count++;
				}
			}
		}
		return count;
	}
	/**
	Returns the content of the formation matrix <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on the content of the matrix, a String with all the information is obtained <br>
	@return info
	*/
	public String getFormationMatrix(){
		String info="";
		for(int i=0;i<ROWS;i++){
			for(int j=0;j<COLUMNS;j++){
				info += formationMatrix[i][j] + " ";
			}
			info+= "\n";
		}
		return info;
	}
	/**
	Returns all the information of the player <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on all the information of the player, a String with all the information is obtained <br>
	@return info
	*/
	public String getInfo(){
		String info="";
		info += "**************  Lineup **************"+"\n";
		info += "Date: "+getLineupDate()+"\n";
		info += "Tactic: "+getLineupTactic()+"\n";
		info += "Formation: "+getFormationString()+"\n"+"\n";
		info += getFormationMatrix()+"\n";
		info += "Strikers: "+getStrikers()+" Midfielders: "+getMidfielders()+" Defenders "+getDefenders()+"\n";
		info += "*************************************"+"\n";
		return info;
	}
}