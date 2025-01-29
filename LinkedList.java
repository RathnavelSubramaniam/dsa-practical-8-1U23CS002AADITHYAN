import java.util.Scanner;

public class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    // Method to add a new node at the end of the list
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to insert a new node at the end of the list
    public void insertEnd(int data) {
        Node newNode = new Node(data); // Create a new node with the given data.
        
        // If the list is empty, the new node becomes both the head and the tail.
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Set the next pointer of the current tail to the new node.
            tail = newNode;      // Update the tail to the new node.
        }
    }

    // Method to display the linked list
    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER INTEGERS TO CREATE NODES (ENTER A NON-INTEGER TO EXIT):");

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int data = sc.nextInt();
                list.addNode(data);
            } else {
                // Break out when a non-integer is entered
                sc.next(); // Consume the non-integer input
                System.out.println("LINKED LIST CREATED");
                System.out.println("LINKED LIST BEFORE INSERTING");
                list.displayList();

                System.out.println("ENTER THE ELEMENT TO BE INSERTED:");

                if (sc.hasNextInt()) {
                    int dataToInsert = sc.nextInt();
                    list.insertEnd(dataToInsert);
                } else {
                    System.out.println("Enter integers only");
                    break;
                }

                System.out.println("LINKED LIST AFTER INSERTING");
                list.displayList();
                break;
            }
        }

        sc.close(); // Close the scanner after use
    }
}
