
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * A utility implementation of the Turtle interface to provide a reasonable
 * implementation for all other methods than {@code move} so that the
 * implementors of subclasses don't need to define these methods unless they
 * want to.
 *
 * @author Ilkka Kokkarinen
 */
public abstract class AbstractTurtle implements Turtle, Cloneable {

    /**
     * The {@code Graphics2D} object that the turtle draws on.
     */
    Graphics2D g2;
    /**
     * The x-coordinate of the current position of the turtle.
     */
    private double x;
    /**
     * The y-coordinate of the current position of the turtle.
     */
    private double y;
    /**
     * The current absolute heading of the turtle.
     */
    private double heading;
    /**
     * The current state of the turtle pen.
     */
    private boolean down = true;
    /**
     * The current drawing colour of this turtle.
     */
    private Color color = Color.WHITE;
    /**
     * The current stroke used by this turtle for drawing.
     */
    private Stroke stroke = new BasicStroke(3.0f);

    /**
     * Set the {@code Graphics2D} object that this turtle draws on.
     *
     * @param g The {@code Graphics2D} object that this turtle draws on.
     */
    @Override
    public void setGraphics2D(Graphics2D g2) {
        this.g2 = g2;
    }

    /**
     * Get the {@code Graphics2D} object that this turtle draws on.
     *
     * @return The {@code Graphics2D} object that this turtle draws on.
     */
    @Override
    public Graphics2D getGraphics2D() {
        return this.g2;
    }

    /**
     * Set the absolute position of the turtle. The spirit of turtle graphics is
     * to call this method only once in the beginning, after which you only use
     * the relative motion operations.
     *
     * @param x The x-coordinate of the absolute position.
     * @param y The y-coordinate of the absolute position.
     */
    @Override
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Set the absolute heading of the turtle. The spirit of turtle graphics is
     * to call this method only once in the beginning, after which you only use
     * the relative motion operations.
     *
     * @param angle The absolute heading angle of the turtle, expressed in
     * degrees with 0 pointing right and 90 pointing up.
     */
    @Override
    public void setHeading(double angle) {
        this.heading = angle;
    }

    /**
     * Set the current drawing color to use in drawing when the pen is down.
     *
     * @param color The current drawing color to use.
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Get the current drawing color to use in drawing when the pen is down.
     *
     * @return The current drawing color to use.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Set the current stroke to be used in drawing when the pen is down.
     *
     * @param stroke The current stroke to use in drawing.
     */
    @Override
    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    /**
     * Get the current stroke to be used in drawing when the pen is down.
     *
     * @return The current stroke to use in drawing.
     */
    public Stroke getStroke() {
        return this.stroke;
    }

    /**
     * Get the x-coordinate of the absolute position of the turtle.
     *
     * @return The x-coordinate of the absolute position of the turtle.
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Get the y-coordinate of the absolute position of the turtle.
     *
     * @return The y-coordinate of the absolute position of the turtle.
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Get the absolute heading of the turtle.
     *
     * @return The absolute heading of the turtle.
     */
    @Override
    public double getHeading() {
        return heading;
    }

    /**
     * Set the state of the pen. When the pen is down, the turtle leaves some
     * kind of drawing behind its movement, and when the pen is up, the turtle
     * moves without drawing anything.
     *
     * @param down Whether the pen is currently down.
     */
    @Override
    public void setPen(boolean down) {
        this.down = down;
    }

    /**
     * Get the current state of the pen. When the pen is down, the turtle leaves
     * some kind of drawing behind its movement, and when the pen, is up the
     * turtle moves without drawing anything.
     *
     * @return Whether the pen is currently down.
     */
    @Override
    public boolean getPen() {
        return this.down;
    }

    /**
     * Turn the turtle in place the given angle, measured in degrees. Positive
     * angle turns the turtle left, while a negative angle turns it right.
     *
     * @param turnAngle The angle to turn.
     */
    @Override
    public void turn(double turnAngle) {
        heading += turnAngle;
        while (heading > 360) {
            heading -= 360;
        }
        while (heading < 0) {
            heading += 360;
        }
    }

    /**
     * Create an identical clone of this turtle, if the operation is supported.
     */
    @Override
    public Turtle clone() throws CloneNotSupportedException {
        return (Turtle) super.clone();
    }

    @Override
    public void drawEgg(Graphics2D g2, double x, double y, double diameter) {
        g2.fill(new Ellipse2D.Double(x, y, diameter - diameter / 3, diameter));
    }

}
