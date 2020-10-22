package chessGame;

import java.util.Scanner;


public class Game {
	
	private static void welcomeMessage() {
		
		System.out.println("Welcome!");
		System.out.println("This is a multiplayer chess game.");
		System.out.println("Remember: If the position of a chess piece is requested, use the following format: row,col");
		System.out.printf("Example: Row 3 and Column 5. Enter: 3,5\n\n");
		System.out.printf("You always can end the game by typing 'exit'\n\n");
		System.out.println("Please enter the names of the players:");
		
	}
	
	private static void endGame(String message) {
		if(message.equalsIgnoreCase("Exit")) {
			System.out.printf("\n\nThank you for playing! See you next time!\n");
			System.exit(0);
		}
	}
	
	private static boolean moveEnquiry(String player, String color, Board boardgame, Scanner userInput) {
		boolean win = false;
		boolean answer = false;
		while(!answer) {
			System.out.printf("%s's turn (white).\n", player);
			System.out.printf("Position of the piece you wish to move: ");
			int[] currPos = verifyPosInput(userInput.nextLine());
			if(currPos[0] == -1) {
				System.out.printf("Invalid position input!\n\n");
				continue;
			}
			
			System.out.printf("Position of the destination of your piece: ");
			int[] nextPos = verifyPosInput(userInput.nextLine());
			if(nextPos[0] == -1) {
				System.out.printf("Invalid position input!\n\n");
				continue;
			}
			
			System.out.println();
			if(!boardgame.movePiece(currPos[0], currPos[1], nextPos[0], nextPos[1])) {
				System.out.printf("This is an illegal move!\n\n");
				continue;
			}
			boardgame.printBoard();
			answer = true;
		}
		return win;
	}
	
	
	
	private static int[] verifyPosInput(String input) {
		endGame(input);
		int[] result = new int[2];
		String[] pos = input.split(",");
		if(pos.length != 2) {
			result[0] = -1;
		}else {
			int row = Integer.parseInt(pos[0]);
			int col = Integer.parseInt(pos[1]);
			if(row<0 || col<0 || row>7 || col>7) {
				result[0] = -1;
			}else {
				result[0] = row;
				result[1] = col;
			}
		}
		return result;
	}
	
	

	public static void main(String[] args) {		
		
		Scanner userInput = new Scanner(System.in);
		
		welcomeMessage();

		System.out.print("Player 1 (White): ");
		String player1 = userInput.nextLine();
		endGame(player1);
		
		System.out.printf("\nPlayer 2 (Black): ");
		String player2 = userInput.nextLine();
		endGame(player2);
		
		System.out.printf("\nWelcome %s and %s to this chess game.\n\n", player1, player2);
		System.out.printf("%s will start first.\n\n", player1);
		
		Board boardgame = new Board();
		boardgame.printBoard();
		boolean activeGame = true;
		
		while(activeGame) {
			activeGame = moveEnquiry(player1, "White", boardgame, userInput);
			if(activeGame) {
				System.out.println(player1 + " wins!!");
				break;
			}
			activeGame = moveEnquiry(player2, "Black", boardgame, userInput);
			if(activeGame) {
				System.out.println(player2 + " wins!!");
				break;
			}
		}
		
		userInput.close();

	}
	//https://stackoverflow.com/questions/18686199/fill-unicode-characters-in-labels
	//Improvement: Move a piece to destination by only specifying the destination.
}

