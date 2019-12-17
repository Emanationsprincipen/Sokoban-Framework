package Sokoban;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import Framework.ConcreteListener;
import Framework.EmptyTile;
import Framework.GameWindow;

import Framework.PlayingField;
import Framework.Tile;

public class Sokoban extends GameWindow {
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Main Sokoban Class, Handles input from keylistener primarily (window is focused)
	 * 
	 * 
	 * 
	 * 
	 * **/
	public static void main(String[] args){
		Sokoban b = new Sokoban();
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
			   b.gameArea.repaint();
			   b.gameArea.repaintall();
			  }
			}, 0, 100);
		//while(true){
			//b.gameArea.repaintall();
		//}
	}
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Generic constructor. Does all the necessary preparatory work and loads the map from the string.
	 * 
	 * 
	 * 
	 * 
	 * **/
	public Sokoban(){
		super(new SokobanField(new Dimension(11,9),new Dimension(50,50)));
		this.setResizable(false);
		Dimension tileSize = this.gameArea.tileSize;
		Dimension amountOfTiles = this.gameArea.amountOfTiles;

		this.gameArea.repaint();
		this.gameArea.setPosition(0,0,new FloorTile(gameArea.tileSize));
		SokobanListener b = new SokobanListener(this.gameArea);
		this.addKeyListener(b);
		b.addGameReference(this);
		MapBuilder m = new MapBuilder();
		 String s = "  ##### \n###...# \n#:.B..# \n###.B:# \n#:##B.# \n#.#.:.## \n#B.MBB:# \n#...:..# \n######## \n         ";
		 m.buildMapPrototype(s,this.getTilesize());
		SokobanMapBuilder smb = new SokobanMapBuilder(this.getTilesize());
		smb.buildMap(s, this.getTilesize());

		gameArea.loadMap(m);
		((SokobanField) gameArea).makeInitialBoxList();
		((SokobanField) gameArea).drawPlayer();
	}
}
