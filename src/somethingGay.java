import javax.swing.*;
import java.awt.*;

public class somethingGay extends JPanel{
    public static void Startscreen(){
        JPanel Startscreen = new JPanel();
        JLabel Title = new JLabel("Crappy Bird");
        JButton Start = new JButton("Start");
        JButton Scoreboard = new JButton("Scoreboard");
        JButton Exit = new JButton("Exit");
        Startscreen.setLayout(new BorderLayout(20, 30));
        Startscreen.add(Title, BorderLayout.NORTH);
        Startscreen.add(Scoreboard, BorderLayout.WEST);
        Startscreen.add(Start, BorderLayout.CENTER);
        Startscreen.add(Exit, BorderLayout.EAST);
        //Frame.add(Startscreen);
    }
    public static void main(String[] args) {
        JFrame Frame = new JFrame();
        Startscreen();

        Frame.setSize(1500,700);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
    }
}
