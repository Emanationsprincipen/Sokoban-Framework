package Framework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Timer;

import javax.swing.JFrame;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * A PlayingField lives inside a GameWindow
 * 
 * 
 * 
 * 
 * **/
public abstract class GameWindow extends JFrame{
	private Dimension tileSize;
	private Dimension windowSize;
	protected PlayingField gameArea;
	public static String textureFolder;
	AbstractKeyListener mainListener;
	public void setTileSize(Dimension d){
		tileSize = d;
	}
	public Dimension getTilesize(){
		return tileSize;
	}
	
	public void setWindowSize(Dimension d){
		windowSize = d;
		this.setSize(windowSize.width, windowSize.height);
	}
	
	public Dimension getWindowSize(){
		return windowSize;
	}
	
	public GameWindow(PlayingField f){
		gameArea = f;
		tileSize = f.tileSize;
		Dimension amountOfTiles = f.amountOfTiles;
		this.setSize((int)(amountOfTiles.height*tileSize.getHeight()),(int)(amountOfTiles.getWidth()*tileSize.getWidth()));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		this.add(gameArea);
		tileSize = f.tileSize;
		
	}
	private GameWindow(){
		//Never use this constructor
	}
	
	public void mouseClicked(MouseEvent arg0) {
		//gameArea.setFocusable(true);
		
	}
	public PlayingField getPlayingField() {
		return gameArea;
	}
}
