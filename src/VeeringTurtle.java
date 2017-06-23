
public class VeeringTurtle extends BasicTurtle {

    double veer;

    public VeeringTurtle() {
        veer = 3.0;
    }

    public VeeringTurtle(double veer) {
        this.veer = veer;
    }

    @Override
    public void move(double dist) {
        super.move(dist + veer);
    }

}
