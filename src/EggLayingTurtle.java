
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
public class EggLayingTurtle extends BasicTurtle {
    
    private double prob;
    private double diameter;
    public static Random rng;
    
    public EggLayingTurtle(double prob, double diameter) {
        super();
        this.prob = prob;
        this.diameter = diameter;
    }
    
    @Override
    public void move(double dist) {
        super.move(dist);
        if (rng.nextDouble() < prob) {
            super.drawEgg(g2, dist, dist, diameter);
        }
    }
    
}
