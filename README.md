# Tank Fight Game

## Instruction
- The first step is to add the User Library for JavaFX, just like other JavaFX projects.
- Configure VM arguments
  - Before running the project, it is necessary to set VM arguments to ensure that JavaFX modules can be loaded correctly.
  1. Open Run Configuration:
     Right click on main/Main.java and select Run Configuration.
  2. Fill in VM arguments:
     Enter the following content in the VM arguments, make sure that "javafx.media" is included:
     > --add-modules javafx.controls,javafx.fxml,javafx.media
  3. apply and run the project

## Implementation
- This project, developed using JavaFX and Scene Builder, is organized into several distinct directories within the project structure:
  1. main: This directory contains the primary application logic, including the main entry point of the game and the core functionalities for game flow and management.
  2. controller: All game controllers are located here. These components handle user interactions and facilitate communication between the game logic and the JavaFX user interface. Examples include controllers for the main menu, level selection, and game-over screens.
  3. elements: This part stores all image assets used in the game, such as tank sprites, backgrounds, and obstacle textures. These assets are essential for creating the immersive and visually appealing game environment.
  4. scene: This part has all FXML files, which define the visual structure of the game scenes, are stored here along with accompanying CSS files. These elements define the appearance and layout of various interfaces, such as the level selection menu and gameplay screen.
