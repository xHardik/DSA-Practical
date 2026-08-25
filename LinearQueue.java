import java.util.Scanner;

class LinearQueue {
    int[] queue = new int[10];
    int front = -1, rear = -1;

    void enqueue(int customer) {
        if (rear == queue.length - 1)
            System.out.println("Queue Overflow");
        else {
            if (front == -1)
                front = 0;
            queue[++rear] = customer;
            System.out.println("Customer added: " + customer);
        }
    }

    void dequeue() {
        if (front == -1 || front > rear)
            System.out.println("Queue Underflow");
        else
            System.out.println("Customer served: " + queue[front++]);
    }

    void peek() {
        if (front == -1 || front > rear)
            System.out.println("Queue is empty");
        else
            System.out.println("Front customer: " + queue[front]);
    }

    void display() {
        if (front == -1 || front > rear)
            System.out.println("Queue is empty");
        else {
            System.out.println("Customers in queue:");
            for (int i = front; i <= rear; i++)
                System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearQueue q = new LinearQueue();

        while (true) {
            System.out.println("\n1.Enqueue  2.Dequeue  3.Peek  4.Display  5.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter customer number: ");
                    q.enqueue(sc.nextInt());
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}