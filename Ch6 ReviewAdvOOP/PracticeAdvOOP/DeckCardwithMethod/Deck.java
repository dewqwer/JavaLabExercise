package sit.model;

public class Deck {
    private Card[] cards;
    private int size;

    public Deck() {
        this.cards = new Card[52];
        this.size = 52;
        int count=0;
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                cards[count]= new Card(j,i);
                count++;
            }
        }
    }

    /**
     * Return the number of Cards currently in the Deck.
     */
    public int size() {
        return size;
    }

    /**
     * Remove one Card from the Deck and return it.
     */
    public Card deal() {
        size--;
        return cards[size];
    }

    /**
     * Return true if the Deck contains no Cards.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public Card[] getCards() {
        return cards;
    }

    @Override
    public String toString() {
        String cardInDecks = "";
        for (Card c : cards) {
            cardInDecks += c + "\n";
        }
        return cardInDecks;
    }

    /**
     * Randomly rearrange the Cards in the Deck.
     */
    public void shuffle() {
        int rand=(int)(Math.random()*(10)+1);
        int rand1=(int)(Math.random()*(52));
        int rand2=(int)(Math.random()*(52));
        Card[] newCards = new Card[52];
        for(int i=0;i<newCards.length-rand;i++){
            newCards[i]=this.cards[i+rand];
        }
        for(int j=newCards.length-rand+1;j<newCards.length;j++){
            newCards[j]=this.cards[j-2];
        }
        this.cards = newCards;
        swap(rand1,rand2);
    }

    /**
     * Swap the Cards at indices i and j.
     */
    public void swap(int i, int j) {
        Card temp1 = this.cards[i];
        Card temp2 = this.cards[j];
        this.cards[i] = temp2;
        this.cards[j] = temp1;
    }

    public Card getMaxCard() { 
    if(size>0){
        Card maxCard = this.cards[0];
        for(int i=0;i<size;i++){
        if(this.cards[i].getSuit()>=maxCard.getSuit()){
            maxCard = this.cards[i];
            if(this.cards[i].getRank()>maxCard.getSuit()){
                maxCard = this.cards[i];
            }
        }   
    }
        return maxCard;
    }else{
        return null;
    }
    }
}