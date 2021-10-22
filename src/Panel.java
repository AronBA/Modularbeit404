import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Panel extends JPanel {

    private final Bird bird;
    private final ArrayList<Rectangle> rects;
    private final Game fb;
    private final Font fontscore, fontpause, fontover;
    public static Color bg;
    public static Color pipescolor;
    public static final int pipeW = 50, pipeH = 30;
    public static String gameover, score, returnback;



    public Panel(Game fb, Bird bird, ArrayList<Rectangle> rects) {
        this.fb = fb;
        this.bird = bird;
        this.rects = rects;
        fontscore = new Font("Arial", Font.BOLD, 18);
        fontpause = new Font("Arial", Font.BOLD, 30);
        fontover = new Font("Arial", Font.BOLD, 72);

    }
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(bg);
        g.fillRect(0,0, Game.width, Game.height);
        bird.player(g);
        for(Rectangle r : rects) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(pipescolor);
            g2d.fillRect(r.x, r.y, r.width, r.height);
            AffineTransform old = g2d.getTransform();
            g2d.translate(r.x+ pipeW /2, r.y+ pipeH /2);
            if(r.y < Game.height /2) {
                g2d.translate(0, r.height);
                g2d.rotate(Math.PI);
            }
            g2d.setTransform(old);
        }
        g.setFont(fontscore);
        g.setColor(Color.BLACK);
        g.drawString("Score: "+fb.getScore(), 10, 20);

        gameover = "GAME OVER";
        score = "Your Score was: " + fb.getScore();
        returnback = "PRESS SPACE TO RETURN";

        if(fb.paused()) {
            bg = new Color(65, 75, 141);
            pipescolor = new Color(24, 122, 42);
            g.setFont(fontover);
            g.setColor(Color.RED);
            g.drawString(gameover, Game.width /2-220, Game.height /2-100);
            g.setFont(fontpause);
            g.setColor(Color.BLACK);
            g.drawString(score, Game.width / 2-140, Game.height / 2);
            g.drawString(returnback, Game.width /2-200, Game.height /2+50);
        }
    }
}