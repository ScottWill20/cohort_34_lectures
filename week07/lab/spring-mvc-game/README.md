
# Lab: Spring MVC Game

## Instructions

Work with a partner. Create a simple game that runs as a Spring MVC application. A `@RestController` manages the game state and handles requests for moves. The player uses VS Code REST Client to play the game.

Keep the game simple at first. Add features once you get it working.

Candidates in order of difficulty (roughly):

* [Three-card Monte](https://en.wikipedia.org/wiki/Three-card_Monte) or [Shell Game](https://en.wikipedia.org/wiki/Shell_game): Find a card hidden among three cards or an object hidden under a cup. No need to represent actual cards or cups. Generate a random number between 1 and 3. If the user guesses the correct number, they win. If not, they lose. Make it fancier once it's working: keep track of a score, give hints, etc.
* Guess the number: Generate a random number between 1 and 100. The user makes a series of guess. For each guess, the game gives feedback: too high, too low, or got it!
* Rock, Paper, Scissors: The player competes with the computer. To start, all games are single player.
* Hangman: Consider rebranding with less "hanging".
* Tic-Tac-Toe: The player competes against a random computer player.
* [Bulls and Cows](https://en.wikipedia.org/wiki/Bulls_and_Cows): Similar to [Mastermind](https://en.wikipedia.org/wiki/Mastermind_(board_game)), but with numbers instead of colorful pegs.
* [Jotto](https://en.wikipedia.org/wiki/Jotto): Similar to Mastermind, but with words.
* [Concentration](https://en.wikipedia.org/wiki/Concentration_(card_game)): A card-matching memory game.
* Ask your instructor: You're welcome to tackle any game. Confirm that it's the right size with your instructor.

Don't worry about logical layers in this lab. The goal is to rapidly prototype a Spring MVC game. Game state can be stored directly in the controller, though extracting game state to its own types may make you more productive.

## More Goals

1. Use meaningful HTTP methods for game operations.

* `POST`: starts a game or restarts a game.
* `PUT`: alters the game (makes a move).
* `GET`: returns the current status of the game if it's stateful.
* `DELETE`: could undo a move if your game supports it.

2. Initially it's okay for the application to support one player at a time. (Though for many of the game candidates, there should be a way to start a new game.) Given that the game is connected to the internet, try to manage more than one game at a time.

For example, **Player A** in Chicago starts a game:

```http
POST http://localhost:8080/start HTTP/1.1
Accept: application/json
```

and they receive a game identifier to be used with all further game requests.

```http
HTTP/1.1 201 
Vary: Origin, Access-Control-Request-Method, Access-Control-Request-Headers
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 26 Aug 2020 14:21:00 GMT
Connection: close

{ 
  "gameId": 12
}
```

**Player B** in Austin starts a game:

```http
POST http://localhost:8080/start HTTP/1.1
Accept: application/json
```

and they receive a game identifier to be used with all further game requests.

```http
HTTP/1.1 201 
Vary: Origin, Access-Control-Request-Method, Access-Control-Request-Headers
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 26 Aug 2020 14:21:00 GMT
Connection: close

{ 
  "gameId": 13
}
```

**Player A** makes a move.

```http
PUT http://localhost:8080/move HTTP/1.1
Content-Type: application/json
Accept: application/json

{
    "gameId": 12,
    "moveData": "?"
}
```

**Player B** makes a move.

```http
PUT http://localhost:8080/move HTTP/1.1
Content-Type: application/json
Accept: application/json

{
    "gameId": 13,
    "moveData": "?"
}
```

3. Add multi-player support for games that can use it.

4. Remember player career stats. For example, keep track of wins and losses in a three-card monte series.