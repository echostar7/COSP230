// Fig. D.5: Craps.java
// Craps class simulates the dice game craps.
import java.util.Random;
import java.util.Scanner;

public class Craps {
	// create random number generator for use in method rollDice
	private static final Random randomNumbers = new Random();

	// enumeration with constants that represent the game status
	private enum Status {
		CONTINUE, WON, LOST
	};

	// constants that represent common rolls of the dice
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	// constant representing initial balance
	private static final double INITIAL_BALANCE = 1000.00;

	// plays one game of craps
	public static void main(String[] args) {
		// Create new scanner
		Scanner sc = new Scanner(System.in);
		double bank_balance = INITIAL_BALANCE; // Implement Bank Balance
												// variable and set it to an
												// initial balance of 1000.00
		double wager = -1;  // initialize wager variable
		while (bank_balance != 0) { // keep playing until you run out of money or sentinel of 0 is passed
			if (bank_balance == 0) { // if you're out of money you can no longer
										// play.
				System.out.println("Sorry, you busted!");
			}
			System.out.println("Place your wager. Enter 0  to stop playing."); // Ask the user for a wager,  0 triggers game exit.
														// prior to the first
														// die being played for
														// a new game.
			 wager = sc.nextDouble(); // set wager from user input

			// check if wager exceeds current bank balance
			if (wager > bank_balance) {
				System.out.println("wager is too big and must be limited the the amount of the bank balance, enter a smaller wager:");
				wager = sc.nextInt();
			}
			// check for negative wager input
			if (wager < 0) {
				System.out.println("wager must be greater than zero!");
				wager = sc.nextInt();
			}
			if (wager == 0){
				System.out.println("Thanks for playing!");
				System.out.printf("Your new bank balance is: %f\n",bank_balance);
				break;
			}

			int myPoint = 0; // point if no win or loss on first roll
			Status gameStatus; // can contain CONTINUE, WON or LOST

			int sumOfDice = rollDice(); // first roll of the dice

			// determine game status and point based on first roll
			switch (sumOfDice) {
			case SEVEN: // win with 7 on first roll
			case YO_LEVEN: // win with 11 on first roll
				gameStatus = Status.WON;
				chatter(); // display random chatter
				break;
			case SNAKE_EYES: // lose with 2 on first roll
			case TREY: // lose with 3 on first roll
			case BOX_CARS: // lose with 12 on first roll
				gameStatus = Status.LOST;
				chatter(); // display random chatter
				break;
			default: // did not win or lose, so remember point
				gameStatus = Status.CONTINUE; // game is not over
				myPoint = sumOfDice; // remember the point
				System.out.printf("Point is %d\n", myPoint);
				break; // optional at end of switch
			} // end switch

			// while game is not complete
			while (gameStatus == Status.CONTINUE) // not WON or LOST
			{
				sumOfDice = rollDice(); // roll dice again

				// determine game status
				if (sumOfDice == myPoint) // win by making point
					gameStatus = Status.WON;
				else if (sumOfDice == SEVEN) // lose by rolling 7 before point
					gameStatus = Status.LOST;
			} // end while

			// display won or lost message
			// add the amount of wager to the bank balance and display his
			// new bank balance.
			if (gameStatus == Status.WON) {
				System.out.println("Player wins");
				bank_balance = (bank_balance + wager);
				System.out.printf("Your new bank balance is: %f\n",bank_balance);
				chatter(); // display random chatter

			}

			else {
				System.out.println("Player loses");
				bank_balance = (bank_balance - wager);
				System.out.printf("Your new bank balance is: %f\n",bank_balance);
				chatter(); // display random chatter

			}
		}

	} // end main

	// “chatter” method gives random responses to the player on completion of
	// each round such as "Oh, you're going for broke, huh?" or
	// "Aw c'mon, take a chance!" or
	// "You're up big. Now's the time to cash in your chips!".
	public static void chatter() {

		int response = randomNumbers.nextInt(3);
		switch (response) {
		case 1:
			System.out.println("Oh, you're going for broke, huh?");
			break;
		case 2:
			System.out.println("Aw c'mon, take a chance!");
			break;
		case 3:
			System.out.println("You're up big. Now's the time to cash in your chips!");
			break;
		}

	}

	// roll dice, calculate sum and display results
	public static int rollDice() {
		// pick random die values
		int die1 = 1 + randomNumbers.nextInt(6); // first die roll
		int die2 = 1 + randomNumbers.nextInt(6); // second die roll

		int sum = die1 + die2; // sum of die values

		// display results of this roll
		System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);

		return sum; // return sum of dice
	} // end method rollDice
} // end class Craps

/*************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
