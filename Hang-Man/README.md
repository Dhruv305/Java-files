# Java Hangman Game


## Description

Welcome to the Java Hangman Game repository! This project offers a classic and entertaining text-based Hangman experience implemented in Java, playable right from your terminal.

## Gameplay Rules

- **Objective**: Guess the secret word before the hangman is fully drawn.
- **Word Selection**: The game randomly selects a word from its internal dictionary.
- **Word Display**: Initially, the word is displayed as a series of underscores, one for each letter in the word (e.g., "_ _ _ _ _").
- **Guessing**: Guess letters by typing them in and pressing Enter.
- **Correct Guess**: If the guessed letter is in the word, it's revealed in the word display.
- **Incorrect Guess**: If the guessed letter is not in the word, a part of the hangman is drawn.
- **Game End**: The game ends when you correctly guess the word or when the hangman is fully drawn (game over).
- **Winning**: If you guess the word correctly, you win the game!
- **Losing**: If the hangman is fully drawn, you lose the game.
- **Retry**: You can choose to play another round after winning or losing.

## How to Play

1. **Clone this repository** to your local machine.
```bash
git clone https://github.com/your-username/java-hangman.git
```

2. **Compile the Java code**.
```bash
javac Hangman.java
```

3. **Run the game**.
```bash
java Hangman
```

4. **Follow the on-screen prompts** to guess letters and try to solve the word.

## Customization

You can customize the game by modifying the word dictionary in the `Hangman.java` file or adjusting game parameters as needed.

## Contributions

Contributions are welcome! If you'd like to enhance the game, fix bugs, or suggest improvements, please open an issue or create a pull request.

