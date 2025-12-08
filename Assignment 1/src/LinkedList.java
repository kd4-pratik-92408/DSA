	
	public class LinkedList {
		static class Node{
			private int data;
			private Node next;
			public Node(int value) {
				data=value;
				next=null;
			}
		}
		private Node head;
		public LinkedList() {
			head=null;
		}
		public void addLast(int value) {
			//create a newnode with given data
			Node newnode= new Node(value);
			// if list is empty then add newnode into head itself
			if(head==null) {
				head=newnode;
			}
			else {
				//travers till last(where trav.next is null)
				Node trav=head;
				while(trav.next != null) {
					trav= trav.next;
				}
				trav.next=newnode;
			}
	
		}
		
		public void display() {
			Node trav= head;
			System.out.print("LL is : ");
			while(trav!=null) {
				System.out.print(trav.data+" ");
				trav= trav.next;
				
	
			}
			System.out.println();
		}
		
		public int getPos(int ele) {
			int c=0;
			Node trav= head;
			while(trav!=null) {
				c++;
				if(trav.data==ele) {
					return c;
				}
				trav=trav.next;
			}
			return -1;
		}
		
		public void addPosition(int value,int pos) {
			Node newnode= new Node(value);
			// if empty then add new node in head only
			if(head==null) {
				head=newnode;
			}
			// if you want to add at pos 1 then add directly by using head 
			// cause below else code can't do it because it will not go in loop only  
			else if(pos==1) {
				newnode.next=head;
				head=newnode;
			}
			// if pos<1 then no need to do anything
			else if(pos<1) {
				return;
			}
			else {
				//iterate till pos-1 and then add newnods next to pos and pos-1s next to newnode
				Node trav= head;
				for(int i=1; i<pos-1 && trav.next!=null;i++) {
					trav= trav.next;
				}
				newnode.next=trav.next;
				trav.next=newnode;
				
			}
			
		}
		
	}
