import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MorsePlayer {
	
	private int speed = 500;
	private char[] codeArray;
	
	public MorsePlayer() {
		
	}
	
	public MorsePlayer(String code) {
		this.codeArray = code.toCharArray();
	}
	
	public void play() throws LineUnavailableException {
		
		for (char c : codeArray) {
			if (c == '.') {
				sound(14400, speed);
			} else if (c == '-') {
				sound(14400, 3*speed);
			} else {
				sound(0, speed);
			}
			sound(0, speed);
		}
		
	}
	
	 public void setSpeed(int speed) {
	        if (speed > 25) {
	            throw new IllegalArgumentException("Speed too fast");
	        } else if (speed < 5) {
	            throw new IllegalArgumentException("Speed too slow");
	        }
	        this.speed = 1000 / speed;
	    }
	 
	 private void sound(int hz, int msecs) throws LineUnavailableException {
	        byte[] buf = new byte[msecs * 16];
	        for (int i = 0; i < buf.length; i++) {
	            double angle = i / (44100.0 / hz) * 2.0 * Math.PI;
	            buf[i] = (byte) (Math.sin(angle) * 127.0);
	        }
	        for (int i = 0; i < 80 && i < buf.length / 2; i++) {
	            buf[i] = (byte) (buf[i] * i / 80.0);
	            buf[buf.length - 1 - i] = (byte) (buf[buf.length - 1 - i] * i / 80.0);
	        }
	        AudioFormat af = new AudioFormat(44100f, 16, 1, true, false);
	        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
	        sdl.open(af);
	        sdl.start();
	        sdl.write(buf, 0, buf.length);
	        sdl.drain();
	        sdl.close();
	    }
	
	
}
