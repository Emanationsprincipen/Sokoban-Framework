package Sokoban;

import java.awt.Dimension;
import java.util.LinkedList;

import Framework.EmptyTile;
import Framework.PlayingField;
import Framework.Tile;
/**
 * @author Jonathan Jönsson, Carl Lindell
 * non-framework map builder
 * 
 * 
 * 
 * 
 * **/
public class MapBuilder<T extends Tile> {
	private LinkedList<LinkedList<T>> internal;
	public MapBuilder(){
		
	}
	public void buildMapPrototype(String s, Dimension tileSize){
		internal = new LinkedList<LinkedList<T>>();
		internal.add(new LinkedList<T>());
		int row = 0;
		for(char c : s.toCharArray()){
			switch(c){
				case '\r':
					internal.add(new LinkedList<T>());
					row++;
					break;
				case '\n':
					internal.add(new LinkedList<T>());
					row++;
					break;
				case '#':
					internal.get(row).add((T) new Wall(tileSize));
					break;
				case 'B':
					internal.get(row).add((T) new Box(tileSize));
					break;
				case ':':
					internal.get(row).add((T) new DotFloorTile(tileSize));
					break;
				case '.':
					internal.get(row).add((T) new FloorTile(tileSize));
					break;
				case 'M':
					Box b  = new Box(tileSize);
					b.setisMarked(true);
					internal.get(row).add((T) b);
					break;
				case ' ':
					internal.get(row).add((T) new BlankTile(tileSize));
					break;	
			}
		}
	}
	
	public MapBuilder(LinkedList<LinkedList<T>> l){
		internal = l;
	}
	public LinkedList<LinkedList<T>> getList(){
		return internal;
	}
}
