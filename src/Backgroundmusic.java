import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Backgroundmusic
{
    public void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        File file = new File("theme.wav");

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
}