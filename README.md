# UIUC Peg Solitaire (Java / Swing)

A simple, UIUC-themed **Peg Solitaire** game written in Java/Swing.  
Click to jump pegs, track your moves, and hit the reset button to start over.

> ![Preview](docs/screenshot.png)

---

## How to Play
- Standard peg solitaire rules: **jump** a peg over an adjacent peg into an **empty hole** two spaces away.  
- The jumped peg is removed.  
- Goal: end with **one** peg on the board (fewest moves wins).
- Top-left **↻** button resets the board. The **MOVES** counter shows your total moves.

---

## Requirements
- **JDK 21+** (Oracle or Temurin)
- (Recommended) **VS Code** with **Extension Pack for Java**

---

## Run Instructions
**VS Code**  
1. Open the folder in VS Code.
2. Ensure `.vscode/launch.json` exists
3. Open `src/Viewer.java` and click **Run**

**Terminal**  
Windows  
`javac -d out src\*.java`  
`java -cp "out;resources" Viewer`  
macOS/Linux  
`javac -d out src/*.java`  
`java -cp "out:resources" Viewer`  
