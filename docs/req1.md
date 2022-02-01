## Elicitation

- We began eliciting requirements by reading through the game brief we were given at the beginning of the project looking for any ambiguity, either a feature with generally limited explanation or a feature that’s implementation could change to work best depending on the context surrounding the game. 
- Having gone through all of the explicit requirements, highlighting any key areas that needed further discussion, we formulated questions which we felt would shed light on each of our qualms with the brief. 
- We took these questions to the customer so that we could get a clear understanding of what they required rather than simply speculating within the development team. 
- Our customer meeting allowed us to find out exactly what the customer wanted for each feature and to understand the context surrounding the game. 
- The game is designed to be played at a university open day event, this means that people should be able to walk up and complete the entire experience in five to ten minutes. This context played an important role in deciding how the game should be structured and is intrinsically linked to many of the requirements.
- When formalising requirements we began by coming up with the user requirements, these are written for non-technical people involved in the requirements process and relate directly to the actions that the user will take. 
- The User requirements table defines a requirements idea, describes the requirement and makes a note of any environmental assumptions we have made when coming up with the requirement. 
- There are two more tables which hold our system requirements, each system requirement is given a requirement id, described and where appropriate linked to one of the user requirement ids so that it is clear how the requirement will help in completing the project. 
- The system requirements are split into functional and non-functional requirements
- Functional requirements are the things the game must do
- Non-Functional requirements detail the qualities the game must have
- Each non-functional requirement will have fit criteria which are precise criteria on which the success of the system can be judged

## Statement of Requirements

### Single Statement of Needs

The game should be playable by visitors on a university open day do that they have an enjoyable experience and may be inspired to pursue Computer Science.

### User Requirements

| ID | Description | Priority | Environmental Assumptions |
|---|---|---|---|
|UR_LAUNCH|The user should be able to launch the game without the need to open any additional software on the device|Should|While this is important in the context of the open day the game will already be open ready for the user to play|
|UR_EASY_TO_UNDERSTAND|The user should be able to quickly understand the controls and narrative of the game.|Shall|The user will be seeing the game for the first time when they come to play it but will be comfortable using a keyboard and mouse to control a computer |
|UR_CLEAR_GRAPHICS|The graphics of the game should be clear so that they are visible from a distance. If the game is played on a standard desktop monitor it should remain clearly visible for anyone within 1.5m of the display, if it is projected on a large screen the game should be clearly visible to everyone within the room.|Shall|Those viewing the game will have good vision.|
|UR_ACCESSIBILITY|The game should be playable by almost anybody, it should be easy to control and support colour blindness|Should|Those playing the game will have good enough vision to see the objects on the screen|
|UR_RUN_TIME|The game should take between 5 to 6 minutes to complete for a new player. This will involve capturing or destroying 4 colleges.|Should|Visitors will want to spend time looking around the university and town and therefore will not want to spend too long on the game|
|UR_CONTROLS|The player should be able to control the game using only the keyboard|Shall||
|UR_COLLEGE_COMBAT|The player should be able to engage in combat with other colleges in the game.|Should||
|UR_SAILING|The player should be able to control where the ship sails around the map.|Shall||
|UR_COLLEGE_CAPTURE|The player should be able to capture the other colleges within the game when they have defeated them in combat.|Should||
|UR_COLLEGE_DESTROY|The player should be able to destroy the other colleges within the game when they have defeated them in combat.|Should||
|UR_MUTE_SOUND|The player should be able to mute the game sound at any time during gameplay|May|The game will be played in a public setting, likely with conversations taking place so it is important that the sound can be muted easily|
|UR_UPGRADES|The player should be able to upgrade their ship as the game progresses with new weapons or abilities|Should||
|UR_FAIRNESS|The game should be fair on the player, offering a satisfying level of challenge whilst not leading to frustration. There should be a new player win rate of around 90%|Should|Players will likely only get one opportunity to play so the game needs to be easy enough that they will likely win first try|
|UR_INSPIRATIONAL|The game should have an inspirational effect on the player, compelling them to pursue computing themselves|Shall||
|UR_FUN|The player should leave the game with a positive mindset|Shall|The open|
|UR_WIN|The player should be able to achieve a predefined condition within the game which triggers a win|Shall||
|UR_SOUND|The player will be able to hear music and sound effects which relate to the actions taking place on screen.|Should|The game will be played in an open day environment, likely with lots of background noise and people talking, as a result of this it may be preferable to play without game sound|
|UR_GOLD|The player ship should be able to earn gold throughout the course of the game|Shall||
### System Requirements

