import javax.swing.*;
import java.awt.*;

public class Bird extends JPanel {
    public int x, y, vx, vy;
    public static final int RAD = 25;
    public Bird(){
        x = Game.WIDTH/4;
        y = Game.HEIGHT/4;
    }
    public void physics() {
        x+=vx;
        y+=vy;
    }

    public void update(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(Math.round(x-RAD),Math.round(y-RAD),2*RAD,2*RAD);
    }

    public void up() {
        vy = -3;
    }

    public void down() {
        vy = +3;
    }

    public void reset() {
        x = Game.WIDTH/4;
        y = Game.HEIGHT/4;
        vx = vy = 0;
    }
}