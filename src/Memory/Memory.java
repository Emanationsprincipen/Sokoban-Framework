package Memory;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Framework.GameWindow;
import Framework.PlayingField;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * A MemoryPlayingField lives inside a gamewindow
 * UNO textures found online - public domain license 
 * 
 * 
 * 
 * 
 * **/
public class Memory extends GameWindow {
	MemoryPlayingField f;
	public Memory(PlayingField f){
		super(f);
		this.f = (MemoryPlayingField) f;
	}
	public Memory(){
		super(new MemoryPlayingField(new Dimension(5,5),new Dimension(50,50)));
		this.setResizable(false);
		this.setSize(new Dimension(267-10,289-10));
	}
	public static void main(String[] args){
		Memory m = new Memory();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
			   m.gameArea.repaint();
			   m.gameArea.repaintall();
			  }
			}, 0, 100);
		//while(true){
			//b.gameArea.repaintall();
		//}
		
	}
		
		
		

}
