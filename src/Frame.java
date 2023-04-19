///////////////////////////////////////////
//
//  Sid: 1955004
//
///////////////////////////////////////////
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(){
        //frame settings
        setTitle("Racing Karts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250,700);
        setResizable(false);
        setLocationRelativeTo(null);

        //Add Panel and start timer
        Panel animation = new Panel();
        animation.setBackground(Color.gray);
        animation.startAnimation();
        add(animation);

        //play background music of the game
        try{
            String audioFilePath="Sounds/background.wav";
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(getClass().getResource(audioFilePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        }catch(Exception e){
            System.out.println(e);
        } 
    }
}
