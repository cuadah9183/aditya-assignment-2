package com.coderscampus;

import java.util.Scanner;
import java.util.Random;

public class Assignment2Application 
{
	// 1. Collect input from user from a number between 1-100
	// 2. Generate a random number to compare to the input between 1-100
	// 3. Allow up to 5 iterations (guesses) the user can make to either win or lose the game
	// 		- If value is not an INT, do not take a guess away from them
	// 		- If all 5 guesses are wrong, output message saying they lose and the random number generated
	// 4. For each valid guess, there are 3 outputs:
	// 		- if wrong: tell them to pick a lower/higher number depending on their input
	//		- if right: they win the game 

	public static void main(String[] args) 
	{
		
		Random randomNumberGen = new Random(); // gets random number
		int randomInteger = randomNumberGen.nextInt(100);
		
		Scanner scanner = new Scanner(System.in);
		
		boolean gameOver = false;
		
		int counter = 0;
		//System.out.println(randomInteger); // display the random number for testing purposes only
		
		while (!gameOver && counter < 5)
		{
			System.out.println("Pick a number between 1 and 100");
			String NumberGuessedByUser = scanner.nextLine();
			Integer convertedinput;
			try { // tests for letters in code
				convertedinput = Integer.parseInt(NumberGuessedByUser);
			}
			catch(NumberFormatException e)
			{
				continue;
			}
			
			if (convertedinput <= 0 || convertedinput > 100)
			{
				System.out.println("Your guess is not between 1 and 100, please try again");
			}
			else if (convertedinput > 0 && convertedinput < 101) 
			{
				if (convertedinput == randomInteger)
				{
					System.out.println("You win!");
					gameOver = true;
				}
				else if (convertedinput < randomInteger)
				{
					System.out.println("Please pick a higher number");
					counter++;
					if (counter >= 5)
					{
						System.out.println("You lose!");
						System.out.println("The number to guess was: " + randomInteger);
					}
					
				}
				else if (convertedinput > randomInteger) 
				{
					System.out.println("Please pick a lower number");
					counter++;
					if (counter >= 5)
					{
						System.out.println("You lose!");
						System.out.println("The number to guess was: " + randomInteger);
					}
				}
			}
			
		}
		scanner.close();
	}

}
