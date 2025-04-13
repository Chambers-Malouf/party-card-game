package com.example.partycardgame;

import java.util.*;

public class CardRepository {
    private final Map<String, List<String>> cardData = new HashMap<>();

    public CardRepository() {
        cardData.put("party", List.of(
                "Take a body shot off someone of your choice.",
                "Do 5 push-ups or finish your drink.",
                "Invent a new drinking rule — everyone follows it.",
                "Let someone pour a mystery drink — you drink it."
        ));
        cardData.put("chill", List.of(
                "Let another player go through your phone for 2 minutes (without sending anything)",
                "Confess a secret of another players choice or take 3 sips.",
                "Name a song that makes you emotional every time.",
                "What’s a random compliment you’ve never forgotten?",
                "Name one thing you admire about the person to your right.",
                "Say something nice about the person to your left.",
                "Which cartoon character did you have a crush on? Be honest.",
                "Choose your zombie apocalypse team from this group.(three people maximum)",
                "Pick a player — if they guess your birthday month wrong, they take two drinks."

        ));
        cardData.put("drinking", List.of(
                "Still in love with your ex? Finish your drink.",
                "Take a sip if you've ever ghosted someone.",
                "You laugh, you sip — starting now.",
                "Drink if you've ever sent a risky text and regretted it.",
                "Let someone else choose how much you drink.",
                "Touch a ceiling or finish your drink.",
                "Drink if your battery is under 20%.",
                "Take a sip for every piercing/tattoo you have(or want).",
                "Drink if you’ve said 'I’m never drinking again' this year."


                ));
        cardData.put("nsfw", List.of(
                "Reveal to the group your last hookup, if they don't like it take three drinks",
                "Name your last hookup. FIRST AND LAST NAME",
                "Let someone read your last text to a sneaky link out loud.",
                "Name someone you’d hook up with from this room (or drink).",
                "Share your body count or drink twice.",
                "Name someone here you'd kiss — or everyone drinks.",
                "Explain your most awkward kiss in slow motion.",
                "Describe your most embarrassing hookup in 5 words.",
                "Name something that turns you on — or off.",
                "Whisper your most taboo fantasy to someone privately.",
                "Describe your last spicy dream or finish your drink.",
                "Text your ex 'I miss you' or take a double shot.",
                "Swap seats with the person you’re most attracted to."
        ));
        //combine all categories into an all mode
        List<String> allCards = new ArrayList<>();
        allCards.addAll(cardData.get("party"));
        allCards.addAll(cardData.get("chill"));
        allCards.addAll(cardData.get("drinking"));
        allCards.addAll(cardData.get("nsfw"));
        cardData.put("all", allCards);    }

    public List<String> getCardsForMode(String mode) {
        return cardData.get(mode);
    }
}
