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
        List<GameCard> oneOnOneCards = List.of(
                new GameCard("[player1], give your phone to [player2] for 60 seconds — app of their choice.", "extreme", "1on1", "give_phone.jpg"),
                new GameCard("[player1], give [player2] a dare. If they refuse, they drink.", "mild", "1on1", "give_dare_or_drink.jpg"),
                new GameCard("[player1] and [player2], take turns asking personal questions until someone folds and drinks.", "mild", "1on1", "ask_personal_questions.jpg"),
                new GameCard("[player1], explain your first impression of [player2]. Be honest.", "casual", "1on1", "first_impression.jpg"),
                new GameCard("[player1], if you had to hook up with [player2] or your last situationship, who would you pick?", "extreme", "1on1", "kiss_situationship_or_friend.jpg"),
                new GameCard("[player1], whisper something you've always wondered about [player2]. Answer out loud truthfully or finish your drink", "mild", "1on1", "whisper_question.jpg"),
                new GameCard("[player1], guess [player2]'s body count. If they're offended, finish your drink.", "extreme", "1on1", "guess_body_count.jpg"),
                new GameCard("[player1], rate [player2]'s flirting ability.", "casual", "1on1", "rate_flirting_ability.jpg"),
                new GameCard("[player1], challenge [player2] to a sip-for-sip showdown — loser finishes their drink.", "extreme", "1on1", "challenge_sip.jpg"),
                new GameCard("[player1], ask [player2] the last thing they lied about.", "mild", "1on1", "ask_last_lie.jpg"),
                new GameCard("[player1], you are a bitch, take every punishment for a whole round.", "extreme", "1on1", "you_a_bitch.jpg")
        );

        cardData.put("party", new ArrayList<>(List.of(
                new GameCard("[player1], invent a drinking rule — everyone follows it.", "casual", "conflict", "invent_a_drinking_rule_everyone_follows_it.jpg"),
                new GameCard("[player1], take a body shot off someone of your choice.", "extreme", "dare", "bodyshot.jpg"),
                new GameCard("[player1], do 1 valid push up, group decides if it counts.", "casual", "dare", "do_a_valid_pushup.jpg"),
                new GameCard("[player1], Let someone pour a mystery drink — you drink it.", "extreme", "dare", "mystery_drink.jpg"),
                new GameCard("[player1], Call the last person you Snapchatted and ask what they think of you.", "extreme", "dare", "call_snapchat.jpg"),
                new GameCard("Drink if you’ve sent a risky text in the past 48 hours.", "casual", "truth", "risky_text.jpg"),
                new GameCard("Drink for every situationship you've entertained this year.", "mild", "truth", "drink_for_situationship.jpg"),
                new GameCard("[player1], Let someone else decide how much you drink.", "mild", "dare", "let_someone_decide_drink.jpg"),
                new GameCard("Still in love with your ex? Finish your drink.", "extreme", "truth", "still_in_love_with_ex_running.jpg"),
                new GameCard("If you've had a pregnancy scare, finish your drink.", "extreme", "truth", "pregnancy_scare.jpg"),
                new GameCard("If you've taken/ bought a Plan B in the past month", "extreme", "truth", "bought_a_plan_b.jpg"),
                new GameCard("Finish your drink if you’ve ever said you are 'never drinking again’.", "extreme", "truth", "never_drinking_again.jpg")
        )));

        cardData.put("chill", new ArrayList<>(List.of(
                new GameCard("What’s one compliment you’ve never forgotten?", "casual", "truth", "chill_compliment.jpg"),
                new GameCard("If your younger self saw you now, what would surprise them most?", "casual", "truth", "chill_younger_self.jpg"),
                new GameCard("What’s something you’re still healing from?", "mild", "truth", "chill_healing.jpg"),
                new GameCard("Give a toast to someone in the room.", "casual", "truth", "chill_toast.jpg"),
                new GameCard("What’s one thing you want to be remembered for?", "casual", "truth", "chill_remembered.jpg")
        )));

        cardData.put("nsfw", new ArrayList<>(List.of(
                new GameCard("Describe your last hookup in five words — or finish your drink.", "extreme", "conflict", "nsfw_last_hookup.jpg"),
                new GameCard("Name someone here you’d kiss right now — or everyone drinks.", "mild", "conflict", "nsfw_kiss_now.jpg"),
                new GameCard("Reveal your favorite position or take a double.", "extreme", "conflict", "nsfw_position.jpg"),
                new GameCard("Read your last flirtatious message out loud or take 3 sips.", "mild", "conflict", "nsfw_flirty_text.jpg"),
                new GameCard("Text your ex 'I miss you' or down your drink.", "extreme", "conflict", "nsfw_text_ex.jpg")
        )));

        cardData.put("truthordrink", new ArrayList<>(List.of(
                new GameCard("What's your most scandalous secret? Tell it or drink.", "extreme", "truth", "truthordrink_secret.jpg"),
                new GameCard("Name someone in this room you find attractive — or take a shot.", "mild", "truth", "truthordrink_attraction.jpg"),
                new GameCard("Have you ever faked feelings to get what you wanted?", "mild", "truth", "truthordrink_fake.jpg"),
                new GameCard("What’s a lie you've told in a relationship?", "mild", "truth", "truthordrink_lie.jpg"),
                new GameCard("What would your worst enemy say about you — be real or take a drink.", "casual", "truth", "truthordrink_enemy.jpg")
        )));

        cardData.put("drama", new ArrayList<>(List.of(
                new GameCard("Name the last person you ghosted and why.", "mild", "conflict", "drama_ghost.jpg"),
                new GameCard("What's the messiest thing you've ever done at a party?", "mild", "conflict", "drama_mess.jpg"),
                new GameCard("Tell us your most recent toxic trait moment — or sip twice.", "mild", "conflict", "drama_toxic.jpg"),
                new GameCard("What rumor have you heard about someone here?", "extreme", "conflict", "drama_rumor.jpg"),
                new GameCard("What’s something you’d say to your ex if they were here right now?", "extreme", "conflict", "drama_ex.jpg")
        )));

        cardData.put("1on1", new ArrayList<>(oneOnOneCards));

        for (String mode : List.of("party", "chill", "nsfw", "truthordrink", "drama")) {
            cardData.get(mode).addAll(oneOnOneCards);
        }

        List<GameCard> allCards = new ArrayList<>();
        for (String mode : List.of("party", "chill", "nsfw", "truthordrink", "drama", "1on1")) {
            allCards.addAll(cardData.get(mode));
        }
        cardData.put("all", allCards);
    }

    public GameCard getRandomCard(String mode) {
        List<GameCard> deck = cardData.getOrDefault(mode, cardData.get("party"));
        if (deck == null || deck.isEmpty()) return null;
        return deck.get(new Random().nextInt(deck.size()));
    }

    public Map<String, List<String>> getPunishmentLevels() {
        return punishmentLevels;
    }

    public List<GameCard> getCardsForMode(String mode) {
        return cardData.getOrDefault(mode, new ArrayList<>());
    }
}
