import java.util.Scanner;

class Node {
    int roll;
    String name;
    Node next;

    Node(int r, String n) {
        roll = r;
        name = n;
    }
}

public class SinglyLinkedList {
    static Node head = null;
    static Scanner sc = new Scanner(System.in);

    static void insert() {
        System.out.print("Enter roll and name: ");
        int r = sc.nextInt();
        sc.nextLine();
        String n = sc.nextLine();

        Node newNode = new Node(r, n);
        if (head == null)
            head = newNode;
        else {
            Node t = head;
            while (t.next != null)
                t = t.next;
            t.next = newNode;
        }
    }

    static void delete(int r) {
        if (head == null) return;
        if (head.roll == r) {
            head = head.next;
            return;
        }
        Node t = head;
        while (t.next != null && t.next.roll != r)
            t = t.next;
        if (t.next != null)
            t.next = t.next.next;
    }

    static void search(int r) {
        Node t = head;
        while (t != null) {
            if (t.roll == r) {
                System.out.println(t.roll + " " + t.name);
                return;
            }
            t = t.next;
        }
        System.out.println("Not found");
    }

    static void update(int r) {
        Node t = head;
        while (t != null) {
            if (t.roll == r) {
                System.out.print("Enter new name: ");
                t.name = sc.next();
                return;
            }
            t = t.next;
        }
        System.out.println("Not found");
    }

    static void display() {
        Node t = head;
        while (t != null) {
            System.out.println(t.roll + " " + t.name);
            t = t.next;
        }
    }

    public static void main(String[] args) {
        int ch, r;
        do {
            System.out.println(
                "1.Insert 2.Delete 3.Search 4.Update 5.Display 6.Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1: insert(); break;
                case 2:
                    r = sc.nextInt();
                    delete(r);
                    break;
                case 3:
                    r = sc.nextInt();
                    search(r);
                    break;
                case 4:
                    r = sc.nextInt();
                    update(r);
                    break;
                case 5: display(); break;
            }
        } while (ch != 6);
    }
}