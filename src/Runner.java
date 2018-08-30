
import java.util.HashMap;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;

public class Runner {

	public static void main(String[] args) throws LineUnavailableException {

		HashMap<String, String> map = new HashMap<>();
		
		for (Letters l : Letters.values()) {
			map.put(l.getMorse(), l.toString());
		}
		
		//System.out.println(map);
		
		String morseCode;
		String[] inputWord;
		String[] inputLetter;
		String[] current;
		
		
		morseCode = ".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--";
		
		inputWord = morseCode.split(" / ");
		for (String i : inputWord) {
			inputLetter = i.split(" ");

			for (String j : inputLetter) {
			
				System.out.print(map.get(j).toUpperCase());
				
			}
			
			System.out.print(" ");
		}
		
		////////////////////////////////////////////////////////////////////
		
		System.out.println();
		
		HashMap<String, String> negaMap = new HashMap<>();
		
		for (Letters l : Letters.values()) {
			negaMap.put(l.toString(), l.getMorse());
		}
		
		
		Scanner msg = new Scanner(System.in);
		String message = msg.nextLine();
		
		inputWord = message.split(" ");
		
		for (String i : inputWord) {
			inputLetter = i.split("");

			for (String j : inputLetter) {
				
				System.out.print(negaMap.get(j));
				System.out.print(" ");
				current = negaMap.get(j).split("");
				
				for (String k : current) {
					MorsePlayer m = new MorsePlayer(k);
					m.play();
				}
				
				MorsePlayer n = new MorsePlayer(" ");
				n.play();
			}
			
			System.out.print("/ ");
		}
		
		msg.close();
		
	}

}
