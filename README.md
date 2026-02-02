# Grid Walker - Java Course Projects (2023)

A two-part Java project that implements an interactive grid navigation game where users follow directional arrows to reach a target.

## Project Overview

**Grid Walker** consists of two progressive implementations:
- **Part 1**: Console-based grid walker with random direction generation
- **Part 2**: GUI-based grid walker with interactive button interface

## Part 1: Console Grid Walker

### Features
- User-specified grid dimensions (rows × columns)
- Random placement of target marker (T) and directional indicators (U/D/L/R)
- Path tracking with three termination conditions:
  1. **Off-grid**: Path exits the grid boundaries
  2. **Self-intersection**: Path crosses itself
  3. **Target reached**: Path successfully reaches T marker
- Visual path display using asterisks (*)
- Step counter for successful target completion

### Usage
1. Enter grid dimensions
2. Enter starting position (row, column)
3. Program automatically follows directional path
4. View results and path visualization

## Part 2: GUI Grid Walker

### Features
- JOptionPane input dialogs for grid dimensions
- Interactive JFrame with button grid layout
- Unicode symbols:
  - Target: ◎ (U+25CE)
  - Arrows: ← ↑ → ↓ (U+2190-2193)
- Click-to-start navigation from any button
- Color-coded results:
  - **Yellow**: Visited path
  - **Red**: Crash (off-grid or self-intersection)
  - **Green**: Target reached
- Modal result dialogs

### Requirements
- Java 8 or higher
- Swing library (included in JDK)

## Running the Projects

### Part 1 (Console)
```bash
javac GridWalker.java
java GridWalker
```

### Part 2 (GUI)
```bash
javac GridWalkerGUI.java
java GridWalkerGUI
```

## Course Information
**Course**: Java Programming 2023  
**Assignment Type**: Progressive implementation project
