Number Guessing Game
Overview-->
This is a simple Number Guessing Game built in Java (with JavaFX UI support).
The computer randomly selects a number between 1 and 100, and the player must guess it within a limited number of attempts.

Features-->
Random number generation between 1–100.
Limited attempts (default: 7 attempts).
Display of remaining attempts.
Success message when guessed correctly.
Failure message when attempts run out.
Option to reset and start a new game.
JavaFX GUI (optional, can run in console too).

Requirements-->
Java 17+
JavaFX SDK installed and configured
if not then: You can download it from: https://openjfx.io/
(Optional) Any IDE like IntelliJ IDEA, Eclipse, or VS Code

How to Run-->
1. Run in Console
   javac GameLogic.java Main.java
   java Main
2. Run with JavaFX
   javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml src/*.java
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml Main

(Replace /path/to/javafx-sdk/lib with your actual path)

How to Play-->
Start the game.
Enter a number between 1 and 100.
The game will tell you if your guess is too high, too low, or correct.
You have 7 attempts to guess the correct number.
Press Reset/New Game to play again.

Example Gameplay-->
Guess a number between 1 and 100:
> 50
Too low! Attempts left: 6
> 75
Too high! Attempts left: 5
> 68
Correct! You guessed the number in 3 attempts.

