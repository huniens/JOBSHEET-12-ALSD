public class Vaksin11 {
    public NodeTugas11 front, rear;
    int size;

    public Vaksin11() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(String name) {
        NodeTugas11 newNodeTugas = new NodeTugas11(name);
        newNodeTugas.queueNumber = size + 1;
        if (rear == null) {
            front = newNodeTugas;
        } else {
            rear.next = newNodeTugas;
            newNodeTugas.prev = rear;
        }
        rear = newNodeTugas;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String removedName = front.name;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        size--;
        return removedName;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("No vaccine recipients in queue.");
            return;
        }
        System.out.println("List of vaccine recipients:");
        NodeTugas11 current = front;
        while (current != null) {
            System.out.println("Queue Number: " + current.queueNumber + ", Name: " + current.name);
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
