package by.vlad.view;

public class View {

	public static void print(Object obj) {
		System.out.println(obj);
	}
	
	public static void print(Object...objects) {
		for(Object obj : objects) {
			System.out.println(obj);
		}
	}
}
