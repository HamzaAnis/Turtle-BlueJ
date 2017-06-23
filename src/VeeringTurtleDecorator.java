
public class VeeringTurtleDecorator extends TurtleDecorator {

    private double veer;

    public VeeringTurtleDecorator(Turtle turtle) {
        super(turtle);
        veer = 3.0;
    }

    public VeeringTurtleDecorator(Turtle turtle, double veer) {
        super(turtle);
        this.veer = veer;
    }

    @Override
    public void move(double dist) {
        super.turn(veer);
        super.move(veer);
    }
}
