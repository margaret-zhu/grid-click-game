import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


//Represents panel at the south region of main panel
//Contains the player's score
public class BottomPanel extends JPanel {
	
	//label containing player's score
	private JLabel score = new JLabel("Score: 0"); 
	//font variable for label text
	private static Font font = new Font("Arial", Font.BOLD, 30); 
	
	//constructor 
	public BottomPanel(Model model) {
		
		//sets font for text on label
		score.setFont(font);
		
		//adds label to panel
		this.add(score);

		//creates a timer that periodically updates the score
		Timer timer = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//gets current score from parameter 'model'
				int gameScore = model.getScore(); 

				//updates label with new score
				score.setText("Score: " + gameScore);

			}

		});
		
		timer.start();

	}
}
