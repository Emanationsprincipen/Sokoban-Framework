package Sokoban;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Framework.CollidableTile;
import Framework.EmptyTile;
import Framework.Tile;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * The Sokoban player is a tile
 * 
 * 
 * 
 * 
 * **/
public class Player extends CollidableTile{
	public static String PLAYER = "H:\\ecplise\\aoop project\\sokoban_icons\\player.png";
	public Player(Dimension gameSize){
		super(gameSize);
		this.setTexture(PLAYER);
		
		this.repaint();
	}

	public Player(Dimension iconSize, Image image) {
		super(iconSize,image);
	}

	@Override
	public boolean getCollisionStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCollisionStatus(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Tile clone() {
		return new Player(this.iconSize,this.image);
	}




}
