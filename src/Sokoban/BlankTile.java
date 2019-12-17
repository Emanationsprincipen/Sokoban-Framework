package Sokoban;

import java.awt.Dimension;

import Framework.CollidableTile;
import Framework.Tile;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * Blank tile for outside the walls
 * 
 * 
 * 
 * 
 * **/
public class BlankTile extends CollidableTile {
	public static final String EMPTYTILE = "H:\\ecplise\\aoop project\\sokoban_icons\\emptytile.png";
	public BlankTile(Dimension gameSize) {
		super(gameSize);
		this.setTexture(EMPTYTILE);
	}

	@Override
	protected Tile clone() {
		return new BlankTile(this.iconSize);
	}



}
