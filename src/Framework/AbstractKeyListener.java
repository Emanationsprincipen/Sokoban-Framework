package Framework;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class AbstractKeyListener implements KeyListener {
	/**
	 * @author Jonathan J�nsson, Carl Lindell
	 * Extend the class and override keyPressed(keyEvent e) to add your own keys, then add
	 * the subclassed concrete KeyListener to the GameWindow (subclassed too probably)
	 * 
	 * 
	 * 
	 * 
	 * **/
	public abstract void up();
	public abstract void down();
	public abstract void left();
	public abstract void right();
	public void keyPressed(KeyEvent e) {
	       switch (e.getKeyCode()) {
	       case KeyEvent.VK_LEFT:
	          left();

	          break;
	       case KeyEvent.VK_RIGHT:
	          right();

	          break;
	       case KeyEvent.VK_UP:
		          up();

		          break;
	       case KeyEvent.VK_DOWN:
	    	   	down();
		          break;
		   
	       }
	    }
	
}
