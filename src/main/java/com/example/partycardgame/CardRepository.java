package com.example.partycardgame;

import java.util.*;

public class CardRepository {
    private final Map<String, List<GameCard>> cardData = new HashMap<>();

    private final Map<String, List<String>> punishmentLevels = Map.of(
            "casual", List.of("Take 2 sips.", "Smile and wave.", "Let someone pick your song."),
            "mild", List.of("3 second chug.", "Take a shot.", "Do 10 jumping jacks."),
            "extreme", List.of("Finish your drink.", "5 second chug.", "Let the group create a dare for you.")
    );

    public CardRepository() {
        Random random = new Random();

        List<GameCard> duoCards = List.of(
                new GameCard("[player1], trade phones with [player2] for 60 seconds — app of their choice.", "extreme", "duo"),
                new GameCard("[player1], give [player2] a dare. If they refuse, they drink.", "mild", "duo"),
                new GameCard("[player1] and [player2], take turns asking personal questions until someone folds and drinks.", "mild", "duo"),
                new GameCard("[player1], explain your first impression of [player2]. Be honest.", "casual", "duo"),
                new GameCard("[player1], if you had to hook up with [player2] or your last situationship, who would you pick?", "extreme", "duo"),
                new GameCard("[player1], whisper something you've always wondered about [player2]. [Player2], answer out loud truthfully or finish your drink", "mild", "duo"),
                new GameCard("[player1], guess [player2]'s body count. If they're offended, finish your drink.", "extreme", "duo"),
                new GameCard("[player1], rate [player2]'s flirting ability on a scale from 1 to ‘take me home’.", "casual", "duo"),
                new GameCard("[player1], challenge [player2] to a sip-for-sip showdown — loser finishes their drink.", "extreme", "duo"),
                new GameCard("[player1], ask [player2] the last thing they lied about.", "mild", "duo"),
                new GameCard("[player1], you are a bitch. [player1] gets to take every punishment for a whole round.", "extreme", "duo")
        );

        cardData.put("party", new ArrayList<>(List.of(
                new GameCard("Invent a drinking rule — everyone follows it.", "casual", "dare"),
                new GameCard("Take a body shot off someone of your choice.", "extreme", "dare"),
                new GameCard("Do 7 push ups, 2 drinks.", "mild", "dare"),
                new GameCard("Let someone pour a mystery drink — you drink it.", "extreme", "dare"),
                new GameCard("Call the last person you Snapchatted and ask what they think of you.", "mild", "dare"),
                new GameCard("Drink if you’ve sent a risky text in the past 48 hours.", "casual", "dare"),
                new GameCard("Sip for every situationship you've entertained this year.", "mild", "dare"),
                new GameCard("Let someone else decide how much you drink.", "mild", "dare"),
                new GameCard("You laugh, you drink — starting now.", "casual", "dare"),
                new GameCard("Still in love with your ex? Finish your drink.", "extreme", "dare"),
                new GameCard("If you've taken a Plan B in the past month, take a shot.", "extreme", "dare"),
                new GameCard("Finish your drink if you’ve ever said ‘never again’ and did it again anyway.", "extreme", "dare")
        )));

        cardData.put("chill", new ArrayList<>(List.of(
                new GameCard("What’s one compliment you’ve never forgotten?", "casual", "truth"),
                new GameCard("If your younger self saw you now, what would surprise them most?", "casual", "truth"),
                new GameCard("What’s something you’re still healing from?", "mild", "truth"),
                new GameCard("Give a toast to someone in the room.", "casual", "truth"),
                new GameCard("What’s one thing you want to be remembered for?", "casual", "truth")
        )));

        cardData.put("nsfw", new ArrayList<>(List.of(
                new GameCard("Describe your last hookup in five words — or finish your drink.", "extreme", "conflict"),
                new GameCard("Name someone here you’d kiss right now — or everyone drinks.", "mild", "conflict"),
                new GameCard("Reveal your favorite position or take a double.", "extreme", "conflict"),
                new GameCard("Read your last flirtatious message out loud or take 3 sips.", "mild", "conflict"),
                new GameCard("Text your ex 'I miss you' or down your drink.", "extreme", "conflict")
        )));

        cardData.put("truthordrink", new ArrayList<>(List.of(
                new GameCard("What's your most scandalous secret? Tell it or drink.", "extreme", "truth"),
                new GameCard("Name someone in this room you find attractive — or take a shot.", "mild", "truth"),
                new GameCard("Have you ever faked feelings to get what you wanted?", "mild", "truth"),
                new GameCard("What’s a lie you've told in a relationship?", "mild", "truth"),
                new GameCard("What would your worst enemy say about you — be real or take a drink.", "casual", "truth")
        )));

        cardData.put("drama", new ArrayList<>(List.of(
                new GameCard("Name the last person you ghosted and why.", "mild", "conflict"),
                new GameCard("What's the messiest thing you've ever done at a party?", "mild", "conflict"),
                new GameCard("Tell us your most recent toxic trait moment — or sip twice.", "mild", "conflict"),
                new GameCard("What rumor have you heard about someone here?", "extreme", "conflict"),
                new GameCard("What’s something you’d say to your ex if they were here right now?", "extreme", "conflict")
        )));

        cardData.put("duo", new ArrayList<>(duoCards));

        for (String mode : List.of("party", "chill", "nsfw", "truthordrink", "drama")) {
            cardData.get(mode).addAll(duoCards);
        }

        List<GameCard> allCards = new ArrayList<>();
        for (String mode : List.of("party", "chill", "nsfw", "truthordrink", "drama", "duo")) {
            allCards.addAll(cardData.get(mode));
        }
        cardData.put("all", allCards);
    }

    public GameCard getRandomCard(String mode) {
        List<GameCard> deck = cardData.getOrDefault(mode, cardData.get("party"));
        return deck.get(new Random().nextInt(deck.size()));
    }

    public Map<String, List<String>> getPunishmentLevels() {
        return punishmentLevels;
    }

    public List<GameCard> getCardsForMode(String mode) {
        return cardData.getOrDefault(mode, new ArrayList<>());
    }

}
