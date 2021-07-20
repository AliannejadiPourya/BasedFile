import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class musicStuff {// this class is responsible for playing music of your own choice :D

    void playMusic(String musicLocation, boolean stop) {

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);//the song will not stop until the game is closed

                if (stop) {
                    clip.stop();
                }
            } else {
                System.out.println("Can't find file");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
