import java.util.Scanner;

class Node {
    String name;
    Node next;

    Node(String n) {
        name = n;
    }
}

public class CircularList {
    static Node head = null, tail = null;
    static Scanner sc = new Scanner(System.in);

    static void insert() {
        System.out.print("Enter player name: ");
        Node n = new Node(sc.nextLine());

        if (head == null) {
            head = tail = n;
            tail.next = head;
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }
    }

    static void delete() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        System.out.print("Enter player to delete: ");
        String name = sc.nextLine();
        Node t = head, prev = tail;

        do {
            if (t.name.equals(name)) {
                if (t == head) head = head.next;
                if (t == tail) tail = prev;
                prev.next = t.next;

                if (head == t) head = null;
                if (head == null) tail = null;
                else tail.next = head;

                System.out.println("Player deleted");
                return;
            }
            prev = t;
            t = t.next;
        } while (t != head);

        System.out.println("Player not found");
    }
static void display() {
    if (head == null) {
        System.out.println("No players");
        return;
    }

    Node t = head;
    do {
        System.out.print(t.name + " -> ");
        t = t.next;
    } while (t != head);

    System.out.println(head.name + " (first player)");
}
    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\n1.Insert 2.Delete 3.Display 4.Exit");
            ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1: insert(); break;
                case 2: delete(); break;
                case 3: display(); break;
                case 4: System.out.println("Game ended"); break;
                default: System.out.println("Invalid choice");
            }
        } while (ch != 4);
    }
}