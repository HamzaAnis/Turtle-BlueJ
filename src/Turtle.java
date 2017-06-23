 

import java.awt.*;

/**
 * The superclass (interface) that defines the capabilities shared by every turtle.
 * The code that uses turtles as a facade to do drawing can just call these methods,
 * and different turtles will then respond to these methods in a different way.
 * @author Ilkka Kokkarinen
 */

public interface Turtle {
    
    /**
     * Set the {@code Graphics2D} object that this turtle draws on.
     * @param g The {@code Graphics2D} object that this turtle draws on.
     */
    public void setGraphics2D(Graphics2D g);
    
    /**
     * Get the {@code Graphics2D} object that this turtle draws on.
     * @return The {@code Graphics2D} object that this turtle draws on.
     */
    public Graphics2D getGraphics2D();
    
    /**
     * Set the absolute position of the turtle. The spirit of turtle graphics
     * is to call this method only once in the beginning, after which you only
     * use the relative motion operations.
     * @param x The x-coordinate of the absolute position.
     * @param y The y-coordinate of the absolute position.
     */
    public void setPosition(double x, double y);
    
    /**
     * Set the absolute heading of the turtle. The spirit of turtle graphics
     * is to call this method only once in the beginning, after which you only
     * use the relative motion operations.
     * @param angle The absolute heading angle of the turtle, expressed in degrees
     * with 0 pointing right and 90 pointing up.
     */
    public void setHeading(double angle);
    
    /**
     * Get the x-coordinate of the absolute position of the turtle.
     * @return The x-coordinate of the absolute position of the turtle.
     */
    public double getX();
    
    /**
     * Get the y-coordinate of the absolute position of the turtle.
     * @return The y-coordinate of the absolute position of the turtle.
     */
    public double getY();
    
    /**
     * Get the absolute heading of the turtle.
     * @return The absolute heading of the turtle.
     */
    public double getHeading();
    
    /**
     * Set the state of the pen. When the pen is down, the turtle leaves
     * some kind of drawing behind its movement, and when the pen is up,
     * the turtle moves without drawing anything.
     * @param down Whether the pen is currently down.
     */
    public void setPen(boolean down);
    
    /**
     * Get the current state of the pen. When the pen is down, the turtle
     * leaves some kind of drawing behind its movement, and when the pen,
     * is up the turtle moves without drawing anything.
     * @return Whether the pen is currently down.
     */
    public boolean getPen();
    
    /**
     * Set the current drawing color to use in drawing when the pen is down.
     * @param color The current drawing color to use.
     */
    public void setColor(Color color);
    
    /**
     * Get the current drawing color to use in drawing when the pen is down.
     * @return The current drawing color to use.
     */
    public Color getColor();
    
    /**
     * Set the current stroke to be used in drawing when the pen is down.
     * @param stroke The current stroke to use in drawing.
     */
    public void setStroke(Stroke stroke);
    
    /**
     * Get the current stroke to be used in drawing when the pen is down.
     * @return The current stroke to use in drawing.
     */
    public Stroke getStroke();
    
    /**
     * Move the turtle forward the given distance.
     * @param dist The distance to move forward.
     */
    public void move(double dist);
    
    /**
     * Turn the turtle in place the given angle, measured in degrees. Positive
     * angle turns the turtle left, while a negative angle turns it right.
     * @param turnAngle The angle to turn.
     */
    public void turn(double turnAngle);
    
    public void drawEgg(Graphics2D g2,double x,double y,double diameter);
    
}