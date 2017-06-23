 

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.*;

public class LSystemDemo extends JPanel {

    private static final int SIZE = 800;
    private BufferedImage img; // Image to render the graphics in

    public LSystemDemo() {
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.img = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_BGR);
        for(int x = 0; x < SIZE; x++) {
            for(int y = 0; y < SIZE; y++) {
                img.setRGB(x, y, Color.WHITE.getRGB());
            }
        }

        // Dragon curve
        Map<Character, String> dragonRules = new HashMap<Character, String>();
        dragonRules.put('X', "X+Y>");
        dragonRules.put('Y', ">X-Y");
        final Turtle t = new CurveTurtle();
        t.setPosition(100, 130);
        t.setHeading(0);
        Graphics2D g2 = (Graphics2D)img.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON); // looks nicer
        t.setGraphics2D(g2);
        t.setStroke(new BasicStroke(1.5f));
        t.setColor(Color.BLACK);
        new LSystem(t, 10, 90).execute(dragonRules, ">X", 9);

        // Fractal plant
        Map<Character, String> plantRules = new HashMap<Character, String>();
        plantRules.put('X', ">-[[X]+X]+>[+>X]-X)");
        plantRules.put('>', ">>");
        t.setPosition(500, 300);
        t.setHeading(-75);
        new LSystem(t, 1.3, 25).execute(plantRules, ">X", 6);

        // Hilbert curve (the most famous space-filling curve)
        Map<Character, String> hilbertRules = new HashMap<Character, String>();
        hilbertRules.put('L', "+R>-L>L->R+");
        hilbertRules.put('R', "-L>+R>R+>L-");
        t.setPosition(430, 400);
        t.setHeading(0);
        new LSystem(t, 5, 90).execute(hilbertRules, "L", 6);
        
        // Sierpinski triangle (see http://www.oftenpaper.net/sierpinski.htm )
        Map<Character, String> sierpinskiRules = new HashMap<Character, String>();
        sierpinskiRules.put('A', "B-A-B");
        sierpinskiRules.put('B', "A+B+A");
        t.setPosition(30, 700);
        t.setHeading(0);
        class SierpinskiSystem extends LSystem {
            public SierpinskiSystem(Turtle turtle, double stepSize, double turnAngle) {
                super(turtle, stepSize, turnAngle); // call superclass constructor
            }
            // Override handleChar so that at the bottom, both A and B mean "move"
            @Override public void handleChar(char c, int depth) {
                if(depth == 0 && (c == 'A' || c == 'B')) {
                    turtle.move(stepSize); 
                }
                else {
                    super.handleChar(c, depth);
                }
            }
        };
        new SierpinskiSystem(t, 2.5, 60).execute(sierpinskiRules, "A", 7);
    }

    @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Lindenmayer system demo with some classic fractals");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new FlowLayout());
        f.add(new LSystemDemo());
        f.pack();
        f.setVisible(true);        
    }    
}