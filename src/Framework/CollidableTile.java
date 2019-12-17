package Framework;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * I guess you could just put "collidabletile" and "noncollidabletile" into one class, but this is also an (ugly) way to do it.
 * 
 * 
 * 
 * 
 * **/
public abstract class CollidableTile extends Tile implements Collidable{
	boolean collision;
	public CollidableTile(Dimension gameSize){
		super(gameSize);
		collision = true;
	}
	public CollidableTile(Dimension tileSize, Image image) {
			super(tileSize,image);
			iconSize = tileSize;
			this.setLayout(new BorderLayout());
			this.setOpaque(true);
			this.image = image;
	}
	public boolean getCollisionStatus(){
		return collision;
		
	}
	public void setCollisionStatus(boolean b){
		collision = b;
	}
}
