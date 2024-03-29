# TurtleCoder
A basic turtle program, reads in instructions from a file.

# How to use
## Download and installation
Download the file from the Releases section of the page, extract everything from the zip file into its own folder. To run the program, double click the Turtle.jar file.
## Creating a .trtl file
The turtle reads instructions from .trtl files. Open a text editor, create a new file and the save as FILENAME.trtl inside the /instr/ folder. Note: on Windows, you will need to put the filename in quotes to have it save as a trtl extension.
## Coding the turtle
To create a program for your turtle, you can use the instructions in the list below to make it behave how you want. Each instruction should be on its own line with a space between each parameter. Comments can be added to your code by starting a line with `#`.
## Running your program
To run your .trtl file, double click the Turtle.jar file and select the file you want to run. If there is a problem with your program code, you will see a popup message to tell you. You will need to fix the error in your code before it will run.


## Instruction set
- `MOVE x` - Moves the turtle forward in its current direction by x pixels. The turtle starts facing to the right.
- `TURN x` - Rotates the turtle x degrees clockwise. X must be a multiple of 90.
- `MVTO x y` - Moves the turtle to those coordinates (minimum value of zero, maximum value of 800)
- `SPED x` - Changes the speed of the turtle to x pixels per update , equivalent to 60 * x pixels per second
- `TPEN b` - Toggles whether the turtle's pen is down (drawing a line behind it) or not. B should be a boolean of values `true` or `false`
- `COLR r g b` - Sets the pen colour to the RGB colour set in the parameter
- `# ...` - Turns the line into a comment. The parser will ignore the rest of the line
