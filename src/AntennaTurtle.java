 

import java.awt.Graphics2D;
import java.util.*;

/**
 * Another "fractalizing" decorator for turtles, this one creating
 * a self-similar pattern of antennas.
 * @author Ilkka Kokkarinen
 */

public class AntennaTurtle extends TurtleDecorator {
        
    private double cutoff;
    
    /**
     * Decorate the underlying turtle to create an antenna pattern.
     * @param turtle The underlying turtle to decorate.
     * @param cutoff The threshold for motion length to fractalize into an antenna.
     */
    public AntennaTurtle(Turtle turtle, double cutoff) {
        super(turtle);
        this.cutoff = cutoff;
    }
       
    /**
     * The antenna motion is implemented by a couple of turns and moves, ending
     * the turtle with the same position and heading as if the move had been done
     * directly as given.
     * @param dist The distance to move forward to the current heading.
     */
    @Override public void move(double dist) {
        if(dist < cutoff) { getTurtle().move(dist); }
        else {
            double half = dist / 2;
            move(half);
            turn(-90);
            move(half/4);
            turn(180);
            move(half/4);
            turn(-90);
            move(half);
        }
    }
    
    @Override public String toString() {
        return "AntennaTurtle(" + getTurtle().toString() + ")";
    }

    @Override
    public void drawEgg(Graphics2D g2, double x, double y, double diameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
   