
import java.util.*;

public class LinkedListUndoRedo {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    static Node head = null;

    static class Operation {
        String type;
        int value;
        int position;
        Operation(String t, int v, int p) {
            type = t; value = v; position = p;
        }
    }

    static LinkedList<Operation> undoStack = new LinkedList<>();
    static LinkedList<Operation> redoStack = new LinkedList<>();
    static final int LIMIT = 5;

    static void pushWithLimit(LinkedList<Operation> stack, Operation op) {
        if (stack.size() == LIMIT) stack.removeFirst();
        stack.addLast(op);
    }

    static void insertAtPos(int value, int pos) {
        Node newNode = new Node(value);
        if (pos == 0 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    static int deleteAtPos(int pos) {
        if (head == null) return -1;
        if (pos == 0) {
            int v = head.data;
            head = head.next;
            return v;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) return -1;
        int v = temp.next.data;
        temp.next = temp.next.next;
        return v;
    }

    static int findPosition(int value) {
        Node temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.data == value) return pos;
            temp = temp.next;
            pos++;
        }
        return -1;
    }

    static void printList() {
        Node t = head;
        System.out.print("Linked List: ");
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("null");
    }

    static void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        Operation op = undoStack.removeLast();
        if (op.type.equals("insert")) {
            deleteAtPos(op.position);
            pushWithLimit(redoStack, new Operation("delete", op.value, op.position));
        } else {
            insertAtPos(op.value, op.position);
            pushWithLimit(redoStack, new Operation("insert", op.value, op.position));
        }
        System.out.println("Undo successful.");
    }

    static void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }
        Operation op = redoStack.removeLast();
        if (op.type.equals("insert")) {
            insertAtPos(op.value, op.position);
            pushWithLimit(undoStack, new Operation("insert", op.value, op.position));
        } else {
            deleteAtPos(op.position);
            pushWithLimit(undoStack, new Operation("delete", op.value, op.position));
        }
        System.out.println("Redo successful.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. Print");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    int v = sc.nextInt();
                    System.out.print("Enter position: ");
                    int p = sc.nextInt();
                    insertAtPos(v, p);
                    pushWithLimit(undoStack, new Operation("insert", v, p));
                    redoStack.clear();
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int delv = sc.nextInt();
                    int pos = findPosition(delv);

                    if (pos == -1) {
                        System.out.println("Value not found!");
                    } else {
                        deleteAtPos(pos);
                        pushWithLimit(undoStack, new Operation("delete", delv, pos));
                        redoStack.clear();
                    }
                    break;

                case 3: undo(); break;
                case 4: redo(); break;
                case 5: printList(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
