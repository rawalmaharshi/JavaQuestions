package arrayList;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<>();
		System.out.println(list1.size());
		
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		System.out.println(list1.size());
		System.out.println(list1.get(2));
		
		list1.add(2, 40);
		System.out.println(list1.get(2));
		System.out.println(list1.get(3)); //The remaining elements shifts to the right..When 40 was added to pos 2, 30 got shifted
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		
		list1.remove(2);
		System.out.println();
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		
		System.out.println();
		for(int elem : list1) {
			System.out.print(elem + " ");
		}
		
		ArrayList<String> list2 = new ArrayList<String>() ;
		list2.add( "apple" );
		list2.add( "banana" );
		list2.add( "carrot" );
		list2.add( 0, "mango" );
		
		System.out.println();
		for(String elem : list2) {
			System.out.print(elem + " ");
		}
		
		ArrayList<String> list3 = new ArrayList<String>() ;
		list3.add( "Ant" );
		list3.add( "Bat" );
		list3.add( "Car" );
		list3.add( "Door" );
		list3.add( "Euro" );
		list3.set( 2, "Bus" );
		
		System.out.println();
		for(String elem : list3) {
			System.out.print(elem + " ");
		}
	}

}
