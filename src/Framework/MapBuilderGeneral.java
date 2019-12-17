package Framework;

import java.awt.Dimension;
import java.util.Hashtable;
import java.util.LinkedList;

import Sokoban.Box;
import Sokoban.DotFloorTile;
import Sokoban.FloorTile;
import Sokoban.Wall;

public class MapBuilderGeneral<T extends Tile> {
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param T extends Tile generic, can be used if you need a basic playingfield
	 * made of a special tile instead of a generic tile. using <Tile> in most cases is
	 * sufficient
	 * Generic map builder
	 * 
	 * 
	 * 
	 * **/
	protected LinkedList<LinkedList<T>> internal;
	public MapBuilderGeneral(){
		
		
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param s is the text to construct the map from
	 * tileSize is how big each tile is
	 * symbols is the dictionary for how to turn chars into tiles
	 * Generic map builder
	 * 
	 * 
	 * 
	 * **/
	public void buildTileMap(String s, Dimension tileSize, Hashtable<Character,Tile> symbols){
		internal = new LinkedList<LinkedList<T>>();
		internal.add(new LinkedList<T>());
		int row = 0;
		for(char c : s.toCharArray()){
			if(internal.size() > row) {
				internal.add(new LinkedList<T>());
			}
			internal.add(new LinkedList());
			if(c == '\r' || c == '\n') {
				internal.add((LinkedList<T>) new LinkedList<Tile>());
				row++;
			} else {
				Tile t = symbols.get(new Character(c));
				internal.get(row).add((T) t.clone());
			}
		}
	}
	public MapBuilderGeneral (LinkedList<LinkedList<T>> l){
		internal = l;
	}
	public LinkedList<LinkedList<T>> getList(){
		return internal;
	}
}
