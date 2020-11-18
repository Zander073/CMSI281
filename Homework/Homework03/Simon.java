/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  Simon.java
* Purpose    :	A friendly game of Simon between a user and a computer.
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-011-16
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Simon {

	ArrayList<Character> simonString;
	int currentIndex = 0;
	private Scanner objectOne;
	private Scanner objectTwo;
	private static Scanner objectThree;

	public void game() {
		boolean gameContinues = true;
		boolean alreadyPlayed = false;
		objectTwo = new Scanner(System.in);

		while(gameContinues) {
			play(alreadyPlayed);
			alreadyPlayed = true;
			System.out.println("Would you like to play again? Enter '1' for yes and '2' for no.");
			int nextPlay = objectTwo.nextInt();
			if(nextPlay == 2) {
				gameContinues = false;
			} else {
				currentIndex = 0;
			}
		}

		System.out.println("Thanks for playing Simon!");
	}

	public void play(boolean played) {
		simonString = new ArrayList<Character>();
		boolean userFail = false;
		int score = 0;
		int round = 1;

		if(!played) {
			intro();
		}

		while(!userFail) {
			long startTime = System.currentTimeMillis();
			long elapsedTime = 0L;

			if(round == 1) {
				System.out.println("Pay attention... The game is beginning...");
				while (elapsedTime < 5*1000) {
				    elapsedTime = (new Date()).getTime() - startTime;
				}
				elapsedTime = 0L;
			}
			System.out.println("Score: " + score + "            Round: " + round);
			simonString.add(currentIndex, getNextChar());
			currentIndex++;

			System.out.println("The sequence is: ");
			for(int i = 0; i < simonString.size(); i++) {
				System.out.print(simonString.get(i) + " ");
			}
			System.out.println();
			System.out.println("WAIT!");

			while (elapsedTime < (simonString.size()*1000)) {
			    elapsedTime = (new Date()).getTime() - startTime;
			}
			hideSequence();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Score: " + score + "            Round: " + round);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("NOW ENTER");
			String userInput = getUserInput();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			if(checkUserInput(userInput)) {
				score++;
				round++;
			} else {
				userFail = true;
			}
		}
		System.out.println("Your input was incorrect.");
	}

	public char getNextChar() {
		int numGenerated = 1 + (int)(Math.random() * ((4 - 1) + 1));
		if(numGenerated == 1) {
			return 'R';
		} else if(numGenerated == 2) {
			return 'G';
		} else if(numGenerated == 3) {
			return 'B';
		} else {
			return 'Y';
		}
	}

	public boolean checkUserInput(String input) {
		StringBuilder builder = new StringBuilder(simonString.size());
	    for(Character ch: simonString){
	        builder.append(ch);
	    }
	    String currentGameString = builder.toString();
	    if(input.toLowerCase().equals(currentGameString.toLowerCase())) {
	    	return true;
	    }
	    return false;
	}

	public static void intro() {
		System.out.println("Welcome to Simon.");
		System.out.println("Simon is a memorization game. A character will appear and you will be asked to repeat the presented sequence.");
		System.out.println("For example, if 'RGRB' appears and disappears. Then you will input 'RGRB' to keep playing.");
		System.out.println("Then, the next sequence could be something like 'RGRBY' then you would have to input 'RGRBY' to keep playing.");
		System.out.println("Are you ready to play? Enter '1' to begin:");
		objectThree = new Scanner(System.in);
		int userInput = objectThree.nextInt();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public String getUserInput() {
		objectOne = new Scanner(System.in);
		System.out.println("Enter what you think the sequence is:");
		String userInput = objectOne.nextLine();
		return userInput;
	}

	public static void hideSequence() {
		for(int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Simon x = new Simon();
		x.game();

	}
}
