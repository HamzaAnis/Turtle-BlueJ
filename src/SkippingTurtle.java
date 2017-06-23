
public class SkippingTurtle extends BasicTurtle {

    private int skip;
    private int moveCount = 0;

    public SkippingTurtle(int skip) {
        super();
        this.skip = skip;
        moveCount = 0;
    }

    @Override
    public void move(double dist) {
        moveCount++;
        if (moveCount % skip == 0) {
            super.setPen(!super.getPen());
            super.move(dist);
            super.setPen(!super.getPen());
        }
    }
}
