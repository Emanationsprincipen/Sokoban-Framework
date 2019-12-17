package Sokoban;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Framework.Tile;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * Dotted floor tile
 * 
 * 
 * 
 * 
 * **/
public class DotFloorTile extends FloorTile{
	public static String BLANKMARKED = "H:\\ecplise\\aoop project\\sokoban_icons\\blankmarked.png";
	public DotFloorTile(Dimension gameSize) {
		super(gameSize);
		marked = true; 
		this.setTexture(BLANKMARKED);
	
		this.repaint();
	}
	public DotFloorTile(Dimension iconSize,Image image) {
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
		return new DotFloorTile(this.iconSize,this.image);
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
		return true;
	}
}
