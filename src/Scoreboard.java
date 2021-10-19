import javax.swing.*;

public class Scoreboard extends JFrame{
    private JPanel mainPanel;
    private JList list1;

    public Scoreboard(String title){
        super(title);
        setSize(1600,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(mainPanel);
        pack();
        setVisible(true);

    }



}
