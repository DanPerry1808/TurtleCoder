# TurtleCoder
A basic turtle program, reads in instructions from a file.

# Download
TODO: Add file download

# How to use

## Creating a .trtl file
The turtle reads instructions from .trtl files. Open a text editor, create a new file and the save as xxxx.trtl inside the instr folder. Note: on Windows, you will need to put the filename in quotes to have it save as a trtl extension.
## Starting your code
The first instruction in your .trtl file should be the VERS command, which the program checks to make sure there are no compatibility issues with your code if it is from an old version. For information about updating your old code for a new version, check [the wiki page](https://github.com/DanPerry1808/TurtleCoder/wiki/Compatibility-Version-Information)

**Current Compatibility Version = 3**

## Instruction set
- `VERS x` - Tells the parser which version of the program your code is written for
- `MOVE x` - Moves the turtle forward in its current direction by x pixels. The turtle starts facing to the right.
- `TURN x` - Rotates the turtle x degrees clockwise. X must be a multiple of 90.
- `MVTO x y` - Moves the turtle to those coordinates (minimum value of zero, maximum value of 800)
- `SPED x` - Changes the speed of the turtle to x pixels per update , equivalent to 60 * x pixels per second
- `TPEN b` - Toggles whether the turtle's pen is down (drawing a line behind it) or not. B should be a boolean of values TRUE/true/t/FALSE/false/f
- `# ...` - Turns the line into a comment. The parser will ignore the rest of the line
