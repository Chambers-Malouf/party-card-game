package com.example.partycardgame;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CardService {
    private final CardRepository cardRepository = new CardRepository();
    private final Random random = new Random();

    // ✅ Method: Return a random GameCard for a given mode
    public GameCard getRandomCard(String mode) {
        GameCard card = cardRepository.getRandomCard(mode.toLowerCase());
        if (card == null) {
            return new GameCard("No cards available for this mode.", "casual", "none","none");
        }
        return card;
    }

    // ✅ Method: Return all GameCards for a given mode
    public List<GameCard> getAllCardsForMode(String mode) {
        List<GameCard> cards = cardRepository.getCardsForMode(mode.toLowerCase());
        return cards != null ? new ArrayList<>(cards) : new ArrayList<>();
    }

    // ✅ Method: Return a random punishment string based on severity level
    public String getRandomPunishment(String severity) {
        List<String> pool = cardRepository.getPunishmentLevels()
                .getOrDefault(severity, List.of("Take a sip"));
        return pool.get(random.nextInt(pool.size()));
    }
}
