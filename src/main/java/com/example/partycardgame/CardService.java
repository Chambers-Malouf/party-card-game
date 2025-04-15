package com.example.partycardgame;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class CardService {

    private final CardRepository cardRepository = new CardRepository();
    private final Random random = new Random();

    public String getRandomCard(String mode) {
        List<String> cards = cardRepository.getCardsForMode(mode.toLowerCase());
        if (cards == null || cards.isEmpty()) {
            return "No cards available for this mode.";
        }
        return cards.get(random.nextInt(cards.size()));
    }
    public List<String> getAllCardsForMode(String mode) {
        List<String> cards = cardRepository.getCardsForMode(mode.toLowerCase());
        return cards != null ? new ArrayList<>(cards) : new ArrayList<>();
    }

}
