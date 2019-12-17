package Sokoban;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Framework.EmptyTile;
import Framework.PlayingField;
import Framework.Tile;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * All inter-tile logic happens in the playingfield except the keylistener
 * 
 * 
 * 
 * 
 * **/
public class SokobanField extends PlayingField<Tile>{
	int playerx;
	int playery;
	Player p;
	int oldx;
	int oldy;
	Tile oldTile;
	Box b;
	Tile oldTileUnderBox;
	List<BoxInterface> boxList;
	HashMap<Tile, Tile> underBox;
	
	boolean getCollisionStatus(int x, int y){
		Tile t = getPosition(x,y);
		if (t instanceof SokobanTile){
			SokobanTile st = (SokobanTile) t;
			return st.isCollidable();
		}
		return false;
	}
	boolean winCondition(){
		for(BoxInterface f : boxList){
			if(!f.isMarked()){
				return false;
			}
		}
		return true;
	}
	boolean getMovableStatus(int x, int y){
		Tile t = getPosition(x,y);
		if (t instanceof SokobanTile){
			SokobanTile st = (SokobanTile) t;
			return st.isMoveable();
		}
		return false;
	}
	boolean getMarkedStatus(int x, int y){
		Tile t = getPosition(x,y);
		if (t instanceof SokobanTile){
			SokobanTile st = (SokobanTile) t;
			return st.isMarkedTile();
		}
		return false;
	}
	SokobanField(Dimension amountOfTiles, Dimension tileSize){
		super(amountOfTiles, tileSize);
		playerx = 2;
		playery = 2;
		oldx = 2;
		oldy = 2;
		oldTile = new FloorTile(tileSize);
		//System.out.println(oldTile);
		drawPlayer();
		boxList = new LinkedList<BoxInterface>();
		
	}
	public void setPlayerPosition(int x, int y) {
		playerx = x;
		playery = y;
	}
	public Dimension getPlayerPosition(){
		return new Dimension(playerx, playery);
	}
	
	public void drawPlayer(){
		this.setPosition(oldx, oldy, oldTile);
		oldTile = getPosition(playerx, playery);
		oldx = playerx;
		oldy = playery;
		p = new Player(this.tileSize);
		this.setPosition(playerx, playery, p);
		p.repaint();
	}
	
	private Tile cloneTile_prototype(Tile t){
		if(t instanceof DotFloorTile){
			return new DotFloorTile(this.tileSize);
		}
		if(t instanceof FloorTile){
			return new FloorTile(this.tileSize);
		}
		if(t instanceof EmptyTile){
			return new EmptyTile(this.tileSize);
		}
		return null;
	}
	void moveBox(int xfrom, int yfrom, int xto, int yto){
		if(getCollisionStatus(xto,yto)){
			return;
		}else{
			Tile t = getPosition(xfrom,yfrom);
			setPosition(xfrom,yfrom,t.getSubTile());			
			if(getMarkedStatus(xto,yto)){
				t.setTexture(BoxMarked.CRATEMARKED);
				t.setSubTile(getPosition(xto,yto));
				setPosition(xto,yto,t);
				t.repaint();
				((Box)t).setisMarked(true);
				if(winCondition()){
					System.out.println("Win !!!!!!!!!!!!!!!!!!!!!!!!!!");
					this.getGraphics().drawString("YOU WON THE GAME!", 100, 100);
				}
			}
			else{
				t.setTexture(Box.CRATE);
				t.setSubTile(getPosition(xto,yto));
				setPosition(xto,yto,t);
				((Box)t).setisMarked(false);
				t.repaint();
			}
		}
	}
	
	void moveright(){

		if(playery+1 < 0){
			return;
		}
		if((getCollisionStatus(playerx, playery+1))){
			if(getCollisionStatus(playerx,playery+2)){
				return;
			}
			if(getMovableStatus(playerx,playery+1)){
				moveBox(playerx,playery+1,playerx,playery+2);
			}
			else
			return;
		}
		
		playery++;
		drawPlayer();
	}
	
	void moveleft(){
		if(playery-1 < 0){
			return;
		}
		if(getCollisionStatus(playerx, playery-1)){
			if(getCollisionStatus(playerx,playery-2)){
				return;
			}
			if(getMovableStatus(playerx,playery-1)){
				moveBox(playerx,playery-1,playerx,playery-2);
			}
			else
			return;
		}
		playery--;
		drawPlayer();
	}
	void moveup(){
		if(playerx-1 < 0){
			return;
		}
		if(getCollisionStatus(playerx-1, playery)){
			if(getCollisionStatus(playerx-2,playery)){
				return;
			}
			if(getMovableStatus(playerx-1,playery)){
				moveBox(playerx-1,playery,playerx-2,playery);
			}
			else
			return;
		}
		playerx--;
		drawPlayer();
	}
	void movedown(){
		if(playerx+1 > xlimit-1){
			return;
		}
		if(getCollisionStatus(playerx+1, playery)){
			if(getCollisionStatus(playerx+2,playery)){
				return;
			}
			if(getMovableStatus(playerx+1,playery)){
				moveBox(playerx+1,playery,playerx+2,playery);
			}
			else
			return;
		}
		playerx++;
		drawPlayer();
	}
	
	public void makeInitialBoxList(){
		for(LinkedList<Tile> list : this.internal ){
			for(Tile t : list){
				if(t instanceof Box){
					boxList.add((BoxInterface) t);
				}
			}
		}
	}
}

