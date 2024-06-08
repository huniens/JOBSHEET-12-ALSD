class DoubleLinkedList {
    Node head;
  
    public DoubleLinkedList() {
        this.head = null;
    }
  
    // Method to add a node at the beginning of the linked list
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
  
    // Method to add a node at the end of the linked list
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
  
    // Method to add a node at the nth index of the linked list
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
  
    // Method to remove the first node of the linked list
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
  
    // Method to remove the last node of the linked list
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
  
    // Method to remove the node at the nth index of the linked list
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
  
    // Method to print the linked list
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}