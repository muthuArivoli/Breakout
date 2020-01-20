game
====

This project implements the game of Breakout.

Name: Muthu Arivoli

### Timeline

Start Date: 1/11/2020

Finish Date: 1/19/2020

Hours Spent: 30

### Resources Used
* Java Documentation
* JavaFX Documentation
* lab_bounce in CS 308
* https://stackoverflow.com/questions/14203460/getresourceasstream-returns-inputstream-but-scanner-is-unable-to-read
* https://stackoverflow.com/questions/14438866/how-to-start-iterating-through-a-collection-not-from-the-beginning
* https://stackoverflow.com/questions/8490392/rotating-an-image-around-a-pivot-point
* https://www.geeksforgeeks.org/remove-element-arraylist-java/
* https://www.javatpoint.com/javafx-rotation
* https://www.programcreek.com/java-api-examples/?class=javafx.scene.Scene&method=setRoot




### Running the Program

Main class: Game

Data files needed: Brick1.gif, Brick2.gif, Brick3.gif, Brick4.gif, Brick5.gif, extraballpower.gif, laserpower.gif, pointspower.gif, sizepower.gif, ball.gif, level1.txt, level2.txt, level3.txt 

Key/Mouse inputs: Use left and right arrow keys to control the paddle and the up and down arrown keys to control the pinball. Press space initially to release the ball

Cheat keys: 

All cheat keys can only be entered once entering a level (cannot be played on the splash screen, or the ending screen)

* Press L to gain an extra life
* Press R to reset locaiton of paddle and ball
* Press T to destroy a block (won't gain any score however)
* Press a digit key to go to that level (any higher number will redirect to the highest level possible)
* Press U to gain 10000 points



Known Bugs: Very occasionally, when the ball strikes the pinball striker at a certain angle, the ball bounces out of the screen, thus not allowing the player to continue. 

Extra credit: There is a pinball striker located on each vertical edge that the player can use to strike the ball at angles, thus creating more dynamic motion.


### Notes/Assumptions
There are 5 different types of bricks and 4 different types of powerups (See the Splash Screen). Paddle abilities include reflecting differently depending on where the ball strikes the paddle, the paddle being able to grab the ball (once 10000 points have been reached - use the cheat key to get to it), and the paddle speeding up due to activation of a powerup, and the paddle being lengthened due to the activation of a different powerup.

In general, the plan was followed. The only change that occurred was an increase in the number of rows in level 2 and 3, since I did not realize how similar in difficulty it would be to have 4, 6, and 8 rows, thus it was changed to 4, 10, 14 rows. 

### Impressions

I did indeed enjoy this assignment. This has been my first somewhat large software project, and I feel like it has taught me much about planning and refactoring. 