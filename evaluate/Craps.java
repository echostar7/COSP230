// Fig. D.5: Craps.java
// Craps class simulates the dice game craps.
import java.util.Random;
import java.util.Scanner;

public class Craps
{
   // create random number generator for use in method rollDice
   private static final Random randomNumbers = new Random(); 

   // enumeration with constants that represent the game status
   private enum Status { CONTINUE, WON, LOST };                

   // constants that represent common rolls of the dice
   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;      
   private static final int SEVEN = 7;     
   private static final int YO_LEVEN = 11; 
   private static final int BOX_CARS = 12; 

   // plays one game of craps
   public static void main( String[] args )
   {
		int wager = 0;
		double bankBalance = 1000.00;
      int myPoint = 0; // point if no win or loss on first roll
      Status gameStatus; // can contain CONTINUE, WON or LOST
		
		System.out.println("You have a starting balance of $1000.00");
		
		do{
			wager = askWager(bankBalance);
			int sumOfDice = rollDice(); // first roll of the dice			
      
		// determine game status and point based on first roll 
      switch ( sumOfDice ){
         case SEVEN: // win with 7 on first roll    
         case YO_LEVEN: // win with 11 on first roll
            gameStatus = Status.WON;
            break;
         case SNAKE_EYES: // lose with 2 on first roll
         case TREY: // lose with 3 on first roll      
         case BOX_CARS: // lose with 12 on first roll 
            gameStatus = Status.LOST;
            break;
         default: // did not win or lose, so remember point
            gameStatus = Status.CONTINUE; // game is not over
            myPoint = sumOfDice; // remember the point       
            System.out.printf( "Point is %d\n", myPoint );
            break; // optional at end of switch
      } // end switch 

      while ( gameStatus == Status.CONTINUE ) // not WON or LOST
      { 
         sumOfDice = rollDice(); // roll dice again			
         // determine game status
         if ( sumOfDice == myPoint ){ // win by making point
				gameStatus = Status.WON;}
         else
            if ( sumOfDice == SEVEN ){ // lose by rolling 7 before point
					gameStatus = Status.LOST;}
      } // end while 

      // display won or lost message
      if ( gameStatus == Status.WON ){
			bankBalance += wager;
			System.out.printf("\nCurrent Balance: %.2f\n",bankBalance);
         System.out.println( "Player wins" ); 
			checkBalance(bankBalance); //make sure Bank isn't under 0 otherwise you continue
			continueP(); //Ask if you want to continue if not you exit.
		}
			else{
				bankBalance -= wager;
				System.out.println( "Player loses" );
				System.out.printf("\nCurrent Balance: %.2f\n",bankBalance);
				checkBalance(bankBalance); //make sure Bank isn't under 0 
				continueP(); //Ask if you want to continue if not you exit.
			}

	
		}while(bankBalance > 0); //as long as balance isn't below 0 the loop sustains.
   } // end main

   // roll dice, calculate sum and display results
   public static int rollDice()
   {
      // pick random die values
      int die1 = 1 + randomNumbers.nextInt( 6 ); // first die roll
      int die2 = 1 + randomNumbers.nextInt( 6 ); // second die roll

      int sum = die1 + die2; // sum of die values

      // display results of this roll
      System.out.printf( "Player rolled %d + %d = %d\n", 
         die1, die2, sum );

		chatter();
		return sum; // return sum of dice
   } // end method rollDice
	
	public static int askWager(double bankB){ 
		int wager;
		boolean check = true;
		
		do{
			System.out.print("\nWhat is your wager? $");
			Scanner in = new Scanner(System.in);
			wager = in.nextInt();
		
			if(wager > bankB){
				System.out.print("Your wager has exceeded bank account.\nPlease place another bet.");				
				check = false;
				}
					else{
						System.out.printf("\nYou placed a wager of $%d\n",wager);
							check =true;
					}
			}while(check!=true);
				return wager;
		}//ends method askWager
		
	public static double checkBalance(double currentBalance){
		if (currentBalance <= 0){
			System.out.println("You busted sorry.");
			System.exit(0);
				}
				return currentBalance;
			}//ends method checkBalance
		
	public static void continueP(){
		System.out.print("Would you like to continue(Y) or check in cash(N)? ");
		boolean check = true;
		
		do{
			Scanner in = new Scanner(System.in);
			String answer = in.nextLine().toUpperCase();
			char firstL = answer.charAt(0);

				if(firstL =='N'){
						System.out.println("Thanks for playing.");
							System.exit(0);
								}
									else if(firstL == 'Y'){
											check = true;
												}
										else{
											System.out.print("Please enter valid answer Y/N ");
											check = false;
										}
			}while(check!=true);	
		}//ends method continueP

	public static void chatter(){
		Random rand = new Random();
		float number = rand.nextFloat();

		if(number > 0.5){
		int rnum = randomNumbers.nextInt( 3 );

			switch(rnum){
				case 0: System.out.println("Oh, you're going for broke, huh?"); 
					break;
				case 1: System.out.println("Aw c'mon, take a chance!");
					break;
				case 2: System.out.println("You're up big. Now's the time to cash in your chips!");
					break;
				}
			}
		}//ends method chatter 
	} // end class Craps
