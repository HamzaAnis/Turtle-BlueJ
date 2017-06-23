
import java.awt.Color;
import java.util.Random;

public class RainbowTurtleDecorator extends TurtleDecorator {

    public static Random rng;

    public RainbowTurtleDecorator(Turtle turtle) {
        super(turtle);
    }

    @Override
    public void move(double dist) {
        Color clr = new Color(rng.nextInt(255));
        super.setColor(clr);
        super.move(dist);
    }
}
