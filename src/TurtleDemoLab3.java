 

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.geom.*;

public class TurtleDemoLab3   {

    private static final int SIZE = 400;
    
    private static class TurtleSpiral extends JPanel {
        
        private BufferedImage img = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
        private Turtle turtle;
        
        public TurtleSpiral(Color bkg, Turtle turtle) {
            this.setPreferredSize(new Dimension(SIZE, SIZE));
            this.setBorder(BorderFactory.createTitledBorder(turtle.toString()));
            
            this.turtle = turtle;
            turtle.setGraphics2D((Graphics2D)img.getGraphics());
            turtle.setPosition(SIZE / 10, SIZE / 7);
            turtle.setHeading(-5);
            Graphics2D g2 = (Graphics2D)img.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON); // looks nicer
            turtle.setGraphics2D(g2);
            g2.setColor(bkg);
            g2.fill(new Rectangle2D.Double(0, 0, SIZE, SIZE));
            renderSpiral(turtle, 3 * SIZE / 4);
        }
        
        private void renderSpiral(Turtle t, int n) {
            while(n > 10) {
                t.move(n);
                t.turn(90);
                t.move(n);
                t.turn(90);
                n = n - 25;
            }
        }
        
        @Override public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, this);
        }
    }
    
    // The array of turtles to demonstrate in the JFrame window.
    private static Turtle[] turtles = {
        new DottedTurtle(8, 6),
        new HandDrawnTurtle(),
        new ShakyTurtle(new CurveTurtle(), 0.05),
        new AntennaTurtle(new BasicTurtle(), 20),
        new ZagTurtle(new HandDrawnTurtle(), 5, 30),
        new AntennaTurtle(new ZagTurtle(new ShakyTurtle(new BasicTurtle(), .02), 10, 10), 15)
    };
    
    private static Color[] colors = {
        Color.RED, Color.BLUE, Color.GREEN, 
        new Color(200, 60, 200), new Color(170, 80, 100),
        new Color(30, 210, 108)
    };
    
    public static void main(String[] args) {
        JFrame f = new JFrame("Turtle demo");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new GridLayout(2, turtles.length / 2 + turtles.length % 2));
        
        for(int i = 0; i < turtles.length; i++) {
            turtles[i].setStroke(new BasicStroke(5.0f));
            turtles[i].setColor(colors[i % colors.length]);
            f.add(new TurtleSpiral(i % 2 == 0 ? Color.WHITE : new Color(220, 220, 220)
                , turtles[i]));
        }
        
        f.pack();
        f.setVisible(true);        
    }    
}