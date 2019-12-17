package Sokoban;

import java.awt.Dimension;
import java.util.Hashtable;
import java.util.LinkedList;

import Framework.EmptyTile;
import Framework.MapBuilderGeneral;
import Framework.Tile;
/**
 * @author Jonathan Jönsson, Carl Lindell
 * Using the framework to build maps from strings
 * 
 * 
 * 
 * 
 * **/
public class SokobanMapBuilder extends MapBuilderGeneral {
	
	Hashtable<Character,Tile> symbols;
	public void buildMap(String s, Dimension d){
		super.buildTileMap(s, d, symbols);
	}
	SokobanMapBuilder(Dimension d){
		symbols = new Hashtable<Character,Tile>();
		symbols.put('#', new Wall(d));
		symbols.put('B', new Box(d));
		symbols.put('.', new FloorTile(d));
		symbols.put('M', new Box(d));
		symbols.put(' ', new EmptyTile(d));
		symbols.put(':', new DotFloorTile(d));
	}
}
