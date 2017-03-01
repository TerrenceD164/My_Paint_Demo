import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawAndType extends Drawing implements KeyListener{

	private FontMetrics fm;
	
	private Color color = Color.BLACK;
	
	Font font = new Font("Times New Roman",Font.PLAIN, 20);
	
	public DrawAndType(){
		super();
		addKeyListener(this);
		fm = getFontMetrics(font);
		
	}
	
	
	
	
	public void setKeyColor(Color color) {
		this.color = color;
	}
	
	
	
	public void setFontSize(int fontSize) {//creates a new font object disposes and references font to it.
		font = new Font("Times New Roman",Font.PLAIN, fontSize);
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		String s = String.valueOf(e.getKeyChar());
		Graphics g = getGraphics();
		g.setColor(color);
		g.setFont(font);

		g.drawString(s, getLastX(), getLastY());
		record(getLastX()+fm.stringWidth(s), getLastY());//avoids letters being on top of each other
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
