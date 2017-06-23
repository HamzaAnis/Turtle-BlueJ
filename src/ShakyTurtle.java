 

import java.util.*;

/**
 * A concrete decorator of Turtle that moves shakily so that the
 * distance and angle are changed a small random amount.
 * @author Ilkka Kokkarinen
 */

public class ShakyTurtle extends TurtleDecorator {
    
    private static Random rng = new Random();
    private double shakiness; 
    
    /**
     * Create a shaky version of the underlying turtle.
     * @param turtle The underlying turtle to decorate to be shaky.
     * @param shakiness The width of shakiness. 0.0 equals no shaking.
     */
    public ShakyTurtle(Turtle turtle, double shakiness) {
        super(turtle);
        this.shakiness = shakiness;
    }
   
    // Override only the methods where we actually do something now.
    
    private double shake(double v) {
        return v * (rng.nextDouble() * shakiness + (1 - shakiness / 2));
    }
    
    /**
     * Move the turtle forward by the shaken version of the given distance.
     * @param dist The distance to move forward.
     */
    @Override public void move(double dist) {
        getTurtle().move(shake(dist));
    }
    
    /**
     * Turn the turtle in place the shaken angle, measured in degrees. Positive
     * angle turns the turtle left, while a negative angle turns it right.
     * @param turnAngle The angle to turn.
     */
    @Override public void turn(double turnAngle) {
        getTurtle().turn(shake(turnAngle));
    }
    
    @Override public String toString() {
        return "ShakyTurtle(" + getTurtle().toString() + ")";
    }
}