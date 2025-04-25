

package com.example.partycardgame;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CardService {
    private final CardRepository cardRepository = new CardRepository();
    private final Random random = new Random();

    // Return a random GameCard for a given mode
    public GameCard getRandomCard(String mode) {
        List<GameCard> deck = cardRepository.getRandomCard(mode.toLowerCase());
        if (deck == null || deck.isEmpty()) {
            return new GameCard("No cards available for this mode.", "casual", "none"); // fallback
        }
        return deck.get(random.nextInt(deck.size()));
    }

    // Return all GameCards for a given mode
    public List<GameCard> getAllCardsForMode(String mode) {
        List<GameCard> cards = cardRepository.getCardsForMode(mode.toLowerCase());
        return cards != null ? new ArrayList<>(cards) : new ArrayList<>();
    }

    // Return a random punishment string based on severity level
    public String getRandomPunishment(String severity) {
        List<String> pool = cardRepository.getPunishmentLevels()
                .getOrDefault(severity, List.of("Take a sip"));
        return pool.get(random.nextInt(pool.size()));
    }
}
