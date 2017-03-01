import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooser{

	Color color;
	DrawAndType drawPad;
	
	public ColorChooser(DrawAndType drawPad){
		this.drawPad = drawPad;
		
		JFrame frame = new JFrame("JColorChooser Popup");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    final JLabel label = new JLabel("Color Chooser", JLabel.CENTER);
	    label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));

	    //frame.add(label, BorderLayout.SOUTH);

	    final JColorChooser colorChooser = new JColorChooser(label.getBackground());

	    ColorSelectionModel model = colorChooser.getSelectionModel();
	    ChangeListener changeListener = new ChangeListener() {
	      public void stateChanged(ChangeEvent changeEvent) {
	        Color newForegroundColor = colorChooser.getColor();
	        label.setForeground(newForegroundColor);
	        drawPad.setBrushColor(newForegroundColor);
	        drawPad.setKeyColor(newForegroundColor);
	      }
	    };
	    
	    
	    
	    
		
		JButton okButton = new JButton("Ok");
		//creates the clear button and sets the text as "Clear"
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				frame.dispose();
				
				    }
				});
 
	    
	    model.addChangeListener(changeListener);

	    frame.add(colorChooser, BorderLayout.CENTER);
	    frame.add(okButton, BorderLayout.SOUTH);
	    
	    frame.pack();
	    frame.setVisible(true);
	}
	
	
  //public static void main(String args[]) {
  //  ColorChooser colorChooser = new ColorChooser();
//  }
}
