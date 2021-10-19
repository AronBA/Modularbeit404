import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Panel extends JPanel {

    private final Bird bird;
    private final ArrayList<Rectangle> rects;
    private final Game fb;
    private final Font scoreFont;
    public static final Color bg = new Color(31, 66, 210);
    public static final int PIPE_W = 50, PIPE_H = 30;



    public Panel(Game fb, Bird bird, ArrayList<Rectangle> rects) {
        this.fb = fb;
        this.bird = bird;
        this.rects = rects;
        scoreFont = new Font("Arial", Font.BOLD, 18);


    }
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(bg);
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        bird.update(g);
        for(Rectangle r : rects) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GREEN);
            g2d.fillRect(r.x, r.y, r.width, r.height);
            AffineTransform old = g2d.getTransform();
            g2d.translate(r.x+PIPE_W/2, r.y+PIPE_H/2);
            if(r.y < Game.HEIGHT/2) {
                g2d.translate(0, r.height);
                g2d.rotate(Math.PI);
            }
            //g2d.drawRect(-PIPE_W/2, PIPE_H/2, Panel.PIPE_W, r.height);
            g2d.setTransform(old);
        }
        g.setFont(scoreFont);
        g.setColor(Color.BLACK);
        g.drawString("Score: "+fb.getScore(), 10, 20);


    }
}