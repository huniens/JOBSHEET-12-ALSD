import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;
  
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoubleLinkedList {
    Node head;
  
    public DoubleLinkedList() {
        this.head = null;
    }
  
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
  
    public void addTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }
  
    public void addAtIndex(int data, int index) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }
  
        if (index == 0) {
            addFirst(data);
            return;
        }
  
        Node newNode = new Node(data);
        Node current = head;
        int count = 0;
  
        while (count < index - 1 && current != null) {
            current = current.next;
            count++;
        }
  
        if (current == null) {
            System.out.println("Invalid index");
            return;
        }
  
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
    }
  
    public void removeFirst() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
  
        if (head.next == null) {
            head = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }
    }
  
    public void removeLast() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
  
        if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.prev.next = null;
        }
    }
  
    public void removeAtIndex(int index) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
  
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }
  
        if (index == 0) {
            removeFirst();
            return;
        }
  
        Node current = head;
        int count = 0;
  
        while (count < index && current != null) {
            current = current.next;
            count++;
        }
  
        if (current == null) {
            System.out.println("Invalid index");
            return;
        }
  
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        current.prev.next = current.next;
    }
  
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add First");
            System.out.println("2. Add Tail");
            System.out.println("3. Add Data in nth index");
            System.out.println("4. Remove First");
            System.out.println("5. Remove Last");
            System.out.println("6. Remove data by index");
            System.out.println("7. Print");
            System.out.println("8. Search Data");
            System.out.println("9. Sort Data");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
  
            switch (choice) {
                case 1:
                    System.out.print("Enter the data to add: ");
                    int dataToAddFirst = scanner.nextInt();
                    doubleLinkedList.addFirst(dataToAddFirst);
                    break;
                case 2:
                    System.out.print("Enter the data to add: ");
                    int dataToAddTail = scanner.nextInt();
                    doubleLinkedList.addTail(dataToAddTail);
                    break;
                case 3:
                    System.out.print("Enter the data to add: ");
                    int dataToAdd = scanner.nextInt();
                    System.out.print("Enter the index: ");
                    int indexToAdd = scanner.nextInt();
                    doubleLinkedList.addAtIndex(dataToAdd, indexToAdd);
                    break;
                case 4:
                    doubleLinkedList.removeFirst();
                    break;
                case 5:
                    doubleLinkedList.removeLast();
                    break;
                case 6:
                    System.out.print("Enter the index: ");
                    int indexToRemove = scanner.nextInt();
                    doubleLinkedList.removeAtIndex(indexToRemove);
                    break;
                case 7:
                    System.out.print("Linked List: ");
                    doubleLinkedList.print();
                    break;
                case 8:
                    System.out.print("Enter the data to search: ");
                    int searchData = scanner.nextInt();
                    // Call the method to search for the data
                    break;
                case 9:
                    // Call the method to sort the data
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 10);
        scanner.close();
    }
}