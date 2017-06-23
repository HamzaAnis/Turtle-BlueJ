
import java.awt.Graphics2D;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hamza
 */
public class EggDecoratorTurtle extends TurtleDecorator {
    
    private double prob;
    private double diameter;
    public static Random rng;
    
    public EggDecoratorTurtle(Turtle turtle, double prob, double diameter) {
        super(turtle);
        this.prob = prob;
        this.diameter = diameter;
    }
    
    @Override
    public void move(double dist) {
    }
    
    @Override
    public void drawEgg(Graphics2D g2, double x, double y, double diameter) {
        super.drawEgg(g2s, x, y, diameter);
    }
}
