import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Panel extends JPanel {

    private final Bird bird;
    private final ArrayList<Rectangle> rects;
    private final Game fb;
    private final Font scoreFont, pauseFont, overFont;
    public static Color bg;
    public static Color Pipes;
    public static final int PIPE_W = 50, PIPE_H = 30;
    public static String gameOver, score, Return;



    public Panel(Game fb, Bird bird, ArrayList<Rectangle> rects) {
        this.fb = fb;
        this.bird = bird;
        this.rects = rects;
        scoreFont = new Font("Arial", Font.BOLD, 18);
        pauseFont = new Font("Arial", Font.BOLD, 30);
        overFont = new Font("Arial", Font.BOLD, 72);

    }
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(bg);
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        bird.update(g);
        for(Rectangle r : rects) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Pipes);
            g2d.fillRect(r.x, r.y, r.width, r.height);
            AffineTransform old = g2d.getTransform();
            g2d.translate(r.x+PIPE_W/2, r.y+PIPE_H/2);
            if(r.y < Game.HEIGHT/2) {
                g2d.translate(0, r.height);
                g2d.rotate(Math.PI);
            }
            g2d.setTransform(old);
        }
        g.setFont(scoreFont);
        g.setColor(Color.BLACK);
        g.drawString("Score: "+fb.getScore(), 10, 20);

        gameOver = "GAME OVER";
        score = "Your Score was: " + fb.getScore();
        Return = "PRESS SPACE TO RETURN";

        if(fb.paused()) {
            bg = new Color(65, 75, 141);
            Pipes = new Color(24, 122, 42);
            g.setFont(overFont);
            g.setColor(Color.RED);
            g.drawString(gameOver, Game.WIDTH/2-220, Game.HEIGHT/2-100);
            g.setFont(pauseFont);
            g.setColor(Color.BLACK);
            g.drawString(score, Game.WIDTH / 2-140, Game.HEIGHT / 2);
            g.drawString(Return, Game.WIDTH/2-200, Game.HEIGHT/2+50);
        }
    }
}