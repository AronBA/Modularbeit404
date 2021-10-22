import javax.swing.*;
import java.awt.*;
//Klasse um den Bird zu erstellen
public class Bird extends JPanel {
    public int x, y, vx, vy;
    public static final int rad = 25;
    public Bird(){
        x = Game.width /4;
        y = Game.height /4;

    }
    public void movement() {
        x+=vx;
        y+=vy;
    }

    public void player(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(Math.round(x-rad),Math.round(y-rad),2*rad,2*rad);
    }

    public void up() {
        vy = -3;
    }

    public void down() {
        vy = +3;
    }

    public void reset() {
        x = Game.width /4;
        y = Game.height /4;
        vx = vy = 0;
    }
}