import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Greg
 *
 */
public class Player {
	private ArrayList<String> hand = new ArrayList<String>(0);
	private static int counter = 0;
	private String name;
	public ArrayList<String> getHand() {
		return hand;
	}
	
	public Player(String name) {
		this.name = name;
		counter++;
	}
	
	public String toString() {
		return name;
	}
	
	public void setHand(ArrayList<String> hand) {
		this.hand = hand;
	}
	
	public void addToHand(String card) {
		hand.add(card);
	}
	
	public void removeFromHand(String card) {
		hand.remove(card);
	}
	
	public void dealCards(Deck deck) {
		while(hand.size() < (52/counter)) {
			hand.add(deck.pickOutCard());
		}
	}
	
	public String drawCard() {
		String tempCard = hand.get(0);
		hand.remove(0);
		return tempCard;
	}
	
	public int numberValue(String card) {
		if(card.contains("2")) {
			return 2;
		} else if (card.contains("3")) {
			return 3;
		} else if (card.contains("4")) {
			return 4;
		} else if (card.contains("5")) {
			return 5;
		} else if (card.contains("6")) {
			return 6;
		} else if (card.contains("7")) {
			return 7;
		} else if (card.contains("8")) {
			return 8;
		} else if (card.contains("9")) {
			return 9;
		} else if (card.contains("10")) {
			return 10;
		} else if (card.contains("Jack")) {
			return 11;
		} else if (card.contains("Queen")) {
			return 12;
		} else if (card.contains("King")) {
			return 13;
		} else {
			return 14;
		}
			
	}
	
	public int type(String card) {
		if(card.contains("Spades")) {
			return 3;
		} else if (card.contains("Clubs")) {
			return 0;
		} else if (card.contains("Diamonds")) {
			return 1;
		} else {
			return 2;
		}
	}
}
