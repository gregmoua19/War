import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Game {

	public static int playerScore = 0;
	public static int computerScore = 0;
	
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		playGame(user);
	}

	public static void playGame(Scanner user) {
		Stack<String> holder = new Stack<String>();
		boolean playing = true;
		String userChoice = "";
		// create the deck and players
		Deck deck = new Deck();
		Player player1 = new Player("Greg");
		Player player2 = new Player("Computer");

		// split the decks between both players and split them
		player1.dealCards(deck);
		player2.dealCards(deck);

		while (!(player1.getHand().isEmpty() || player2.getHand().isEmpty())) {
			Collections.shuffle(player1.getHand());
			Collections.shuffle(player2.getHand());
			
			//win & and lose conditions
			String oneCard = player1.drawCard();
			String twoCard = player2.drawCard();
			System.out.println(player1.toString() + " has drawn " + oneCard);
			System.out.println(player2.toString() + " has drawn " + twoCard);
			holder.add(oneCard);
			holder.add(twoCard);
			int oneValue = player1.numberValue(oneCard);
			int twoValue = player2.numberValue(twoCard);
			int oneType = player1.type(oneCard);
			int twoType = player2.type(twoCard);
			winConditions(oneValue,twoValue,oneType,twoType,holder,player1,player2);

			if (player1.getHand().isEmpty() || player2.getHand().isEmpty()) {
				

			}	
		}
		if (player1.getHand().isEmpty()) {
			System.out.print(player2.toString() + " wins!");
			computerScore++;
		} else {
			System.out.print(player1.toString() + " wins!");
			playerScore++;
		}
		System.out.println(" Play again?");
		userChoice = user.nextLine();
		while(!(userChoice.equalsIgnoreCase("no") || userChoice.equalsIgnoreCase("n") || userChoice.equalsIgnoreCase("yes") || userChoice.equalsIgnoreCase("y"))) {
			System.out.println("Please enter either \"yes\\y\" or \"no\\n\"");
			userChoice = user.nextLine();
		}
		if(userChoice.contains("n")) {
			return;
		} else {
			playGame(user);
		}
	}

	public static void tie(Stack<String> holder, Player p, Player p2) {
		for(int i = 0; i < 4;i++) {
			holder.add(p.drawCard());
			holder.add(p2.drawCard());
		}
		String temp1 = holder.pop();
		String temp2 = holder.pop();
		int oneValue = p.numberValue(temp1);
		int twoValue = p2.numberValue(temp2);
		int oneType = p.type(temp1);
		int twoType = p2.type(temp2);
		winConditions(oneValue,twoValue,oneType,twoType,holder,p,p2);
	}

	public static void winRound(Stack<String> holder, Player p) {
		System.out.println(p.toString() + " wins this round!");
		System.out.println("--------------------------------");
		while (!holder.isEmpty()) {
			p.addToHand(holder.pop());
		}
	}
	
	public static void winConditions(int oneValue, int twoValue, int oneType, int twoType, Stack<String> holder, Player p, Player p2) {
		if (oneValue == twoValue) {
			if (oneType == twoType) {
				tie(holder, p, p2);
			} else if (oneType > twoType) {
				winRound(holder, p);
			} else {
				winRound(holder, p2);
			}
		} else if (oneValue > twoValue) {
			winRound(holder, p);
		} else {
			winRound(holder, p2);
		}
	}
}
