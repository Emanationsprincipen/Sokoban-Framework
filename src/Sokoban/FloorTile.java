package Sokoban;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Framework.EmptyTile;
import Framework.NonCollidableTile;
import Framework.Tile;

public class FloorTile extends NonCollidableTile implements SokobanTile{
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Sokoban floor tile
	 * 
	 * 
	 * 
	 * 
	 * **/
	boolean col;
	public static String BLANK = "H:\\ecplise\\aoop project\\sokoban_icons\\blank.png";
	public FloorTile(Dimension gameSize){
		super(gameSize);
		col = false;
		marked = false;
		this.setTexture(BLANK);
		
		this.repaint();
	}

	public FloorTile(Dimension iconSize, Image image) {
		super(iconSize,image);
	}

	@Override
	public boolean getCollisionStatus() {
		return col;
	}

	@Override
	public void setCollisionStatus(boolean b) {
		col = b;
		
	}

	@Override
	protected Tile clone() {
		return new FloorTile(this.iconSize,this.image);
	}

	@Override
	public boolean isCollidable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMoveable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMarkedTile() {
		// TODO Auto-generated method stub
		return false;
	}



	
}
