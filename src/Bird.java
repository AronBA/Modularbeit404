import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
//Klasse um den Bird zu erstellen
public class Bird extends JPanel {
    public int x, y, vx, vy;
    public static final int rad = 25;
    private Image img;
    public Bird(){
        x = Game.width /4;
        y = Game.height /4;
        try {
            img = ImageIO.read(new File("Flying-Airplane-PNG-Images-HD.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void movement() {
        x+=vx;
        y+=vy;
    }

    public void player(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawImage(img, Math.round(x-rad),Math.round(y-rad),5*rad,2*rad, null);
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