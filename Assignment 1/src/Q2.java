import java.util.Scanner;

public class Q2 {
	
	public static void main(String[] args) {
		LinkedList ll= new LinkedList();
//		ll.addLast(20);
//		ll.addLast(30);
//		ll.addLast(40);
//		ll.addLast(50);
//		ll.addLast(60);
//		ll.addLast(70);
		
		System.out.print("LL is : ");
		ll.display();
		System.out.println("Where you want to add : ");
		Scanner sc = new Scanner(System.in);
		int ele=sc.nextInt();
		System.out.println("Enter 1 for Before the ele: ");
		System.out.println("Enter 2 for After the ele: ");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:{
			int pos=ll.getPos(ele);
		
			if(pos<1) {
				System.out.println("Element not found");
				break;
			}
			ll.addPosition(ele, pos);
			System.out.print(" Updated LL is : ");
			ll.display();
			
			break;
			
		}

		case 2:{
			int pos1=ll.getPos(ele);
			pos1= pos1+1;
			if(pos1<1) {
				System.out.println("Element not found");
				break;
			}
			ll.addPosition(ele, pos1);
			System.out.print(" Updated LL is : ");
			ll.display();
			break;
		}


		default:{
			System.out.println("Invalid i/p");
			break;	
		}

		}

	}
}


