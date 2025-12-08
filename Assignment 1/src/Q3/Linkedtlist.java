package Q3;


public class Linkedtlist {

	static class Node{
		private int data;
		private Node next;
		public Node(int value) {
			data=value;
			next=null;
		}
	}
	private Node head;
	
	
	public void display() {
		Node trav= head;
		while(trav!=null) {
			System.out.print(trav.data);
			System.out.println();
			trav= trav.next;
			
		}
	}
	

	
	public void insertSorted(int data) {
        Node newNode = new Node(data);

        // Case 1: Empty list OR insert at beginning
        if (head == null || data < head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node trav = head;

        // Traverse until correct position found
        while (trav.next != null && trav.next.data < data) {
            trav = trav.next;
        }

        // Insert between temp and temp.next
        newNode.next = trav.next;
        trav.next = newNode;
    }
	
}

