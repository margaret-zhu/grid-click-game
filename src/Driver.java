import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;


/* Students:  This class is written for you -- do not modify it! */

public class Driver {
	
	public static void main(String[] args) {
		int gridSize = Integer.valueOf(
				JOptionPane.showInputDialog("What size grid?", "8"));
		int delay = Integer.valueOf(
				JOptionPane.showInputDialog("Delay (milliseconds)", "1300"));
		Model model = new Model(gridSize, delay);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(model, gridSize);
			}
		});
	}
	
	public static void createAndShowGUI(Model model, int gridSize) {
		fixForMacMisbehaving();
		JFrame frame = new JFrame("GridClick Game");
		frame.setContentPane(new MainPanel(model, gridSize));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int upperLeftCornerX = (screenSize.width - frame.getWidth()) / 2;
	    int upperLeftCornerY = (screenSize.height - frame.getHeight()) / 2;
	    frame.setLocation(upperLeftCornerX, upperLeftCornerY);
		frame.setVisible(true);
	}
	
	
	private static void fixForMacMisbehaving() {
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {

		}
	}
	

}
