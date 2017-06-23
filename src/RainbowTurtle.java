
import java.awt.Color;
import java.util.Random;

public class RainbowTurtle extends BasicTurtle {

    public static Random rng;

    public RainbowTurtle() {
        super();
        rng = new Random();
    }

    @Override
    public void move(double dist) {
        Color clr = new Color(rng.nextInt(255));
        super.setColor(clr);
        super.move(dist);
    }

}
