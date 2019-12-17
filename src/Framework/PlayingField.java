package Framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JPanel;

import Sokoban.FloorTile;
import Sokoban.MapBuilder;
/**
 * @author Jonathan Jönsson, Carl Lindell
 * @param <T> extends Tile  generic, can be used if you need a basic playingfield
 * made of a special tile instead of a generic tile. using Tile in most cases is
 * sufficient
 * 
 * 
 * 
 * 
 * **/
public class PlayingField<T extends Tile> extends JPanel{
	protected LinkedList<LinkedList<T>> internal;
	public final Dimension amountOfTiles;
	public final int xlimit;
	public final int ylimit;
	final int SIZE = 10;
	public final Dimension tileSize;
	T oldTile;
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param x position in x-direction
	 * @param y position in y-direction
	 * @param t T is either of type Tile or a subclass of tile, depending on what this specific playing field is made of.
	 * 
	 * 
	 * **/
	public void setPosition(int x, int y, T t){
		try {
			LinkedList<T> list1 = internal.get(x);
			System.out.println(" list1 size: "+ list1.size() + " x: " + x);
			Rectangle r = list1.get(y).getBounds();
			this.remove(list1.get(y));
			t.setBounds(r);
			list1.set(y, t);
			this.add(t);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("x:"+x+" y: "+y);
			System.exit(-1);
		}
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param x position in x-direction
	 * @param y position in y-direction
	 * @param t T is either of type Tile or a subclass of tile, depending on what this specific playing field is made of.
	 * @deprecated
	 * 
	 * **/
	public void setOverPosition(int x, int y, T t){
		LinkedList<T> list1 = internal.get(x);
		Rectangle r = list1.get(y).getBounds();
		t.setBounds(r);
		list1.set(y, t);
		this.add(t);
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param x position in x-direction
	 * @param y position in y-direction
	 * Gets the tile at position x, y
	 * 
	 * 
	 * **/
	public T getPosition(int x, int y){
		try{
			return internal.get(x).get(y);
		}catch(IndexOutOfBoundsException e){
			return null;
		}
		
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * Gets the position of tile T
	 * @deprecated
	 * 
	 * 
	 * **/
	public Dimension getPosition(T o){
		int i = 0;
		int j = 0;
		for(LinkedList<T> l : internal){
			if(j> internal.get(i).size()-1) {
				j = 0;
			}
			for(Tile et : l){
				if(et == o) {
					try {
					internal.get(i).get(j);
					}catch(IndexOutOfBoundsException e) {
						e.printStackTrace();
						System.out.println("i:"+i+" j: "+j);
						System.exit(0);
					}
					return new Dimension(i,j);
				}
				j++;
			}
			i++;
		}
		return null;
		
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param xfrom position in x-direction
	 * @param yfrom position in y-direction
	 * @param xto to position x in x-direction
	 * @param yto to position f in y direction
	 * 
	 * 
	 * **/
	public void swap(int xfrom,int yfrom,int xto,int yto){
		Tile temp = getPosition(xto,yto);
		setPosition(xto,yto,(T) getPosition(xfrom,yfrom));
		setPosition(xfrom,yfrom, (T)temp);
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @deprecated
	 * 
	 * 
	 * **/
	public <T extends Tile>void setGSubTile(int x,int y,T t){
		internal.get(x).get(y).subtile = t;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param x position in x-direction
	 * @param y position in y-direction
	 * @param t A tile object
	 * Sets the tile at position x,y to tile t
	 * 
	 * **/
	public void setSubTile(int x,int y,Tile t){
		internal.get(x).get(y).subtile = t;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param x position in x-direction
	 * @param y position in y-direction
	 * Gets the subtile at position x,y
	 * 
	 * 
	 * **/
	public Tile getSubTile(int x, int y){
		return internal.get(x).get(y).subtile;
	}
	/*
	public <T> T getTPosition(int x, int y){
		return (T) internal.get(x).get(y).subtile;
	}*/
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param x position in x-direction
	 * @param y position in y-direction
	 * @param l An instance of a mouse listener
	 * 
	 * Adds a mouse listener to a specific tile 
	 * **/
	public void addMouseListener(int x, int y,MouseListener l){
		internal.get(x).get(y).addMouseListener(l);
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param amountOfTiles (height,width) how many tiles to create in each direction
	 * @param tileSize How big a tile should be
	 * @param aTileType
	 * tileSize how big each tile is
	 * aTileType if you want to create a board of a different tiletype than default EmptyTile
	 * 
	 * Constructor
	 * 
	 * **/
	protected PlayingField(Dimension amountOfTiles, Dimension tileSize, TileInterface<T> aTileType){
		this.setLayout(null);
		this.tileSize = tileSize;
		this.amountOfTiles = amountOfTiles;
		this.setSize((int)(tileSize.getHeight()*amountOfTiles.getHeight()),(int)(tileSize.getWidth()*amountOfTiles.getWidth()));
		int tileWidth;
		int tileHeight;
		internal = new LinkedList<LinkedList<T>>();
		Insets insets = this.getInsets();
		for(int i  = 0; i < amountOfTiles.getWidth(); i++){
			LinkedList<T> sublist = new LinkedList<T>();
			internal.add(sublist);
			for(int j = 0; j < amountOfTiles.getHeight(); j++){
				T t = aTileType.create();
				t.seticonSize(tileSize);
				tileWidth =(int) t.iconSize.getWidth();
				tileHeight = (int)t.iconSize.getHeight();
				sublist.add(t);
				this.add(t);
				t.setBounds(j*tileWidth+insets.left,i*tileHeight+insets.top,tileWidth,tileHeight);
			}
		}
		this.setSize((int)(tileSize.getHeight()*amountOfTiles.getHeight()),(int)(tileSize.getWidth()*amountOfTiles.getWidth()));
		
		this.setVisible(true);
		xlimit = internal.size();
		ylimit = internal.get(0).size();
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param amountOfTiles (height,width) how many tiles to create in each direction
	 * @param tileSize How big a tile should be
	 * 
	 * 
	 * Alternative constructor. Creates a playing field made of default empty dev texture tiles.
	 * 
	 * **/
	protected PlayingField(Dimension amountOfTiles, Dimension tileSize){
		this.setLayout(null);
		this.tileSize = tileSize;
		this.amountOfTiles = amountOfTiles;
		this.setSize((int)(tileSize.getHeight()*amountOfTiles.getHeight()),(int)(tileSize.getWidth()*amountOfTiles.getWidth()));
		int tileWidth;
		int tileHeight;
		internal = new LinkedList<LinkedList<T>>();
		Insets insets = this.getInsets();
		for(int i  = 0; i < amountOfTiles.getWidth(); i++){
			LinkedList<T> sublist = new LinkedList<T>();
			internal.add(sublist);
			for(int j = 0; j < amountOfTiles.getHeight(); j++){
				T t = (T) new EmptyTile(tileSize);
				t.seticonSize(tileSize);
				tileWidth =(int) t.iconSize.getWidth();
				tileHeight = (int)t.iconSize.getHeight();
				sublist.add(t);
				this.add(t);
				t.setBounds(j*tileWidth+insets.left,i*tileHeight+insets.top,tileWidth,tileHeight);
			}
		}
		this.setSize((int)(tileSize.getHeight()*amountOfTiles.getHeight()),(int)(tileSize.getWidth()*amountOfTiles.getWidth()));
		
		this.setVisible(true);
		xlimit = internal.size();
		ylimit = internal.get(0).size();
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * Repaint all tiles.
	 * 
	 * **/
	public void repaintall(){
		for(LinkedList<T> l : internal){
			for(Tile et : l){
				et.repaint();
			}
		}
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * Checks if any tile in the playing field has a null subtile
	 * @return True if at least one tile has a null subtile
	 * false otherwise
	 * 
	 * **/
	public boolean hasNullSubTile(){
		for(LinkedList<T> l : internal){
			for(Tile et : l){
				if(et.subtile == null){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @deprecated
	 * Intended to add custom methods to tiles without subclassing a tile.
	 * @param f - an object wrapper for a method to do on a tile
	 * **/
	public boolean forAllTiles(forAllTilesInterface f){
		for(LinkedList<T> l : internal){
			for(Tile et : l){
				f.doSomething(et);
			}
		}
		return false;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * Set the current displayed map to the map contained in the MapBuilder m
	 * @param m A mapbuilder which has made a map 
	 * **/
	public void loadMap(MapBuilder m){
		this.removeAll();
		this.internal = m.getList();
		this.setSize((int)(amountOfTiles.getHeight()*100),(int)(amountOfTiles.getWidth()*100));
		this.setLayout(null);
		
		
		Insets insets = this.getInsets();
		int row = 0;
		int column = 0;
		int tileWidth;
		int tileHeight;
		
		for(LinkedList<T> l : internal){
			for(Tile et : l){
				tileWidth =(int) et.iconSize.getWidth();
				tileHeight = (int)et.iconSize.getHeight();
				this.add(et);
				et.setBounds(column*tileWidth+insets.left,row*tileHeight+insets.top,tileWidth,tileHeight);
				column++;
			}
			column = 0;
			row++;
		}
		this.setVisible(true);
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * Set the current displayed map to the map contained in the MapBuilder m
	 * @param m A MapBuilderGeneral which has made a map 
	 * @deprecated
	 * We never tested the general map builder that can create maps from arbitrary symbol tables. Might work.
	 * **/
	public void loadMap(MapBuilderGeneral<T> m){
		this.removeAll();
		this.internal = m.getList();
		this.setSize((int)(amountOfTiles.getHeight()*100),(int)(amountOfTiles.getWidth()*100));
		this.setLayout(null);
		Insets insets = this.getInsets();
		int row = 0;
		int column = 0;
		int tileWidth;
		int tileHeight;
		for(LinkedList<T> l : internal){
			for(Tile et : l){
				tileWidth =(int) et.iconSize.getWidth();
				tileHeight = (int)et.iconSize.getHeight();
				this.add(et);
				et.setBounds(column*tileWidth+insets.left,row*tileHeight+insets.top,tileWidth,tileHeight);
				column++;
			}
			column = 0;
			row++;
		}
		this.setVisible(true);
	}
	
}
