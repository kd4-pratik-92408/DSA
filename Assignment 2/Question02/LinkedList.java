package Question02;

public class LinkedList {
	static class Node {
		Employee data;
		Node next;
		Node prev;
		public Node(Employee data) {
			this.data = data;
			next = prev = null;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void add(Employee emp) {
		Node newNode = new Node(emp);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public void display() {
		if (isEmpty()) {
			System.out.println("No Employees!!!");
			return;
		}
		
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}
	
	public Employee searchByName(String name) {
		if (isEmpty()) {
			System.out.println("No Employees!!!");
			return null;
		}
		
		Node trav = head;
		while (trav != null) {
			if (trav.data.getName().equalsIgnoreCase(name)) {
				return trav.data;
			}
			trav = trav.next;
		}
		return null;
	}
	
	public boolean deleteByID(int id) {
		if (isEmpty()) {
			return false;
		}
		
		Node trav = head;
		while (trav != null) {
			if (trav.data.getID() == id) {
				if (trav == head) {
					head = head.next;
					head.prev = null;
				} else if (trav == tail) {
					tail = tail.prev;
					tail.next = null;
				} else {
					trav.prev.next = trav.next;
					trav.next.prev = trav.prev;
				}
				size--;
				return true;
			}
			trav = trav.next;
		}
		return false;
	}
	
	public boolean updateSalary(int id, double newSalary) {
		if (isEmpty()) {
			return false;
		}
		
		Node trav = head;
		while (trav != null) {
			if (trav.data.getID() == id) {
				trav.data.setSalary(newSalary);
				return true;
			}
			trav = trav.next;
		}
		return false;
	}
	
	public void sortBySalary() {
		if (isEmpty() || head.next == null) {
			return;
		}
		
		Node i, j;
		for (i = head; i != null; i = i.next) {
			for (j = i.next; j != null; j = j.next) {
				if (i.data.getSalary() > j.data.getSalary()) {
					Employee temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
			}
		}
	}
	
	public int size() {
		return size;
	}
}
























