export CLASSPATH=out
javac -d out src/Interfaces/*.java
javac -d out src/Components/*.java
javac -d out src/Utils/*.java
javac -d out src/Main.java

# javac -d out src/Interfaces/*.java
# javac -d out -cp out src/Components/*.java
# javac -d out src/Utils/*.java
# javac -d out -cp out src/Main.java