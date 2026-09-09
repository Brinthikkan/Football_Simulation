## Hello Gamers ##

I wanted to be able to include some explanation of what things are and how we got here, as well as the purposes each java file serves.

Firstly; I had to add in these files, like lib, bin, and i guess this README, by creating a new Java Project, since there's a bunch of files that VSCode was looking for which didn't exist.

I created a blank "Java: No Build Tools" project, and used the structure/config files that it generated to do so.

Secondly; I have tried to structure the java files into relatively appropriate folders.

- 'app' is where the main is, and it sstarts and runs the application
- 'entities' are things that all exist within the simulation, so players, the ball, teams, and referees
- 'simulation' are things that are respoisble for managing the actual match, whether that's its state, the rules for that match, the teams's scores,etc.
- 'ui' is where we can put things that are reponsible for what we see during the simulation.

 A side effect of this is that I had to go in, and make changes to most of the preexisting entities to open them up and make them public, so that they became accessible, primarily by main. you may notice the packages (foldername); at the top of some of the files. additionally, in the Entity.java file, i had to add litle getters and setters to fix the error that was being detected in main

Otherwise, everything i added at the moment is primarily structural, with no real changes to the code. i just wanted to get something out there to assist, but i will continue to try and work on this when i can :3

Now here's a breakdown of my intentions behind the  Java files, and notes for each, for those that I added in this version.

## 1 ~ Referee.java
        This is an entity that could exist on the field who is able to keep track of the game's events.
        Often times, in sport, rules are maintained by those with the authority to do so. Thus perhaps in a future version of the simulator, corrupt referees may exist, who allow a bit of leniancy to certain teams.
        Otherwise, they, to me, are an integral part of the sport, as a usually unbiased 3rd party.
        Placeholder for now.
        
## 2 ~ Team.java
        Teams should exist as a way to actually group the individual players.
        Teams could also have internal rules, and also players could derive some mechanics and behaviour from their team
        Teams are also an organisation, where for example, a coach may exist, who doesn't count as a player, but still can have a strong impact on the game.

## 3 ~ GameState.java
        GameState is intended to represent the current state of the Match being played.
        It generally would contain things like the current MatchPhase, the team's scores, which player/team has the ball, the time elapsed/remaining, etc.
        Maybe the game PAUSES because a player dies suddenly idk, but GameState is where that is managed.

## 4 ~ Match.java
        As opposed to GameState, Match runs the actual match itself, representing One actual game/match/simulation.
        This is the central hub that can communivate with all sorts of places,, and can be responsible for progressing the active simulation.
        So when it comes time to create/run a match, we should use this, as it should contain everything we need to do so.

## 5 ~ MatchPhase.java
        MatchPhase is in charge of tracking/managing the current phase/stage of the match.
        AFter some research, i added a bunch of them to the list, and then added some that i thought could be helpful for the progression of the game. They don't all need to necessarily be used, but it's good that they're there.
        THe simulation can therefore behave differently, depending on what phase we are currently in. It doesn't really contain any mechanics itself, since it's best kept as an enum that other entities can look at to know what's up.

## 6 ~ Ruleset.java
        This determines the rules that the Match operates under.
        For now/primarily, there will be one normal ruleset, but if we separate this from Match, we can just have it look here for the rules, which allows us to expand options later on much easier.
        It also lets us test out longer/shorter simulations, add weird rules if we want, or whatever we please.

## 7 ~ Score.java
        THis keeps track of the score of a match, and holds the required stuff to update/read it.
        Rather than each team deciding their own score, Match  holds one Score that records valid goals for both teams.
        In the future we could add in mechanics, that allow players to change behavior and strategy, depending on the current score and the difference between them.


## 8 ~ Environment.java
        This is what we can use to determine different attributes pertaining to the environment that the players will be soccering in.
        Primarily, it will be a grassy field, but it's good to leave avenues open for adding different terrain, weather, field conditions, etc, to the match to see how it affects the simulations.
        It's more about the PHYSICAL environment, rather than the boundaries that constrain the game itself.

## 9 ~ Goal.java
        Goal.java is the goal/scoring area within the simulation.
        It gives us something for the BALL to interact with so that the simulation can determine whether a goal has actually been scored.
        explicitley is NOT the "GoalEvent.java" which i should really add to this list, which would reflect the actual event of someone Goaling. THis is just to do with the Scoring Zone.

## 10 ~ PlaySpace.java
        This determines the bounds that the game can be played within.
        It can change, depending on the environment, the game, etc. Think of it more as the collectively shared "game space", the invisible wall that surrounds the field, rather than a physical thing.
        It can be used to determine the size of the field or arena.
        It doesnt necessarily even need to be a rectangle/normal field. Who knows what the future holds.

## 11 ~ GoalEvent.java
        GoalEvent is in charge of the actual EVENT of a goal being scored.
        Goal.java is in charge of hte physical scoring area, but if the ball actually enters the zone, then that's up to GoalEvent to manage baybeeeee
        This is responsible for knowing who score, which player, which team, what time it occured, which goal it was scored in, who last touched/passed the ball (in event of "own goal" as they call it)
        This is usd by the Match/GameState/Score, maybe even referee, so that Scoring is a bit more than Score += 1; and also gives us a record of what happened.

## 12 ~ Coach.java
        I allueded to this earlier and thought i should add it too.
        Coaches are the coaches for each team. THey are not a player, but can still influence the match and the behavioru of their team.
        IN the future, the could be responsible for team strategy, whether that's aggression, substitutions, etc.
        This also allows us to have an entity serve as a hub for any decision-making that needs to happen at a higher level than the players, without strictly leaving it up to the nebulous Team.java.


A lot of these as i say are currently shells and placeholders. I just wanted to really get things into a relateively organised state before working on anything else.

Thank you!!

~ Michael ~
