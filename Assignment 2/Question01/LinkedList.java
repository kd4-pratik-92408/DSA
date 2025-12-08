package Question01;

public class LinkedList {
	static class Node {
		private int data;
		private Node next;
		
		public Node(int value) {
			data = value;
			next = null;
		}
	}
	
	private Node tail;
	private int size;
	
	public LinkedList() {
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return tail == null;
	}
	
	public void display() {
		if (isEmpty()) {
			System.out.println("List is Empty.");
			return;
		}
		
		Node trav = tail.next;
		System.out.print("List: ");
		do {
			System.out.print(" " + trav.data);
			trav = trav.next;
		} while (trav != tail.next);
		System.out.println();
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			tail = newNode;
			tail.next = newNode;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
		size++;
	}
	
	public void addLast(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			tail = newNode;
			tail.next = newNode;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public void addPosition(int value, int position) {
		if (position < 1 || position > size + 1) {
			return;
		}
		Node newNode = new Node(value);
		if (isEmpty()) {
			tail = newNode;
			tail.next = newNode;
		} else if (position == 1) {
			newNode.next = tail.next;
			tail.next = newNode;
		} else if (position == size + 1) {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode;
		}else {
			Node trav = tail.next;
			for (int i = 1; i < position - 1; i++) {
				trav = trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
		}
		size++;
	}
	
	public void deleteFirst() {
		if (isEmpty()) {
			return;
		}else if (tail == tail.next) {
			tail = null;
		}else {
			tail.next = tail.next.next;
		}
		size--;
	}
	
	public void deleteLast() {
		if (isEmpty()) {
			return;
		}else if (tail == tail.next) {
			tail = null;
		}else {
			Node trav = tail.next;
			while (trav.next != tail) {
				trav = trav.next;
			}
			trav.next = tail.next;
			tail = trav;
		}
		size--;
	}
	
	public void deletePosition(int position) {
		if (position < 1 || position > size) {
			return;
		}
		if (isEmpty()) {
			return;
		} else if (tail == tail.next) {
			tail = null;
			size--;
			return;
		}else if (position == 1) {
			tail.next = tail.next.next;
		} else if (position == size) {
			Node trav = tail.next;
			while (trav.next != tail) {
				trav = trav.next;
			}
			trav.next = tail.next;
			tail = trav;
		}else {
			Node trav = tail.next;
			for (int i = 1; i < position - 1; i++) {
				trav = trav.next;
			}
			trav.next = trav.next.next;
		}
		size--;
	}
}


























