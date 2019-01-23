# TurtleCoder
A basic turtle program, reads in instructions from a file.

# Download
TODO: Add file download

# How to use

## Creating a .trtl file
The turtle reads instructions from .trtl files. Open a text editor, create a new file and the save as xxxx.trtl inside the instr folder. Note: on Windows, you will need to put the filename in quotes to have it save as a trtl extension.

## Instructions
- MOVE x - Moves the turtle forward in its current direction by x pixels. The turtle starts facing to the right.
- TURN x - Rotates the turtle x degrees clockwise. X must be a multiple of 90.
- SPED x - Changes the speed of the turtle to x pixels per update , equivalent to 60 * x pixels per second
- TPEN b - Toggles whether the turtle's pen is down (drawing a line behind it) or not. B should be a boolean of values TRUE/true/t/FALSE/false/f
- Prefix a line with # to make it into a comment