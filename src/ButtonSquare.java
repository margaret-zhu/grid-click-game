import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

//Represents the colorful squares in the GUI, is a JButton
public class ButtonSquare extends JButton {
	
	//instance initialization block that shows the color of the button
	{
		setOpaque(true);
	}
	
	
	//constructor
	public ButtonSquare() {
		
		
		//sets Background of current object to black
		this.setBackground(Color.BLACK);
		
		
		//adds an action listener
		//changes Background to yellow if green, and to red otherwise
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(getBackground() == Color.YELLOW) {
					setBackground(Color.GREEN);
					
				}else {
					setBackground(Color.RED);
				}
				
			}
			
		});
	
	}
	
	
	
}
