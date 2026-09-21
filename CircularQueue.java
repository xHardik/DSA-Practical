import java.util.Scanner;

public class CircularQueue {

    int[] queue;
    int front = -1, rear = -1;
    int size;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    // Insert element
    void enqueue(int value) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is Full");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = value;

        System.out.println(value + " inserted");
    }

    // Remove element
    void dequeue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println(queue[front] + " removed");

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // Display queue
    void display() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue: ");

        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");

            if (i == rear)
                break;

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        CircularQueue q = new CircularQueue(size);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();
        q.dequeue();

        q.enqueue(40);
        q.enqueue(50);

        q.display();
    }
}