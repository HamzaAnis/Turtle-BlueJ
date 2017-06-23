 

import java.util.*;
import java.awt.geom.*;
import java.awt.*;

/**
 * An implementation of Turtle that simulates a "hand drawn" look
 * for lines that it draws, using random overreach and wobbliness.
 * @author Ilkka Kokkarinen
 */

public class HandDrawnTurtle extends AbstractTurtle {
    private static Random rng = new Random();
    private static final double CWOBBLE = 0.15;
    private static final double EWOBBLE = 0.1;
    private static final double LENCUTOFF = 70;
    
    /**
     * Move the turtle to the current direction, drawing a curve to simulate
     * a hand drawn line if the pen is fown.
     */
    @Override public void move(double dist) {
        double a = Math.toRadians(getHeading());
        double x = getX();
        double y = getY();
        double x2 = x + dist * Math.cos(a);
        double y2 = y + dist * Math.sin(a);
        double len = Math.sqrt((x-x2)*(x-x2) + (y-y2)*(y-y2));
        double t = rng.nextDouble() * 0.08 + 0.42;
        if(len > LENCUTOFF) {
            move(t * dist);
            move((1-t) * dist);
            return;
        }
        double cx = (t*x + (1-t)*x2) + (rng.nextDouble() - 0.5) * CWOBBLE * len;
        double cy = (t*y + (1-t)*y2) + (rng.nextDouble() - 0.5) * CWOBBLE * len;
        double x0 = x + EWOBBLE * rng.nextDouble() * (x - cx);
        double y0 = y + EWOBBLE * rng.nextDouble() * (y - cy);
        double x3 = x2 + EWOBBLE * rng.nextDouble() * (x2 - cx);
        double y3 = y2 + EWOBBLE * rng.nextDouble() * (y2 - cy);
        if(getPen()) {
            Graphics2D g2 = getGraphics2D();
            g2.setPaint(getColor());
            g2.setStroke(getStroke());
            g2.draw(new CubicCurve2D.Double(x0, y0, cx, cy, cx, cy, x3, y3));
        }
        setPosition(x2, y2);
    }
    
    @Override public String toString() {
        return "HandDrawnTurtle";
    }
}