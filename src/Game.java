import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.io.IOException;
import javax.sound.sampled.*;
//Klasse für das Spiel
public class Game implements ActionListener, KeyListener{

    public static final int fps = 60, width = 1600, height = 900;
    public static int highscore;
    private Bird bird;
    private JFrame frame;
    private JPanel panel;
    private ArrayList<Rectangle> pipes;
    private int time, scroll;
    public static ImageIcon icon = new ImageIcon("icon.png");

    private boolean paused;
//Funktion zum Starten des Spieles
    public void start() {

        frame = new JFrame("Crappy Bird");
        bird = new Bird();
        pipes = new ArrayList<>();
        panel = new Panel(this, bird, pipes);
        frame.add(panel);
        frame.setIconImage(icon.getImage());
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addKeyListener(this);
        Panel.bg = new Color(95, 105, 171);
        Panel.pipescolor = new Color(45, 197, 73);

        paused = false;

        Timer t = new Timer(500 / fps, this);
        t.start();
    }


    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        JFrame frame = new Menu("Crappy Bird");
        frame.setVisible(true);
        Backgroundmusic music = new Backgroundmusic();
        music.music();


    }
    //Funktion zur Generierung der Pipes
    public void actionPerformed(ActionEvent e) {

        panel.repaint();
        if(!paused) {
            bird.movement();
            if(scroll % 90 == 0) {
                int h1 = (int) ((Math.random()* height)/5 + (0.3*Math.random())* height); //Algorythmus zur Generierung der Höhe der Röhren
                int h2 = height /(3+time/2000);
                Rectangle r = new Rectangle(width, 0, Panel.pipeW, h1);
                Rectangle r2 = new Rectangle(width, h1+h2, Panel.pipeW, height -(h1+h2));
                pipes.add(r);
                pipes.add(r2);
            }
            ArrayList<Rectangle> toRemove = new ArrayList<>();
            boolean game = true;
            //Löschen der Pipes, beendigung des Spiels und Spiel fortschritt
            for(Rectangle r : pipes) {
                r.x-=3;
                if(r.x + r.width <= 0) {
                    toRemove.add(r);
                }
                if(r.contains(bird.x, bird.y)){
                    game = false;
                }
            }
            pipes.removeAll(toRemove);
            time++;
            scroll++;

            if(bird.y > height || bird.y+ Bird.rad < 0) {
                game = false;
            }

            if(!game) {
                if ((time/10) > highscore){
                    highscore = getScore();
                }
                paused = true;
            }
        }
    }

    @Override //Steuerung des Spielers
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            bird.up();
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            bird.down();
        }
        //Reset der Werte bei beendigung des Spiels
        else if(e.getKeyCode()==KeyEvent.VK_SPACE){
            if(paused) {
                frame.dispose();
                JFrame frame = new Menu("Crappy Bird");
                frame.setVisible(true);
                pipes.clear();
                bird.reset();
                time = 0;
                scroll = 0;
                paused = false;
            }
        }
    }

    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) {}
    public int getScore() {
        return Math.max(time / 10 - 40, 0);
    }
    public boolean paused() {
        return paused;
    }
}