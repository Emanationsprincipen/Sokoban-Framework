package Memory;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Framework.Tile;
import Framework.TileInterface;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * Generic MemoryTile specific for the MemoryGame with adequate extensions and modifications.
 * 
 * 
 * 
 * 
 * **/
public class MemoryTile extends Tile implements TileInterface<MemoryTile>, MouseListener{
	public String tPATH;
	//public final static String WILDCARD = "H:\\eclipse\\aoop project\\uno_small\\wild_color_changer.png";
	public final static String WILDCARD = "//home//jonathan//eclipse-workspace//aoop project//uno_small//wild_color_changer.png";
	public MemoryPlayingField container;
	public boolean wildcard;
	public MemoryTile(String PATH,MemoryPlayingField f){
		this.addMouseListener(this);
		//this.setTexture("H:\\ecplise\\aoop project\\uno_small\\wild_color_changer.png");
		//tPATH = "H:\\ecplise\\aoop project\\uno_small\\wild_color_changer.png";
		this.subtile = null;
		this.setTexture(PATH);
		tPATH = PATH;
		container = f;
		//this.subtile = new MemoryTile(PATH,this);
	}
	public MemoryTile(String PATH){
		this.addMouseListener(this);
		//this.setTexture("H:\\ecplise\\aoop project\\uno_small\\wild_color_changer.png");
		//tPATH = "H:\\ecplise\\aoop project\\uno_small\\wild_color_changer.png";
		this.subtile = null;
		this.setTexture(PATH);
		tPATH = PATH;
		container = null;
		//this.subtile = new MemoryTile(PATH,this);
	}
	public MemoryTile(){
		
	}
	public void setMemoryPlayingField(MemoryPlayingField f){
		container = f;
	}
	public MemoryTile(String PATH, Tile subtile){
		this.addMouseListener(this);
		this.setTexture(WILDCARD);
		tPATH = WILDCARD;
		this.subtile = subtile;
	}
	public MemoryTile(String PATH1,String PATH2){
		this.addMouseListener(this);
		this.setTexture(PATH1);
		this.subtile = new MemoryTile(PATH2, PATH1);
	}
	
	@Override
	protected Tile clone() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.reverse();
		
	}
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Reverse this card.
	 * 
	 * 
	 * 
	 * 
	 * **/
	Dimension comp;
	public void reverse(){
		if(!this.wildcard) {
			this.setTexture(MemoryTile.WILDCARD);
			//System.out.println("Firing Again!");
			this.wildcard = true;
			this.repaint();
			/*
			try {
				//Thread.sleep(100l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		}else {
			this.wildcard = false;
			this.setTexture(subtile.getImage());
			//System.out.println("Why isn't this working?!?!?");
			container.clicks++;
			//System.out.println(container.clicks);
		/*try {
				//Thread.sleep(100l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		if(container.clicks > 2) {
			container.wildcardAllContainers();
			container.clicks = 0;
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemoryTile create() {
		return new MemoryTile(WILDCARD,container);
		
	}
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Set this tiles subtile to point back to this tile and vice versa
	 * 
	 * 
	 * 
	 * 
	 * **/
	public void setRecyclingSubTile(MemoryTile t){
		//System.out.println("t.subtile.path Before t.setSubTile(this) "+((MemoryTile) t.subtile).tPATH);
		t.setSubTile(this);
		t.subtile.setSubTile(t);
		//System.out.println("t.subtile.path After t.setSubTile(this) "+((MemoryTile) t.subtile).tPATH);
		if(this.container == null) this.container = t.container;
		if(t.container == null) t.container = this.container;
		this.subtile = t;
		/*
		System.out.println("recycling: t.subtile: "+((MemoryTile)t.subtile).tPATH);
		System.out.println("recycling: subtile "+((MemoryTile)subtile).tPATH);
		System.out.println("recycling: t.subtile.subtile "+((MemoryTile)subtile.getSubTile()).tPATH);
		System.out.println("recycling: t.subtile.subtile.subtile "+((MemoryTile)subtile.getSubTile().getSubTile()).tPATH);
		*/
	}

}
