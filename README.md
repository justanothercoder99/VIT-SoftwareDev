# VIT-SoftwareDev
Live Programming Round: Software Engineer Role

Solution to reducing load time would be to make the code interact with a backend database.  
Presently the game loads the entire game data from a config file. Therefore everytime the game is restarted the game data has to be reloaded and the progress of the player is not saved. To make the code more scalable, we can make the code interact with a backend database which is continuously updated at runtime. The data will thus persist even after a restart allowing the player to continue his game.

Game Instructions:
When the game is started the player gets an option to choose two batsmen from a list of batsmen and a random bowling order is generated based on the overs set in the config file. The bowler bowls a random ball after which the player is suggested a list of possible shots. The player must choose the shot he wants to play based on the probability of success of each shot. 

Edge Cases handled:
1. Bowler does not bowl two continuous overs
2. Strike changes when odd number of runs are scored or if the over ends
