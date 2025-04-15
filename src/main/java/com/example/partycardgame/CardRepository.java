package com.example.partycardgame;

import java.util.*;

public class CardRepository {
    private final Map<String, List<String>> cardData = new HashMap<>();

    public CardRepository() {
        // Duo cards (used across all modes)
        List<String> duoCards = List.of(
                "[player1], trade phones with [player2] for 60 seconds — app of their choice.",
                "[player1], give [player2] a dare. If they refuse, they drink.",
                "[player1] and [player2], take turns asking personal questions until someone folds and drinks.",
                "[player1], explain your first impression of [player2]. Be honest.",
                "[player1], if you had to hook up with [player2] or your last situationship, who would you pick?",
                "[player1], whisper something you've always wondered about [player2].",
                "[player1], guess [player2]'s body count. [player2], confirm or deny — then drink.",
                "[player1], rate [player2]'s flirting ability on a scale from 1 to ‘take me home’.",
                "[player1], challenge [player2] to a sip-for-sip showdown — loser finishes their drink.",
                "[player1], ask [player2] the last thing they lied about."
        );

        // Base decks
        cardData.put("party", new ArrayList<>(List.of(
                "Invent a drinking rule — everyone follows it.",
                "Take a body shot off someone of your choice.",
                "Do 10 squats or take 2 drinks.",
                "Let someone pour a mystery drink — you drink it.",
                "Call the last person you Snapchatted and ask what they think of you."
        )));

        cardData.put("chill", new ArrayList<>(List.of(
                "What’s one compliment you’ve never forgotten?",
                "If your younger self saw you now, what would surprise them most?",
                "What’s something you’re still healing from?",
                "Give a toast to someone in the room.",
                "What’s one thing you want to be remembered for?"
        )));

        cardData.put("drinking", new ArrayList<>(List.of(
                //"Drink if you’ve sent a risky text in the past 48 hours.",
                //"Sip for every situationship you've entertained this year.",
                //"Let someone else decide how much you drink.",
                //"You laugh, you drink — starting now.",
                //"Still in love with your ex? Finish your drink.",
                "Finish your drink if you’ve ever said ‘never again’ and did it again anyway."
        )));

        cardData.put("nsfw", new ArrayList<>(List.of(
                "Describe your last hookup in five words — or finish your drink.",
                "Name someone here you’d kiss right now — or everyone drinks.",
                "Reveal your favorite position or take a double.",
                "Read your last flirtatious message out loud or take 3 sips.",
                "Text your ex 'I miss you' or down your drink."
        )));

        cardData.put("truthordrink", new ArrayList<>(List.of(
                "What's your most scandalous secret? Tell it or drink.",
                "Name someone in this room you find attractive — or take a shot.",
                "Have you ever faked feelings to get what you wanted?",
                "What’s a lie you've told in a relationship?",
                "What would your worst enemy say about you — be real or take a drink."
        )));

        cardData.put("drama", new ArrayList<>(List.of(
                "Name the last person you ghosted and why.",
                "What's the messiest thing you've ever done at a party?",
                "Tell us your most recent toxic trait moment — or sip twice.",
                "What rumor have you heard about someone here?",
                "What’s something you’d say to your ex if they were here right now?"
        )));

        // Duo deck (kept standalone in case you ever want to use just these)
        cardData.put("duo", new ArrayList<>(duoCards));

        // Inject duo cards into all main categories
        for (String mode : List.of("party", "chill", "drinking", "nsfw", "truthordrink", "drama")) {
            cardData.get(mode).addAll(duoCards);
        }

        // Combine all into 'all' mode
        List<String> allCards = new ArrayList<>();
        for (String mode : List.of("party", "chill", "drinking", "nsfw", "truthordrink", "drama", "duo")) {
            allCards.addAll(cardData.get(mode));
        }
        cardData.put("all", allCards);
    }

    public List<String> getCardsForMode(String mode) {
        return cardData.get(mode);
    }
}
