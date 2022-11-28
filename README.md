# Hangman

### Compile main file
1. Be in the root directory (.../Hangman)
2. To compile main file run `javac -d out -cp out src/Main.java`
3. To run compiled main class run `java -cp out Main`

### Compile other files
1. Be in the root directory (.../Hangman)
2. To compile file run `javac -d out src/(path to files)`

### Naming and importing packages
Packages compiled with command `javac -d out src/(pathto files)` can be imported by using the same name as defined package name;

Example:
To compile file `Keyboard.java` while in the root dir run:
`javac -d out/Components src/Components/Keyboard.java`

Later in the Main file import it like importing from out dir.
In this case in Main file: `Components.Keyboard.*`







##### Step by step to run current project
1. Go to root dir (/Hangman)
2. Compile components package by using `javac -d out src/Components/*.java`
3. Compile main file by using `javac -d out -cp out src/Main.java`
4. Run app by using `java -cp out Main`