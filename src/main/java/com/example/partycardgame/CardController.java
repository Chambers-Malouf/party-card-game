package com.example.partycardgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/draw-card")
    public CardResponse drawCard(@RequestBody CardRequest request) {
        GameCard card = cardService.getRandomCard(request.getMode());
        return new CardResponse(card.getText());
    }

    @PostMapping("/get-cards")
    public CardResponse getCards(@RequestBody CardRequest request) {
        List<GameCard> cards = cardService.getAllCardsForMode(request.getMode());
        if (cards.isEmpty()) {
            return new CardResponse("No cards available for this mode.");
        }

        // Shuffle once and return as a JSON string
        Collections.shuffle(cards);
        String cardListJson = String.join("||", cards.stream().map(GameCard::getText).toList());
        return new CardResponse(cardListJson);
    }
}

