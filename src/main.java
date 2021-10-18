import javax.swing.*;

public class main {
    public static void Startscreen(){
        JFrame Frame = new JFrame("Crappy Bird");
        JButton Start = new JButton("Start");
        Frame.setSize(1500,700);
        Frame.add(Start);
        Frame.setVisible(true);

    }
    public static void main(String[] args) {
        Startscreen();
    }
}
