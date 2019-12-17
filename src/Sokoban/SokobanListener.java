package Sokoban;

import java.awt.event.KeyEvent;

import Framework.AbstractKeyListener;
import Framework.ConcreteListener;
import Framework.PlayingField;
/**
 * @author Jonathan J�nsson, Carl Lindell
 * KeyListener specific for sokoban - movement of player and resetting level
 * 
 * 
 * 
 * 
 * **/
public class SokobanListener extends AbstractKeyListener {
	SokobanField field;
	Sokoban sokoban;
	public SokobanListener(PlayingField f) {
		field = (SokobanField) f;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void addGameReference(Sokoban b){
		sokoban = b;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void up() {
		field.moveup();
		field.repaint();
	}

	@Override
	public void down() {
		field.movedown();
		field.repaint();
	}

	@Override
	public void left() {
		field.moveleft();
		field.repaint();
	}

	@Override
	public void right() {
		field.moveright();
		field.repaint();
	}
	//@Override
	public void r(){
		sokoban.removeAll();
		sokoban.setVisible(false);
		sokoban.dispose();
		sokoban = new Sokoban();
	}
	@Override
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
	       case KeyEvent.VK_R:
	    	   r();
	    	   break;
	       }
	    }

}
