package Sokoban;

/**
 * @author Jonathan Jönsson, Carl Lindell
 * Used to work around the framework when default Tiles are used.
 * 
 * 
 * 
 * 
 * **/
public interface SokobanTile {
	boolean isCollidable();
	boolean isMoveable();
	boolean isMarkedTile();
}
