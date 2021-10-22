import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Klasse für das Hauptmenu
public class Menu extends JFrame {
    private JPanel mainPanel;
    private JButton playButton;
    private JLabel title;
    private JButton exitButton;
    private JButton scoreboardButton;

    public Menu(String title){
        super(title);
        setIconImage(Game.icon.getImage());
        setSize(1600,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(mainPanel);
        pack();

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game().start();
                dispose();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        scoreboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Scoreboard("Scoreboard");
                dispose();
            }
        });
    }
}
