import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

//contains data and logic for the game 
public class Model {
	
	//primary data structure, represents the individual squares on the grid
	private ArrayList<ButtonSquare> buttons; 
	private static Random random = new Random();//random variable
	//represents whether the method has already been called once 
	private boolean firstMethodCall = false;
	//represents whether a black square was found (randomly)
	private boolean blackSquareLocated = false;
	//represents the player's score
	private int score;
	
	//constructor
	public Model(int size, int delay) {

		/* initialization of array list buttons, boolean methodCalls, 
		 * and boolean blackSquareLocated
		 */
		buttons = new ArrayList<ButtonSquare>(size * size);
		
		for (int i = 0; i < (size * size); i++) {
			buttons.add(new ButtonSquare());
		}
		

		// creates timer
		Timer timer = new Timer(delay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//checks if this is first time method is called
				if (!firstMethodCall) {
						
					blackSquareLocated = false;
					/*keeps generating random indices until one with 
					 * black background is found; then, the 
					 * background of that square is set to yellow
					 */
					while (!blackSquareLocated) {
						
						int index = random.nextInt((size*size));
						
						if (buttons.get(index).getBackground() 
								== Color.BLACK) {
							blackSquareLocated = true;
							buttons.get(index).setBackground
							(Color.YELLOW);
						}
					}

				} else {

					/*loops through checking for yellow squares, and 
					 * if found, changes them to white
					 */
					for (int i = 0; i < buttons.size(); i++) {
						if (buttons.get(i).getBackground() 
								== Color.YELLOW) {
							buttons.get(i).setBackground(Color.WHITE);
						}
					}
					
					/*as long as game isn't over, locates a random black 
					 * square and changes it to yellow
					 */
					if (!gameOver()) {

						blackSquareLocated = false;
						
						while (!blackSquareLocated) {
							
							int index = random.nextInt((size * size));
							
							if (buttons.get(index).getBackground() == 
									Color.BLACK) {
								blackSquareLocated = true;
								buttons.get(index).setBackground
								(Color.YELLOW);
							}
						}

					}

				}

				//represents that method has been called at least once
				firstMethodCall = true;
			}

		});

		timer.start();
	}

	/* returns array list of the grid squares */
	public ArrayList<ButtonSquare> getSquares() {
		return buttons;
	}

	/*returns true if there are no more black squares, indicating that 
	 * the game is over
	 */
	public boolean gameOver() {

		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).getBackground() == Color.BLACK) {
				return false;
			}
		}

		return true;
	}

	/*computes score based on colors of squares and returns player's 
	 * final score
	 */
	public int getScore() {

		score = 0;
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).getBackground() == Color.GREEN) {
				score += 5;
			}
			if (buttons.get(i).getBackground() == Color.WHITE) {
				score -= 1;
			}
			if (buttons.get(i).getBackground() == Color.RED) {
				score -= 10;
			}
		}
		return score;
	}

}

