
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * A very basic turtle that does nothing fancy, but simply moves exactly how it
 * is told and draws a solid line.
 *
 * @author Ilkka Kokkarinen
 */
public class BasicTurtle extends AbstractTurtle {

    /**
     * The {@code BasicTurtle} moves exactly as it is told, calculating the new
     * coordinates with trigonometry.
     *
     * @param dist The distance to move forward to the current heading.
     */
    @Override
    public void move(double dist) {
        double a = Math.toRadians(getHeading());
        double x = getX();
        double y = getY();
        double x2 = x + dist * Math.cos(a);
        double y2 = y + dist * Math.sin(a);
        if (getPen()) {
            Graphics2D g2 = getGraphics2D();
            g2.setPaint(getColor());
            g2.setStroke(getStroke());
            g2.draw(new Line2D.Double(x, y, x2, y2));
        }
        setPosition(x2, y2);
    }

    @Override
    public String toString() {
        return "BasicTurtle";
    }
}
