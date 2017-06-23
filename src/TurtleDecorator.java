
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.*;

/**
 * A utility class to help write decorator subtypes of {@code Turtle}.
 * Implements the logic of having underlying turtle and redirects all method
 * calls to it. Subclasses of this class {@code TurtleDecorator} should override
 * the appropriate methods to perform whatever additional computations to do,
 * and call the superclass version of that method. The underlying turtle can
 * also be accessed directly through the {@code protected} field {@code turtle},
 * should the subclass methods need that.
 *
 * @author Ilkka Kokkarinen
 */
public abstract class TurtleDecorator implements Turtle {

    /**
     * The underlying object of this decorator.
     */
    private Turtle turtle;

    /**
     * Accessor method to get the underlying turtle of this decorator.
     *
     * @return The underlying turtle of this decorator.
     */
    public Turtle getTurtle() {
        return this.turtle;
    }

    /**
     * The constructor to place the decorator in front of the underlying turtle.
     *
     * @param turtle The underlying turtle that is being decorated.
     */
    public TurtleDecorator(Turtle turtle) {
        this.turtle = turtle;
    }

    /**
     * Slightly against the spirit of decorators, we allow the underlying turtle
     * to be changed later.
     *
     * @param turtle The new underlying turtle that is being decorated.
     */
    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    // In any decorator, the methods are overridden to call the method of
    // the underlying object, and possibly do something extra before and after.
    // Providing this class as convenience allows the subclasses to override
    // only the methods that do something extra.
    /**
     * Set the {@code Graphics2D} object that the underlying turtle draws on.
     *
     * @param g The {@code Graphics2D} object that the underlying turtle draws
     * on.
     */
    @Override
    public void setGraphics2D(Graphics2D g2) {
        turtle.setGraphics2D(g2);
    }

    /**
     * Get the {@code Graphics2D} object that the underlying turtle draws on.
     *
     * @return The {@code Graphics2D} object that the underlying turtle draws
     * on.
     */
    @Override
    public Graphics2D getGraphics2D() {
        return turtle.getGraphics2D();
    }

    /**
     * Set the absolute position of the underlying turtle.
     *
     * @param x The x-coordinate of the absolute position.
     * @param y The y-coordinate of the absolute position.
     */
    @Override
    public void setPosition(double x, double y) {
        turtle.setPosition(x, y);
    }

    /**
     * Set the absolute heading of the underlying turtle.
     *
     * @param angle The absolute heading angle of the turtle, expressed in
     * degrees with 0 pointing right and 90 pointing up.
     */
    @Override
    public void setHeading(double angle) {
        turtle.setHeading(angle);
    }

    /**
     * Get the x-coordinate of the absolute position of the underlying turtle.
     *
     * @return The x-coordinate of the absolute position of the underlying
     * turtle.
     */
    @Override
    public double getX() {
        return turtle.getX();
    }

    /**
     * Get the y-coordinate of the absolute position of the underlying turtle.
     *
     * @return The y-coordinate of the absolute position of the underlying
     * turtle.
     */
    @Override
    public double getY() {
        return turtle.getY();
    }

    /**
     * Get the absolute heading of the underlying turtle.
     *
     * @return The absolute heading of the absolute position of the underlying
     * turtle.
     */
    @Override
    public double getHeading() {
        return turtle.getHeading();
    }

    /**
     * Set the state of the pen. When the pen is down, the turtle leaves some
     * kind of drawing behind its movement, and when the pen is up, the turtle
     * moves without drawing anything.
     *
     * @param down Whether the pen is currently down.
     */
    @Override
    public void setPen(boolean up) {
        turtle.setPen(up);
    }

    /**
     * Get the current state of the pen. When the pen is down, the turtle leaves
     * some kind of drawing behind its movement, and when the pen, is up the
     * turtle moves without drawing anything.
     *
     * @return Whether the pen is currently down.
     */
    public boolean getPen() {
        return turtle.getPen();
    }

    /**
     * Set the current drawing color to use in drawing when the pen is down.
     *
     * @param color The current drawing color to use.
     */
    @Override
    public void setColor(Color color) {
        turtle.setColor(color);
    }

    /**
     * Get the current drawing color to use in drawing when the pen is down.
     *
     * @return The current drawing color to use.
     */
    @Override
    public Color getColor() {
        return turtle.getColor();
    }

    /**
     * Set the current stroke to be used in drawing when the pen is down.
     *
     * @param stroke The current stroke to use in drawing.
     */
    @Override
    public void setStroke(Stroke stroke) {
        turtle.setStroke(stroke);
    }

    /**
     * Get the current stroke to be used in drawing when the pen is down.
     *
     * @return The current stroke to use in drawing.
     */
    @Override
    public Stroke getStroke() {
        return turtle.getStroke();
    }

    /**
     * Move the underlying turtle forward the given distance.
     *
     * @param dist The distance to move forward.
     */
    @Override
    public void move(double dist) {
        turtle.move(dist);
    }

    /**
     * Turn the underlying turtle in place the given angle, measured in degrees.
     * Positive angle turns the turtle left, while a negative angle turns it
     * right.
     *
     * @param turnAngle The angle to turn.
     */
    @Override
    public void turn(double turnAngle) {
        turtle.turn(turnAngle);
    }

    @Override
    public void drawEgg(Graphics2D g2, double x, double y, double diameter) {
        g2.fill(new Ellipse2D.Double(x, y, diameter - diameter / 3, diameter));
    }

}