#### Functional Requirements

| ID | Description | User Requirements |
|---|---|---|
|FR_PC|Runs on a computer device with a mouse and keyboard||
|FR_PLATFORM_AGNOSTIC|Runs on any OS with a Java environment and a keyboard and mouse||
|FR_STANDALONE|Does not require any external system interfaces to play|UR_LAUNCH|
|FR_KEYBOARD|The keyboard can be used as the sole means of controlling the ship and game interfaces|UR_CONTROLS|
|FR_START_BUTTON|Upon launching the program there will be a start button which begins the game||
|FR_START_SCREEN|A start screen will display when play is pressed which details the controls and objective of the game|UR_EASY_TO_UNDERSTAND|
|FR_PAUSE|A pause button will be available which can be used at any time to pause the game until the play button is pressed||
|FR_REALTIME_COMBAT|The ship will be able to fire weapons at and attack the other colleges as it sails around the map without entering a different game screen.|UR_COLLEGE_COMBAT|
|FR_DAMAGE|The player ship will take damage when it collides with objects or is hit by projectiles.|UR_COLLEGE_COMBAT|
|FR_CURRENCY|Currency can be gained throughout the game which can be earned through combat with enemy colleges.|UR_GOLD|
|FR_EXP|Experience points can be gained throughout the game which can be earned through combat with enemy colleges and through the passage of time.||
|FR_WEAPONS|The ship will have weapons which can be used to attack enemy colleges.|UR_COLLEGE COMBAT|
|FR_STATS|The ship will have stats which will be upgraded throughout the course of the game as experience points are earned.|UR_UPGRADES|
|FR_FIGHT_BACK|The enemy colleges can attack the player boat using projectiles which must be dodged.|UR_COLLEGE_COMBAT|
|FR_SOUND_EFFECTS|The game will have sound effects that are relevant to what is currently happening within the game|UR_SOUND|
|FR_MUSIC|There will be background music which plays throughout the course of the game.|UR_SOUND|
|FR_MUTE|The sound will be mutable at any time during the game.|UR_MUTE_SOUND|
|FR_MOVEMENT|The ship should be able to navigate in four primary directions a keyboard with wasd.|UR_SAILING|
|FR_ENEMY_SHIPS|Enemy ships will sail around the map.||
|FR_CAPTURE_OR_DESTROY|When an enemy college is defeated in combat the choice should be given as to whether they should be captured or destroyed.|UR_COLLEGE_CAPTURE, UR_COLLEGE_DESTROY|

#### Non-Functional Requirements

| ID | Description | User Requirements | Fit Criteria |
|---|---|---|:--|
|NFR_SHORT_GAME|The game should not take a long time to complete.|UR_RUN_TIME|Time to complete the game < 6 minutes|
|NFR_RUNS_WELL|The game should run smoothly with a consistent framerate|UR_FUN|The game should run with a framerate locked at 60fps|
|NFR_FAST_LOADING|The game should load quickly when transitioning between screens.|UR_FUN|Time to transition between screens must be < 3 seconds|
|NFR_COLOUR_BLINDNESS|The game should be playable without reliance on colour |UR_ACCESSIBILITY|
|NFR_CLEAR_INSTRUCTIONS|The objective and controls of the game should be described clearly and concisely upon starting the game.|UR_EASY_TO_UNDERSTAND|The player should have to spend no more than 30 seconds familiarising themselves with the controls and concept of the game before starting.|
