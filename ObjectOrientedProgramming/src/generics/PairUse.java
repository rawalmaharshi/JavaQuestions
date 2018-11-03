package generics;

public class PairUse {

	public static void main(String[] args) {
		
		Pair <String, String> p = new Pair <String, String> ("ab", "cd");
		p.setFirst("def");
		System.out.println(p.getFirst());

//		Pair <int, int> p1 = new Pair <int, int> (1,2); // Error. Cannot use primitive types 
		Pair <Integer, Integer> p1 = new Pair <Integer, Integer> (1,3);
		
		Pair <Character, Character> p2 = new Pair <> ('a', 'b'); //For newer versions of Java, you can use second <> without type
		
		int a = 10;
		int b = 20;
		int c = 30;
		
		Pair <Integer, Integer> internalPair = new Pair <> (a,b);
		Pair <Pair<Integer, Integer>, Integer> p3 = new Pair<> (internalPair, c);
		
		System.out.println("3-> " + p3.getSecond());
		System.out.println("1-> " + p3.getFirst().getFirst());
		System.out.println("2-> " + p3.getFirst().getSecond());
	}

}
