import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

	private ArrayList<String> Deck;
	
	public Deck() {
		Deck = createDeck();
	}
	
	public ArrayList<String> createDeck() {
		ArrayList<String> suit = new ArrayList<String>();
		suit.add("Clubs");
		suit.add("Spades");
		suit.add("Hearts");
		suit.add("Diamonds");
		ArrayList<String> value = new ArrayList<String>();
		value.add("2");
		value.add("3");
		value.add("4");
		value.add("5");
		value.add("6");
		value.add("7");
		value.add("8");
		value.add("9");
		value.add("10");
		value.add("Jack");
		value.add("Queen");
		value.add("King");
		value.add("Ace");
		ArrayList<String> tempDeck = new ArrayList<String>();
		for(String suits : suit) {
			for(String values : value) {
				tempDeck.add(values + " of " + suits);
			}
		}
		shuffleDeck(tempDeck);
		return tempDeck;
	}
	
	public ArrayList<String> restoreDeck(ArrayList<String> deck) {
		deck.clear();
		deck = createDeck();
		return deck;
	}
	
	public void addToDeck(String toBeAdded) {
		Deck.add(toBeAdded);
	}
	
	public void shuffleDeck(ArrayList<String> deck) {
		Collections.shuffle(deck);
	}
	
	public ArrayList<String> getDeck() {
		return Deck;
	}
	
	public String toString() {
		String wholeDeck = "";
		for(int i = 0; i < Deck.size();i++) {
			wholeDeck += Deck.get(i) + " ";
		}
		return wholeDeck;
	}
	
	public boolean isEmpty() {
		if(Deck.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public String pickOutCard() {
		String tempCard = Deck.get(0);
		Deck.remove(0);
		return tempCard;
	}
}
