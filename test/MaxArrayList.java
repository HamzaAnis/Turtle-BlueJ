
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

    ArrayList<Double> data = new ArrayList<Double>();
    private double max;

    public double getMax() {
        if (data.isEmpty()) {
            return Double.NEGATIVE_INFINITY;
        } else {
            double max = Double.MIN_VALUE;
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i) > max) {
                    max = data.get(i);
                }
            }
            return max;
        }

    }

}
