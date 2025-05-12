package com.example.partycardgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<List<GameCard>> getCards(@RequestBody CardRequest request) {
        List<GameCard> cards = cardService.getAllCardsForMode(request.getMode());
        if (cards.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        Collections.shuffle(cards);
        return ResponseEntity.ok(cards);
    }
}
