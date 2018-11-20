package maps;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueCharacters {
	
	public static String uniqueChar(String str){
		HashMap<Character, Integer> map = new HashMap<>();
		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				answer += str.charAt(i);
				map.put(str.charAt(i), 1);
			} else {
				continue;
			}
		}
	
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String uniChars = uniqueChar(s.next());
		System.out.println(uniChars);
		s.close();
	}
}
