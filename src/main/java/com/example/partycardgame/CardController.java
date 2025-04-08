package com.example.partycardgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/draw-card")
    public CardResponse drawCard(@RequestBody CardRequest request) {
        String card = cardService.getRandomCard(request.getMode());
        return new CardResponse(card);
    }
}
