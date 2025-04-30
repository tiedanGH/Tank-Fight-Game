package main.util;

import javafx.scene.media.AudioClip;
import main.Director;

public class SoundEffect {

    public static void play(String src) {
    	if (Director.sound) {
	        AudioClip audioClip = new AudioClip(SoundEffect.class.getResource(src).toString());
	        audioClip.setVolume(0.05);
	        audioClip.play();
    	}
    }
}
