package Framework;

public class Player {
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * Intended for turn-based logic games
	 * 
	 * 
	 * 
	 * 
	 * **/
	protected String playerName;
	protected int playerScore;
	protected boolean currentPlayer;
	
	public Player(){
		playerName = "Player";
		playerScore = 0;
		currentPlayer = false;
	}
	public String getplayerName(){
		return this.playerName;
	}
	public void setplayerName(String s){
		this.playerName = s;
	}
	public int getPlayerScore(){
		return this.playerScore;
	}
	public void setPlayerScore(int i){
		this.playerScore = i;
	}
	public boolean getCurrentPlayer(){
		return this.currentPlayer;
	}
	public void setcurrentPlayer(boolean b){
		this.currentPlayer = b;
	}
}
