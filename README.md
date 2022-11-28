# Hangman

### Compile main file
1. Be in the root directory (.../Hangman)
2. To compile main file run `javac -d out -cp out src/Main.java`
3. To run compiled main class run `javac -cp out Main`

### Compile other files
1. Be in the root directory (.../Hangman)
2. To compile file run `-d out/(path to files) src/(pathto files)`

Example:
To compile file `Keyboard.java` while in the root dir run:
`javac -d out/Components src/Components/Keyboard.java`

Later in the Main file import it like importing from out dir.
In this case in Main file: `Components.Keyboard.*`