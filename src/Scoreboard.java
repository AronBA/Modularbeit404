import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Klasse für das Scoreboard
public class Scoreboard extends JFrame{
    private JPanel mainPanel;
    private JLabel scorelabel;
    private JLabel numberlabel;
    private JButton backbutton;

    public Scoreboard(String title){
        super(title);
        setIconImage(Game.icon.getImage());
        setSize(Game.width,Game.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        String s = String.valueOf(Game.highscore);
        numberlabel.setText(s);

        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame frame = new Menu("Crappy Bird");
                frame.setVisible(true);
            }
        });
    }
}
