# Game Design Final
### Muthu Arivoli

Muthu Arivoli - Designed and wrote code for the entire project

## Design goals

* Design a game in JavaFX that is a version of Breakout
* Be able to add new features like powerups and bricks with relative ease
* Be able to write readable code that I, or someone else, will be able to look at and understand in the future


## High-level Design
The Game class has 4 different states for the display - the splash screen, a level screen, the win screen, or the lose screen. Each screen takes care of moving to the appropriate next screen based on its state and inputs from the player. The level contains all of the information required to play the level, including the interacting objects in the game (like the ball, paddle, and bricks), and reads its initial configuration from a txt file. Powerups and Bricks are both abstract, and specific types of each are implemented by subclasses that each modify a specific parameter of the superclass.     
#### Core Classes
* Game
* Level
* Powerup
* Brick

## Assumptions that Affect the Design

I assumed that all of the objects would be represented by images, and thus by ImageView objects. Due to this, my collision code relies on properties from ImageView objects, that other representations of the images may not have. Thus, any new features that are to be added will  be required to use ImageView objects. 

#### Features Affected by Assumptions
All of the objects in the game rely on there being an image in the resources folder and that they all use the DisplayImage class which uses an ImageView object to represent its behavior as an image.

## New Features

#### Easy to Add Features
* Powerups - To create a new powerup, create a new class that extends the abstract class powerup. Implement the activate powerup and deactivate powerup methods that operate on the object that is passed in when initially constructed. Then add an if statement corresponding to the label of the powerup to the addPowerup method in class Level to get your powerup added to the level.
* Special Blocks - To create a new special block, create a new class that extends the abstract class SpecialBlock and override the method that you want to change to add functionality to the block. Using this, you can also chain special blocks together.
* Levels - To create a new level, create a new text file with the configuration of the level and name it level#.txt, and increase the constant num_levels appropriately. The text file should start with the number of rows and columns of blocks, followed by the grid of blocks itself, with each integer representing a different block.
