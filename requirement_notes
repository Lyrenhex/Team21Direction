# Requirements

*Succinct introduction explaining how requirements are elicited and negotiated & justify presentation*

*Name of game* is a game application built using Java. The aim of the project is to develop a pirate exploration game which can be completed in 5-6 minutes. We considered user and system requirements separately. Firstly, due to the time constraint, we opted for less complicated alternatives when available.

The below sections must include points on:
- Architecture and design
- Coding
- Development

## User requirements


## System requirements

**Product perspective**
1. Dependencies
	- Runs on a computer with a mouse and keyboard
	- Not platform dependent - can be run on any OS with a Java environment
2. System interfaces
	- *name of game* is a standalone application, thus does not require any system interfaces 
3. User interfaces - the following interfaces are available after the user runs the game
	- Play
	- Game menu
		- Rules screen explaining gameplay purpose and controls. For easy usability, we allow the user to choose between keyboard or mouse input.
		- Sound and music toggle
		- Pause - game is paused until the user re-clicks
4. Software interfaces
	- libGDX game engine is used to render in-game animations (e.g. weapons and combat), handling ship interaction / collisions
		- Considering time constraints, we decided on using a pre-built game engine (as opposed to creating one ourselves). Our focus here is on prototyping and designing the actual game.
		- Alternatives include monkey engine ...

**Mechanics**
- Real-time (not turn-based)
	- We briefly considered a turn-based implementation but decided on real-time due to the combat and thus action-oriented nature of the game. Also faster, and decisions should be reflex-based e.g. reacting to and dodging missiles.
- On game start:
	- A map/world is generated with four (or three?) colleges on open waters
	- Player is assigned to random college
		- Each college will start with the same number and level of ships for fairness and consistency
	- Player spawns on a ship near their assigned college
- Movement
	- Player can navigate the ship in four primary directions by either using WASD or by moving the mouse
	- Ship interaction: players will encounter other ships whilst exploring, either allies or enemies
		- Ships may collide with other ships which results in damage to the ship
- Battle with college building
- Capture 3 colleges in 5-6 minutes
	- On deciding the number of colleges, we accounted for how crowded it would look on the map.
- Points
	- An attribute for the player
	- Increases over time (i.e. experience indicator)
	- Currency which can be exchanged for skill upgrades e.g. shooting accuracy

## References

**Software requirements specifications**
[Android game](https://senior.ceng.metu.edu.tr/2015/vana/uploads/4/4/6/9/44699515/srs.pdf)
[2D chess](http://www.pages.drexel.edu/~pv42/thebiz/SRS-1.pdf)
[Card game](https://www.bellevuecollege.edu/wp-content/uploads/sites/135/2019/04/SRS_WebGLGame.pdf)
