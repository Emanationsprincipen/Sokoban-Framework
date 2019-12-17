package Framework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class MovableTile extends CollidableTile implements Movable{
	boolean movable;
	
	public MovableTile(Dimension gameSize){
		super(gameSize);
		movable = true;
	}
	
	public MovableTile(Dimension tileSize, Image image) {
		super(tileSize,image);
		iconSize = tileSize;
		this.setLayout(new BorderLayout());
		this.setOpaque(true);
		this.image = image;
	}
	public boolean getMovableStatus(){
		return movable;
	}
	public void setMovableStatus(boolean b){
		movable = b;
	}
}
