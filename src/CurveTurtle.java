 

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * An implementation of Turtle that remembers the last three points that it
 * has visited, and draws a Bezier curve through them. Smooth and suitable
 * for rendering fractals as L-systems, as the corners become more obvious.
 * @author Ilkka Kokkarinen
 */

public class CurveTurtle extends AbstractTurtle {
    
    private boolean odd = true;
    private double px = getX(); // previous position
    private double py = getY();
    private double ppx = px; // previous previous position
    private double ppy = py;
    
    /**
     * Set the absolute position of the turtle. Setting the position
     * cancels the memory of the previous positions.
     * @param x The x-coordinate of the absolute position.
     * @param y The y-coordinate of the absolute position.
     */
    @Override public void setPosition(double nx, double ny) {
        super.setPosition(nx, ny);
        ppx = px = nx;
        ppy = py = ny;
    }
    
    /**
     * Move the turtle forward the given distance. A curve is drawn only when the
     * number of moves is odd, as a cubic curve connecting the current position and
     * the position two steps ago, using the previous position as control point.
     * @param dist The distance to move forward.
     */
    @Override public void move(double dist) {
        double a = Math.toRadians(getHeading());
        ppx = px; ppy = py;
        px = getX(); py = getY();
        double x = getX() + dist * Math.cos(a); 
        double y = getY() + dist * Math.sin(a);
        if(!odd) {
            if(getPen()) {
                Graphics2D g2 = getGraphics2D();
                g2.setPaint(getColor());
                g2.setStroke(getStroke());
                g2.draw(new CubicCurve2D.Double(ppx, ppy, px, py, px, py, x, y));
            }
        }
        odd = !odd;
        super.setPosition(x, y);
    }

    @Override public String toString() {
        return "CurveTurtle";
    }
}