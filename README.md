James Owens 
Final Project
Tizio

##About

This game is an infinitely scrolling platformer. The objective is to make it as far as possible, jumping over obstacles as they come. It is built using libgdx (https://libgdx.badlogicgames.com/). 

##Screencast

A screencast of the working app is available: 

##Running 

The easiest way to run the project is by opening the project folder in Adnriod Studio. Run the gradle build. You may need to point the application to the andriod apk on your hard drive.


##Structure

There are basically 3 types of classes in this project

- A **scene** represents a state of the game, for example play or title. The scene is responsible for creating and drawing entities on the canvas
- A **scene manager** (singleton) is a stack of scenes and is responsible for drawing the current scene on the canvas
- An **entity** is anything that can be drawn on the screen such as the player or a rock 

There are a few other classes that provide utility to the app such as animation or managing a group of entities. 

##GDX Terms

- **DeltaTime:** provided to update, represents the amount of time since the previous frame was rendered
- **SpriteBatch** I group of textures that can will be drawn on the canvas
- **Texture:** an image that can be drawn on the scren

##The Game Loop

The game loop consists of 3 phases

- **Update:** given a delta time update the state of the game
- **Clear:** removes everything from the canvas to prepare for the next frame
- **Render:** now that there is an updated state


##UML 

![UML](Screen Shot 2019-05-02 at 2.14.57 PM.png)

This does not show the specific scenes of the game. The all inherit from scene and just serve to create the building blocks that are diagram. 


#Acknowledgements

I would like to thank ansimuz (ansimuz.itch.io) & bakudas (bakudas.itch.io) for providing assets for me to use under creative commons. 



