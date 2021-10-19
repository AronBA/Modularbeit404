import javax.swing.*;
import java.awt.*;

public class Bird extends JPanel {
    public int x, y, vx, vy;
    public static final int RAD = 25;
    public Bird(){
        x = Game.WIDTH/4;
        y = Game.HEIGHT/2;
    }
    public void physics() {
        x+=vx;
        y+=vy;
    }

    public void update(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(Math.round(x-RAD),Math.round(y-RAD),2*RAD,2*RAD);
    }

    public void up() {
        vy = -8;
    }

    public void down() {
        vy = +8;
    }

    public void reset() {
        x = Game.WIDTH/4;
        y = Game.HEIGHT/2;
        vx = vy = 0;
    }
}