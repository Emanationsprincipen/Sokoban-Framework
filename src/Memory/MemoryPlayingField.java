package Memory;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;

import Framework.PlayingField;
import Framework.Tile;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * UNO card textures are in the public domain
 * 
 * 
 * 
 * 
 * **/
public class MemoryPlayingField extends PlayingField<MemoryTile> {
	List<MemoryTile> pairs;
	List<Boolean> pairsUnique;
	int tilesOpen;
	LinkedList<LinkedList<Boolean>> uniquePosition;
	private int rand0 = 0;
	private int rand1 = 0;
	public int clicks;
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * @param thisSize How big the playing field should be
	 * @param tileSize How big a tile should be
	 * 
	 * 
	 * 
	 * 
	 * **/
	protected MemoryPlayingField(Dimension thisSize, Dimension tileSize) {
		super(thisSize, tileSize, new MemoryTile(MemoryTile.WILDCARD));
		for(LinkedList<MemoryTile> l : internal){
			for(MemoryTile et : l){
				et.container = this;
				et.wildcard = true;
			}
		}
		//String p = "H:\\ecplise\\aoop project\\uno_small";
		String p = "//home//jonathan//eclipse-workspace//aoop project//uno_small//";
		pairs = new LinkedList<MemoryTile>();
		pairsUnique = new LinkedList<Boolean>();
		tilesOpen = 0;
		MemoryTile t;
		for(int i = 0; i < 10; i++){
			//t = new MemoryTile(""+p+"\\blue_"+i+".png",this);
			t = new MemoryTile(""+p+"//blue_"+i+".png",this);
			t.setSize(this.tileSize);
			System.out.println(t.tPATH+" ");
			pairs.add(t);
			//t = new MemoryTile(""+p+"\\red_"+i+".png",this);
			t = new MemoryTile(""+p+"//red_"+i+".png",this);
			t.setSize(this.tileSize);
			System.out.println(t.tPATH+" ");
			pairs.add(t);
			//t = new MemoryTile(""+p+"\\green_"+i+".png",this);
			t = new MemoryTile(""+p+"//green_"+i+".png",this);
			t.setSize(this.tileSize);
			System.out.println(t.tPATH+" ");
			pairs.add(t);
			//t = new MemoryTile(""+p+"\\yellow_"+i+".png",this);
			t = new MemoryTile(""+p+"//yellow_"+i+".png",this);
			t.setSize(this.tileSize);
			System.out.println(t.tPATH+" ");
			pairs.add(t);
			System.out.print(i+" ");
		}System.out.println();
		
		uniquePosition = new LinkedList<LinkedList<Boolean>>();
		for(int i = 0; i < this.amountOfTiles.getHeight(); i++){
			uniquePosition.add(new LinkedList<Boolean>());
			for(int j = 0; j < this.amountOfTiles.getWidth(); j++){
				uniquePosition.get(i).add(Boolean.TRUE);
			}
		}
		
		
		for(MemoryTile pair : pairs){
			pairsUnique.add(Boolean.TRUE);
			//System.out.println(pair);
		}
		
		int rand;
		while(this.hasNullSubTile()){
				while(true){
					rand = 0 + (int)(Math.random() * ((pairs.size()-1 - 0) + 1));
					System.out.println("Rand: "+rand +" pairs.size:"+pairs.size());
					if(rand > pairs.size()) {
						System.exit(0);
					}
					pairsUnique.set(rand, Boolean.FALSE);
					if(!pairsUnique.get(rand).booleanValue()){
						System.out.println(rand);
						break;
					}
				}
				setSubTile(rand0,rand1,pairs.get(rand));
				this.getPosition(rand0, rand1).setRecyclingSubTile(pairs.get(rand));
				genint();
				setSubTile(rand0,rand1,pairs.get(rand));
				this.getPosition(rand0, rand1).setRecyclingSubTile(pairs.get(rand));
				//this.setPosition(0, 0, pairs.get(rand));
		}
	
	}
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Add a pair to the set of pairs
	 * @param t A tile to add to the pairs deck that will be randomly selected from in the constructor when
	 * constructing the game board
	 * 
	 * 
	 * 
	 * 
	 * **/
	public void addPair(MemoryTile t){
		pairs.add(t);
	}
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Set the pairs deck to a specific deck
	 * @param t A list of MemoryTiles that will become the "pairs" deck
	 * 
	 * 
	 * 
	 * 
	 * **/
	public void setDeck(LinkedList<MemoryTile> t){
		pairs = t;
	}
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Generate a random position on the playing board for the card(pair) selected.
	 * 
	 * 
	 * 
	 * 
	 * **/
	private void genint(){
		while(true){
			rand0 = 0 + (int)(Math.random() * ((amountOfTiles.getHeight()-1 - 0) + 1));
			rand1 = 0 + (int)(Math.random() * ((amountOfTiles.getWidth()-1 - 0) + 1));
			System.out.println("("+rand0+","+rand1+")");
			uniquePosition.get(rand0).set(rand1,Boolean.FALSE);
			if(!uniquePosition.get(rand0).get(rand1).booleanValue()){
				uniquePosition.get(rand0).set(rand1,Boolean.FALSE);
				break;
			}
		}
	}
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Generate a random position on the playing board for the card(pair) selected.
	 * 
	 * @deprecated
	 * This function should set all tiles on screen to the wildcard. Don't know if it does any more.
	 * 
	 * 
	 * **/
	public void wildcardAllContainers(){
		for(LinkedList<MemoryTile> l : internal){
			for(MemoryTile et : l){
				if(!et.wildcard){
					et.reverse();
					et.wildcard = true;
				}
			}
		}
	}

}
















