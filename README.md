# tdt4240-pattern-exercise

# Step 1: Implementation of a program
Since I didn't manage to include the Pong game (task 4) into my submission for Exercise 1 due to Covid-19 sickness and personal family reasons 
(got extension from Milad Naeimaei Aali), I am using this game to show task 4 and illustrate the implementation of the Singleton, Template, and State patterns.

# Step 2: Implement the Singleton pattern
The goal of the Singleton pattern is to ensure that only one object (a single instance of the class) is created and being used by other classes.
The main advantage of the Singleton pattern is memory saving, because it limits the number of object creation to only one. This pattern is widely used
in multi-threaded and database applications.
I applied the Singleton pattern to the [PongGame class](core/src/com/pong/game/PongGame.java). Check out comments to see how it has been implemented.
The PongGame class is instantiated in [DesktopLauncher](desktop/src/com/pong/game/DesktopLauncher.java).

# Step 3: Implementation of pattern(s) from the list
Two patterns – Template and State (both are behavioural design patterns) – have been implemented in this game.

**Template Pattern**
-	Abstract class State, which defines operations with abstract template methods. Both PlayState and MenuState are classes that extend State and override its methods.
- Abstract class Sprite, which defines three operations with abstract template methods (`getTexture()`, `getPosition()`, `getBounds()`). Both Ball and Paddle classes extend the Sprite class and override its methods.

**State Pattern:**
- GameStateManager keeps track of game states, i.e., where the user is in the game (either *menu state* or *play state*).


# Step 4: Theory
_a)_ 
Architectural patterns:
- Model View Controller
- Pipe & filter
- Entity Component System

Design patterns:
- Observer
- State
- Template method
- Abstract factory

_b)_


_c)_
