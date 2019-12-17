package Framework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public abstract class NonCollidableTile extends Tile implements Collidable{
	boolean collision;
	protected boolean marked;
	public NonCollidableTile(Dimension gameSize){
		super(gameSize);
		collision = false;
	}
	public NonCollidableTile(Dimension tileSize,Image image){
		super(tileSize,image);
		iconSize = tileSize;
		this.setLayout(new BorderLayout());
		this.setOpaque(true);
		this.image = image;
	}
}
