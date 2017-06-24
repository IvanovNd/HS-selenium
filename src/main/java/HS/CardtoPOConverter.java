package HS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 16.08.2016.
 */
public class CardtoPOConverter {

    public static CardPO convertToPO(Card card){
       CardPO cardPO = new CardPO();
        cardPO.setAttack(card.getAttack());
        cardPO.setName(card.getName());
        cardPO.setRedkost(card.getRedkost());
        cardPO.setType(card.getType());
        cardPO.setCost(card.getCost());
        cardPO.setDescription(card.getDescription());
        cardPO.setGameClass(card.getGameClass());
        cardPO.setHealth(card.getHealth());
        cardPO.setNation(card.getNation());
        cardPO.setPack(card.getPack());
        cardPO.setPopular(card.getPopular());
        return cardPO;
    }

    public static List<CardPO> convertListToPO(List<Card> cards) {
        ArrayList<CardPO> cardPOs = new ArrayList<>();
        for (Card card : cards) {
            cardPOs.add(convertToPO(card));
        }
        return cardPOs;
    }
}
