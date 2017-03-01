import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CreateWindow {

	private JFrame frame;
	private JPanel panel;
	
	private String[] fontSizes = {"20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40"};

	public CreateWindow() {
		//runs when the constructor is used
		frame = new JFrame("My Paint Demo");//Creates our frame
		
		Container mainContainer = frame.getContentPane();//Creates a container for our tools
		mainContainer.setLayout(new BorderLayout());//sets up boarder layout
		
		//DrawPad drawPad = new DrawPad();//creates our drawing board
		DrawAndType drawPad = new DrawAndType();
		
		mainContainer.add(drawPad, BorderLayout.CENTER); //puts our drawing board in the center
		
		
		panel = new JPanel();//creates panel, the one we will use for the tools
		panel.setPreferredSize(new Dimension(125, 200));
		  panel.setMinimumSize(new Dimension(125, 200));
		  panel.setMaximumSize(new Dimension(125, 200));
		
		
		  JLabel brushSliderLabel = new JLabel("     Brush Size");
		     JLabel fontSizeLabel = new JLabel("     Font Size");
		JLabel drawingMethodLabel = new JLabel("Drawing Method");
		      JLabel emptyLabel_1 = new JLabel(" ");
	 	      JLabel emptyLabel_2 = new JLabel(" ");//Empty labels to space out the buttons
		      JLabel emptyLabel_3 = new JLabel(" ");

		
		JSlider brushSlider = new JSlider();
		brushSlider.setPaintLabels(true);
		brushSlider.setMinimum(1);//creates our slider
		brushSlider.setMaximum(15);
		brushSlider.setValue(1);

		
		JComboBox fontSizeComboBox = new JComboBox(fontSizes);
		fontSizeComboBox.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {//
		    	  drawPad.setFontSize(Integer.parseInt(fontSizeComboBox.getSelectedItem().toString()));//Because all elements in a combo box are objects we must first get the selected item then use the toString before parsing it.
		      }
		    });
	
		
		
	    brushSlider.addChangeListener(new ChangeListener() {//Waits for the slider to be moved then turns sets the  brush size
	    	public void stateChanged(ChangeEvent e) {
	    		drawPad.setBrushSize(brushSlider.getValue());//adjusts the slider brush
	    	}
	    });
		
		
		JButton eraseButton = new JButton("Erase All");//creates our erase button
		//creates the clear button and sets the text as "Clear"
		eraseButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//drawPad.eraseAll();
				drawPad.eraseAll();
			}
			
		});
		
		
		JButton colorButton = new JButton("Select A Color");//creats our color button which creates a color chooser object
		//creates the clear button and sets the text as "Clear"
		colorButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				ColorChooser colorChooser = new ColorChooser(drawPad);//creats a color chooser window
				
				    }
				});
			
		
         JRadioButton freeHandRadioButton = new JRadioButton("Free Hand");
          JRadioButton circlesRadioButton = new JRadioButton("Circles   ");//creates our radio buttons
          JRadioButton squaresRadioButton = new JRadioButton("Squares  ");
 
        ButtonGroup shapesButtonGroup = new ButtonGroup( );//creates the button group
        
        shapesButtonGroup.add(freeHandRadioButton);
        shapesButtonGroup.add(circlesRadioButton);//adds them to the button group so only one can be selected at a time
        shapesButtonGroup.add(squaresRadioButton);
        
        freeHandRadioButton.setSelected(true);//starts this button as selected
        
        freeHandRadioButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(freeHandRadioButton.isSelected())
        			drawPad.setDrawFreeHand();
			
			    }
			});
        
        squaresRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            if(squaresRadioButton.isSelected())
    				drawPad.setDrawSquare();
    			
    			    }
    			});
        
        circlesRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if(circlesRadioButton.isSelected())
    				drawPad.setDrawCircle();
    
    			    }
    			});
	
		
		      eraseButton.setPreferredSize(new Dimension(110, 50));//Sets sizes for buttons, sliders and labels
		      colorButton.setPreferredSize(new Dimension(110, 50));
		     emptyLabel_1.setPreferredSize(new Dimension(110,25));
			 emptyLabel_2.setPreferredSize(new Dimension(110,25));
			 emptyLabel_3.setPreferredSize(new Dimension(110,25));
	     brushSliderLabel.setPreferredSize(new Dimension(110, 25));
		      brushSlider.setPreferredSize(new Dimension(100, 25));
	   drawingMethodLabel.setPreferredSize(new Dimension(110, 25));
		    fontSizeLabel.setPreferredSize(new Dimension(110,25));
	     fontSizeComboBox.setPreferredSize(new Dimension(119,25));
	    
		
		panel.add(eraseButton);
		panel.add(colorButton);//adds the buttons sliders and labels to the panel
		panel.add(emptyLabel_1);
		panel.add(brushSliderLabel);
		panel.add(brushSlider);
		panel.add(emptyLabel_2);
		panel.add(drawingMethodLabel);
		panel.add(freeHandRadioButton);
		panel.add(circlesRadioButton);
		panel.add(squaresRadioButton);
		panel.add(emptyLabel_3);
		panel.add(fontSizeLabel);
		panel.add(fontSizeComboBox);

		
		mainContainer.add(panel, BorderLayout.WEST);//adds the panel to the window, sets the panel to the left
		//sets the panel to the left
		
		frame.setSize(1200, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	public static void main(String[] args){
		CreateWindow window = new CreateWindow();
	}
}