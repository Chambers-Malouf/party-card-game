# Party Card Game – Backend

This repository contains the backend logic for the **Party Card Game**, a chaotic, mature-themed web-based card game built for social play.

## Purpose
The backend handles all card logic and game state, including:
- Drawing from multiple themed decks
- Dynamic card generation with player targeting
- Smart duplicate prevention logic

## Features
- Seven categories: `party`, `drinking`, `truthordrink`, `chill`, `nsfw`, `drama`, and `duo`
- Duo cards insert `[player1]` and `[player2]` into card text from name list
- In Quick Start mode, vague cards show and message reads: “Any player can answer”
- Smarter draw system: ensures all unique cards are used before repetition
- Session-based round control and API-based architecture

## ⚙Tech Stack
- Java (Maven)
- Deployed on **Render**
- Communicates with frontend via `/api/round` endpoint

🔗 Frontend repo: [party-card-game-frontend](https://github.com/Chambers-Malouf/party-card-game-frontend)
