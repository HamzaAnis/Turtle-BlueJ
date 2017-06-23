
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Another implementation of {@code Turtle} that draws a series of circles in
 * its wake.
 *
 * @author Ilkka Kokkarinen
 */
public class DottedTurtle extends AbstractTurtle {

    private double step, diam;

    /**
     * Constructor to determine the step size and the diameter of the circles
     * that the turtle draws behind it.
     *
     * @param step The step distance between the consecutive circles.
     * @param diam The diameter of each circle.
     */
    public DottedTurtle(double step, double diam) {
        this.step = step;
        this.diam = diam;
    }

    /**
     * Move forwards, drawing the circles along the line of movement.
     *
     * @param dist The distance to move forward.
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
            double s = Math.floor(dist / step);
            for (int i = 0; i < s; i++) {
                double cx = x + (i / s) * (x2 - x);
                double cy = y + (i / s) * (y2 - y);
                g2.fill(new Ellipse2D.Double(cx - diam / 2, cy - diam / 2, diam, diam));
            }
        }
        setPosition(x2, y2);
    }

    @Override
    public String toString() {
        return "DottedTurtle";
    }

    @Override
    public void drawEgg(Graphics2D g2, double x, double y, double diameter) {
        super.drawEgg(g2, x, y, diameter);
    }
}
