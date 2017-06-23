
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hamza
 */
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

}
