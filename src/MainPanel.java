import java.awt.BorderLayout;

import javax.swing.JPanel;

//Represents the entire game, and is the "content panel" for the JFrame
//Is a JPanel
public class MainPanel extends JPanel {

	public MainPanel(Model model, int gridSize) {

		setLayout(new BorderLayout());
		add(new CenterPanel(model, gridSize), BorderLayout.CENTER);
		add(new BottomPanel(model), BorderLayout.SOUTH);

	
	}
}
