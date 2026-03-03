# MazeChase 🎮

**MazeChase** is a simple yet fun JavaFX-based maze game where the player collects coins and finds the exit before time runs out. Each game starts with a randomly generated maze and a countdown timer, making every playthrough a unique challenge.

---

## 🧩 Game Objective
- Navigate the maze using arrow keys.
- Collect all the coins.
- Reach the exit before the timer hits 0.

---

## 🚀 Features
- 🔁 Randomly generated maze every run
- ⏱ Countdown timer (default: 90 seconds)
- 💰 Coins to collect
- 🚪 Exit to find after collecting all coins
- 🎨 Custom-drawn graphics with JavaFX

---

## 📸 Screenshots

<img width="535" height="610" alt="image" src="https://github.com/user-attachments/assets/9e167b3b-d1d8-464f-ab0c-6727ede96e8a" />


---

## 🛠 Technologies Used
- Java 17+
- JavaFX SDK 25

---

## 🧪 How to Run

### Prerequisites
- Install [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Download and unzip [JavaFX SDK 25](https://gluonhq.com/products/javafx/)

### Compilation
Open a terminal or command prompt in the project folder:

```bash
javac --module-path "path/to/javafx-sdk-25/lib" --add-modules javafx.controls,javafx.fxml *.java
```

### RUN

```bash
java --module-path "C:\openjfx-25.0.2_windows-x64_bin-sdk\javafx-sdk-25.0.2\lib" --add-modules javafx.controls,javafx.fxml Main
