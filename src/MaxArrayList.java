
import java.util.ArrayList;
import java.util.Collection;

public class MaxArrayList extends ArrayList<Double> {

    private double max;

    public double getMax() {
        if (super.isEmpty()) {
            return Double.NEGATIVE_INFINITY;
        } else {
            double max = Double.MIN_VALUE;
            for (int i = 0; i < super.size(); i++) {
                if (super.get(i) > max) {
                    max = super.get(i);
                }
            }
            return max;
        }

    }

    @Override
    public Double set(int idx, Double value) {
        super.set(idx, value);
        return super.set(idx, value);
    }

    @Override
    public void add(int index, Double element) {
        super.add(index, element); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Double x) {
        if (x > max) {
            max = x;
        }
        return super.add(x);
    }

    public boolean addAll(ArrayList<? extends Double> c) {
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) > max) {
                max = c.get(i);
            }
        }
        return super.addAll(c);
    }

    @Override
    public Double remove(int idx) {
        Double old = super.remove(idx);
        if (old == max) {
            updateMax();
        }
        return old;
    }

    @Override
    public boolean remove(Object x) {
        if (x.equals(max)) {
            super.remove(x);
            updateMax();
            return true;
        } else {
            return super.remove(x);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c
    ) {
        return super.removeAll(c);
    }

    public void updateMax() {
        for (int i = 0; i < super.size(); i++) {
            if (max < super.get(i)) {
                max = super.get(i);
            }
        }
    }
}
