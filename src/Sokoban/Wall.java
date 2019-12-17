package Sokoban;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Framework.CollidableTile;
import Framework.EmptyTile;
import Framework.Tile;

public class Wall extends CollidableTile implements SokobanTile{
	public static String WALL = "H:\\ecplise\\aoop project\\sokoban_icons\\wall.png";
	public Wall(Dimension tileSize){
		super(tileSize);
		this.setTexture(WALL);
		
	}

	public Wall(Dimension iconSize, BufferedImage image) {
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
	public boolean isCollidable() {
		return true;
	}

	@Override
	public boolean isMoveable() {
		return false;
	}

	@Override
	public boolean isMarkedTile() {
		return false;
	}

	@Override
	protected Tile clone() {
		return new Wall(this.getSize());
	}



	
}
