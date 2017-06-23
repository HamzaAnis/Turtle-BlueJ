
public class VeeringTurtle extends BasicTurtle {
    
    double veer;
    
    public VeeringTurtle() {
        super();
        veer = 3.0;
    }
    
    public VeeringTurtle(double veer) {
        super();
        this.veer = veer;
    }
    
    @Override
    public void move(double dist) {
        super.turn(veer);
        super.move(dist);
    }
    
}
