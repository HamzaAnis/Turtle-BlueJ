 

import java.util.*;

/**
 * A "fractalizing" turtle decorator that breaks each line into
 * recursive fractal parts to create a self-similar zagging pattern.
 * @author Ilkka Kokkarinen
 */

public class ZagTurtle extends TurtleDecorator {
        
    private double angle, cutoff;
    
    /**
     * To create a {@code ZagTurtle}, you need to provide the zagging angle
     * and the cutoff threshold when to stop subdividing the motion.
     * @param angle The angle of each individual zag.
     * @param cutoff Once the individual movement is shorter than this, no zagging is done.
     */
    public ZagTurtle(Turtle turtle, double angle, double cutoff) {
        super(turtle);
        this.angle = angle;
        this.cutoff = cutoff;
    }
       
    /**
     * The zagging motion is implemented by a couple of turns and moves, ending
     * the turtle with the same position and heading as if the move had been done
     * directly as given.
     * @param dist The distance to move forward to the current heading.
     */
    @Override public void move(double dist) {
        if(dist < cutoff) { getTurtle().move(dist); }
        else {
            double half = dist / 2;
            double off = Math.tan(Math.toRadians(angle)) * half;
            double hyp = Math.sqrt(half * half + off * off);
            turn(angle);
            move(hyp);
            turn(-(90 + angle));
            move(off);
            move(off); 
            turn(90 + angle);
            move(hyp);
            turn(-angle);
        }
    }
    
    @Override public String toString() {
        return "ZagTurtle(" + getTurtle().toString() + ")";
    }
}
   