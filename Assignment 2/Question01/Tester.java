package Question01;

public class Tester {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst(40);
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		
		list.addLast(50);
		list.addLast(60);
		
		list.addPosition(70, 7);
		
//		list.deleteFirst();
		
//		list.deleteLast();
		
//		list.deletePosition(3);
		
//		list.deleteAll();
		
		list.display();
		System.out.println("List Size: " + list.size());
	}
}
