package Framework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class EmptyTile extends Tile {
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Generic empty tile with no properties. Instantiable "tile" with no extra functionality
	 * 
	 * 
	 * 
	 * 
	 * **/
	public final static String DEVTEXT = "H:\\ecplise\\aoop project\\sokoban_icons\\devtext.png";
	public EmptyTile(Dimension gameSize){
		super(gameSize);
		this.setTexture(DEVTEXT);
		
	}
	public EmptyTile(Dimension tileSize,Image image){
		super(tileSize,image);
		iconSize = tileSize;
		this.setLayout(new BorderLayout());
		this.setOpaque(true);
		this.image = image;
	}
	@Override
	protected Tile clone() {
		return new EmptyTile(this.iconSize,this.image);
	}
}
