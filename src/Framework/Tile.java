package Framework;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * @author Jonathan J�nsson, Carl Lindell
 * Basic tile object, meant to be extended.
 * 
 * 
 * 
 * **/
public abstract class Tile extends JPanel implements Cloneable, MouseListener{
	

	protected Image image;
	protected Dimension iconSize;
	protected Tile subtile;
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @return The image displayed by this tile
	 * **/
	public Image getImage(){
		return image;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param d Set the tile to size Dimension d 
	 * **/
	public void setSize(Dimension d) {
		iconSize = d;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param path a valid string path to a texture
	 * May not be overriden.
	 * **/
	public final void setTexture(String path){
		try 
		{
		    image = ImageIO.read(new File(path)); 
		    this.repaint();
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param g Set the tile texture to the image g
	 * **/
	public final void setTexture(Image g){
		    image = g; 
		    this.repaint();
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param d Set the tile to size Dimension d 
	 * @deprecated
	 * Duplicate method. Kept "just in case".
	 * **/
	public void seticonSize(Dimension d){
		iconSize = d;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param g The graphics context that allows this method to draw!
	 * The paint method is the same for all tile classes. If you want to add extra stuff and draw on the tile,
	 * get the graphics context and do it yourself somewhere. This framework is intended for tile-based games with preset textures.
	 * **/
	@Override
	public final void paint(Graphics g) {
		  super.paintComponent(g);
		  try {
		  this.setSize(iconSize);
		  }catch(NullPointerException e) {
			  System.out.println(" Null? "+iconSize);
			  e.printStackTrace();
		  }
		  if(image != null && iconSize != null){
		  		g.drawImage(image,0,0,(int)(iconSize.getWidth()),(int)(iconSize.getHeight()),this);
		  		g.setFont(new Font("TimesRoman", Font.PLAIN, 12)); 
		  }
		
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * We need this method for some odd technical java reason we could figure out if we had the will to.
	 * **/
	@Override
	public Dimension getPreferredSize(){
		return iconSize;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * Generic constructior 
	 * **/
	public Tile() {
		
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param d Set the tile to size Dimension d 
	 * Constructor
	 * **/
	public Tile(Dimension tileSize){
		iconSize = tileSize;
		this.setLayout(new BorderLayout());
		this.setOpaque(true);
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param d Set the tile to size Dimension d 
	 * @param image Set this image onto the tile
	 * Constructor
	 * **/
	public Tile(Dimension tileSize,Image image){
		iconSize = tileSize;
		this.setLayout(new BorderLayout());
		this.setOpaque(true);
		this.image = image;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * Factory pattern - create a new tile object.
	 * **/
	protected abstract Tile clone();
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @param t The tile that should be under this tile
	 * Sets the subtile of this tile to t
	 * **/
	public void setSubTile(Tile t){
		this.subtile = t;
	}
	/**
	 * @author Jonathan Jönsson, Carl Lindell
	 * @return the subtile this tile contains, probably null but maybe not.2§
	 * **/
	public Tile getSubTile(){
		return this.subtile;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


