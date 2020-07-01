import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;


//Represents the panel containing the colorful grid
public class CenterPanel extends JPanel {
	
	
	//constructor
	public CenterPanel(Model model, int size) {

		//sets the layout to a grid
		setLayout(new GridLayout(size, size));
	
		/*gets list of ButtonSquares from model parameter, and 
		 * adds them to this panel
		 */
		for(int i = 0; i<model.getSquares().size(); i++) {
			this.add(model.getSquares().get(i));
		}
	
	}
	
}
