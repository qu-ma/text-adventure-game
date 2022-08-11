package com.monsters;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class PlayMusic{
  public void playMusic(String musicLocation){
    try{
      File musicpath = new File(musicLocation);

      if(musicpath.exists()){
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
      }else{
        System.out.println("Can't find file");
      }
    }catch (Exception ex){
      ex.printStackTrace();
    }
  }
}