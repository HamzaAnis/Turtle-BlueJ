 

import java.util.*;
import java.awt.geom.*;
import java.util.*;

// A class to compute a Lindenmayer System program given as set of rules,
// where each character is interpreted as an instruction for the turtle.
// Basically, a fractalizing facade for the Turtle class.

public class LSystem {

    protected double stepSize;
    protected double turnAngle;
    // The LSystem class doesn't concern itself with the actual rendering,
    // which is done with the Turtle given to it as a strategy object.
    // The LSystem just generates the instructions for the Turtle to draw.
    protected Turtle turtle;
    
    // The stack to store turtle positions with the [ and ] commands.
    protected Stack<Double> stack = new Stack<Double>();
    
    public LSystem(Turtle turtle, double stepSize, double turnAngle) {
        this.turtle = turtle;
        this.stepSize = stepSize;
        this.turnAngle = turnAngle;
    }
    
    // To simplify subclass definitions, we provide default constructor also.
    public LSystem() { }

    // Recursive execution of an L-system is pretty straightforward. Instead
    // of expanding the program string completely and then executing it in order,
    // we "expand" the program string locally with recursive calls as needed.
    // This saves time and memory in deep recursions.
    public void execute(Map<Character, String> rules, String program, int depth) {
        if(program == null || depth < 0) { return; }
        for(int i = 0; i < program.length(); i++) {
            char c = program.charAt(i);
            if(depth > 0 && rules.containsKey(c)) {
                execute(rules, rules.get(c), depth - 1);
            }
            else {
                handleChar(c, depth);
            }
        }
    }  

    // The characters that are treated as instructions for the Turtle.
    // A subclass may override this method to do something more special
    // or define additional commands to the turtle.
    public void handleChar(char c, int depth) {
        if(c == '>') { turtle.move(stepSize); }
        else if(c == '+') { turtle.turn(turnAngle); }
        else if(c == '-') { turtle.turn(-turnAngle); }
        else if(c == '[') { 
            stack.push(turtle.getX());
            stack.push(turtle.getY());
            stack.push(turtle.getHeading());
        }
        else if(c == ']') { 
            turtle.setHeading(stack.pop());
            double y = stack.pop();
            double x = stack.pop();
            turtle.setPosition(x, y);
        }    
    }
}