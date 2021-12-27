package util;


public class CardData {
    private String cardName;
    private String cardDescription;
    private String cardPriority;

    public CardData(String cardName, String cardDescription, String cardPriority) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardPriority = cardPriority;
    }


    public String getCardName() {
        return this.cardName;
    }

    public String getCardDescription() {
        return this.cardDescription;
    }

    public String getCardPriority() {
        return this.cardPriority;
    }
}

