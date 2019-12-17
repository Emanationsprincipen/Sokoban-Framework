package Sokoban;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Framework.CollidableTile;
import Framework.EmptyTile;
import Framework.Tile;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * Box Tile for pushing
 * 
 * 
 * 
 * 
 * **/
public class Box extends CollidableTile implements SokobanTile, BoxInterface{
	boolean collision;
	boolean movable;
	boolean marked;
	boolean strun;
	public static final String CRATE = "H:\\ecplise\\aoop project\\sokoban_icons\\crate.png";
	
	public Box(Dimension iconSize){
		super(iconSize);
		strun = true;
		collision = true;
		this.setTexture(CRATE);
		this.subtile = new FloorTile(iconSize);
		this.repaint();
	}
	public Box(Dimension tileSize,BufferedImage image){
		super(tileSize,image);
		strun = true;
		iconSize = tileSize;
		this.setLayout(new BorderLayout());
		this.setOpaque(true);
		this.image = image;
		subtile = null;
	}
	public Box(Dimension tileSize, boolean marked){
		super(tileSize);
		strun = true;
		collision = true;
		this.setTexture(CRATE);
		this.subtile = new DotFloorTile(iconSize);
		this.repaint();
		if(marked){
			subtile = new DotFloorTile(iconSize);
		}
		else{
			subtile = new FloorTile(iconSize);
		}
		
	}
	@Override
	protected Tile clone() {
		return new EmptyTile(this.iconSize,this.image);
	}
	@Override
	public boolean getCollisionStatus() {
		return collision;
	}
	@Override
	public void setCollisionStatus(boolean b) {
		collision = b;
		
	}
	@Override
	public boolean isCollidable() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isMoveable() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isMarkedTile() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setTileUnderBox(Tile t){
		this.subtile = t;
	}
	public Tile getTileUnderBox(){
		return subtile;
	}
	@Override
	public boolean isMarked() {
		return marked;
	}
	public void setisMarked(boolean b){
		marked = b;
		if(marked){
			this.setTexture(BoxMarked.CRATEMARKED);
			if(strun){
				strun = false;
				subtile = new DotFloorTile(iconSize);
			}
		}
		else{
			this.setTexture(CRATE);
			if(strun){
				strun = false;
				subtile = new FloorTile(iconSize);
			}
		}	
	}

	

}
