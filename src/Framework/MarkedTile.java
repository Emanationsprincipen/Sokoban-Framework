package Framework;

import java.awt.Dimension;

public abstract class MarkedTile extends Tile implements Marked{
	boolean marked;
	
	public MarkedTile(Dimension gameSize){
		super(gameSize);
		marked = true;
	}
	public boolean getMarkedStatus(){
		return marked;
	}
	public void setMarkedStatus(boolean b){
		marked = b;
	}
}
