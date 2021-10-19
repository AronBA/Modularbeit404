import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Panel extends JPanel {

    private Bird bird;
    private ArrayList<Rectangle> rects;
    private Game fb;
    private Font scoreFont, pauseFont;
    public static final Color bg = new Color(44, 203, 67);
    public static final int PIPE_W = 50, PIPE_H = 30;



    public Panel(Game fb, Bird bird, ArrayList<Rectangle> rects) {
        this.fb = fb;
        this.bird = bird;
        this.rects = rects;
        scoreFont = new Font("Arial", Font.BOLD, 18);
        pauseFont = new Font("Arial", Font.BOLD, 48);


    }
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(bg);
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        bird.update(g);
        g.setColor(Color.RED);
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
            g2d.drawRect(-PIPE_W/2, PIPE_H/2, Panel.PIPE_W, r.height);
            g2d.setTransform(old);
        }
        g.setFont(scoreFont);
        g.setColor(Color.BLACK);
        g.drawString("Score: "+fb.getScore(), 10, 20);

        if(fb.paused()) {
            g.setFont(pauseFont);
            g.setColor(new Color(0,0,0,170));
            g.drawString("Crappy Bird", Game.WIDTH/2-100, Game.HEIGHT/2-100);
            g.drawString("PRESS SPACE TO BEGIN", Game.WIDTH/2-300, Game.HEIGHT/2+50);
        }
    }
}