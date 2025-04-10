package com.example.partycardgame;

import java.util.*;

public class CardRepository {
    private final Map<String, List<String>> cardData = new HashMap<>();

    public CardRepository() {
        cardData.put("party", List.of(
                "Take a body shot off someone of your choice.",
                "Let someone pour a mystery drink — you drink it."
        ));
        cardData.put("chill", List.of(
                "Let another player go through your phone for 2 minutes (without sending anything)",
                "Confess a secret of another players choice or take 3 sips.",
                "Pick a player — if they guess your birthday month wrong, they take two drinks."

        ));
        cardData.put("drinking", List.of(
                "Still in love with your ex? Finish your drink."
        ));
        cardData.put("idk what to name this", List.of(
                "Reveal to the group your last hookup, if they don't like it take three drinks",
                "Let someone read your last text to a sneaky link out loud.",
                "Describe your last spicy dream or finish your drink.",
                "Text your ex 'I miss you' or take a double shot.",
                "Swap seats with the person you’re most attracted to."
        ));
    }

    public List<String> getCardsForMode(String mode) {
        return cardData.get(mode);
    }
}
