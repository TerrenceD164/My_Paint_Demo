
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener{

	private int circleSize = 40;
	private int lastX=0, lastY=0;
	private int times=0;
	
	private static boolean drawFreeHand = true;
	private static boolean drawCircle = false;
	private static boolean drawSquare = false;
	

	private int brushSize = 1;
	private Color color = Color.BLACK;
	
	public Drawing(){
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(drawFreeHand){//only draws if free hand is seleced
			int x = e.getX();
			int y = e.getY();
			Graphics g = getGraphics();
			Graphics g2d = (Graphics2D)g;
			((Graphics2D) g2d).setStroke(new BasicStroke(brushSize));//use a variable that will have the line width
			g2d.setColor(color);  //use a variable that will have the drawing color
			g2d.drawLine(lastX, lastY, x, y);
			record(x,y);
		}
		
	}
	
	public void eraseAll(){//paints white over the Drawing pannel
		Graphics g = getGraphics();
		Graphics g2d = (Graphics2D)g;
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, getSize().width, getSize().height);
		g2d.setColor(color);
		repaint();
	
	}

	
	public void setBrushColor(Color color) {
		this.color = color;
	}
	
	
	public void setBrushSize(int brushSize) {
		this.brushSize = brushSize;
	}
	
	
	
	public static void setDrawFreeHand() {
		drawFreeHand = true;
		  drawCircle = false;
		  drawSquare = false;
	}
	
	
	public static void setDrawCircle() {//to ensure only one is true at a time
		drawFreeHand = false;///
		  drawCircle = true;
		  drawSquare = false;
	}
	
	
	public static void setDrawSquare() {
		drawFreeHand = false;
		  drawCircle = false;
		  drawSquare = true;
	}


	
	
	
	protected void record(int x, int y){
		lastX = x;
		lastY = y;
	}
	
	
	
	
	
	public int getLastX(){
		return lastX;
	}
	
	public int getLastY(){
		return lastY;
	}
	
	
	public void drawSquare(MouseEvent e){
		record(e.getX(), e.getY());
		
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);
		
		g2d.fillRect(lastX-25, lastY-25, 50, 50);//- 25 so that we always draw it around the mouse
		
	}
	
	public void drawCircle(MouseEvent e){
		times++;
		record(e.getX(), e.getY()); //store the lastX and lastY values

		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);

		g2d.fillOval(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);

	}
	
	
	
	@Override
	public void mouseMoved(MouseEvent e) {
		record(e.getX(), e.getY());//need for the typing 
		
	}
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(!drawFreeHand){
			
			if(drawCircle)
				drawCircle(e);
			
			else if(drawSquare)
				drawSquare(e);			
		}
	}
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		requestFocus();//need for typing
		record(e.getX(), e.getY());//need for typing
		
	}

	
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	

}

