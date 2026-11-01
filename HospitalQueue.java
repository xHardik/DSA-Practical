import java.util.Scanner;

class Node {
    String name;
    Node next;
    Node(String n) { name = n; }
}

public class HospitalQueue {
    static Node front = null, rear = null;
    static Scanner sc = new Scanner(System.in);

    static void add() {
        System.out.print("Enter patient name: ");
        Node n = new Node(sc.nextLine());
        if (rear == null) front = rear = n;
        else { rear.next = n; rear = n; }
    }

    static void treat() {
        if (front == null) System.out.println("Queue empty");
        else {
            System.out.println("Treating: " + front.name);
            front = front.next;
            if (front == null) rear = null;
        }
    }

    static void display() {
        Node t = front;
        while (t != null) {
            System.out.println(t.name);
            t = t.next;
        }
    }

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("1.Add Patient 2.Treat Patient 3.Display 4.Exit");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1: add(); break;
                case 2: treat(); break;
                case 3: display(); break;
            }
        } while (ch != 4);
    }
}