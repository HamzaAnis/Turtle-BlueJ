
public class VeeringTurtleDecorator extends TurtleDecorator {

    private double veer;

    public VeeringTurtleDecorator() {
        veer = 3.0;
    }

    public VeeringTurtleDecorator(double veer) {
        this.veer = veer;
    }

    @Override
    public void move(double dist) {
        super.move(veer);
    }
}
