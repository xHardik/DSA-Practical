
import java.util.Scanner;

class Node {
    String name;
    Node next;

    Node(String n) {
        name = n;
    }
}

public class HospitalStack {
    static Node top = null;
    static Scanner sc = new Scanner(System.in);

    static void addPatient() {
        System.out.print("Enter patient name: ");
        Node n = new Node(sc.nextLine());
        n.next = top;
        top = n;
    }

    static void treatPatient() {
        if (top == null)
            System.out.println("No patients");
        else {
            System.out.println("Treating: " + top.name);
            top = top.next;
        }
    }

    static void display() {
        Node t = top;
        if (t == null)
            System.out.println("No patients");
        while (t != null) {
            System.out.println(t.name);
            t = t.next;
        }
    }

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\n1.Add Patient 2.Treat Patient 3.Display 4.Exit");
            ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1: addPatient(); break;
                case 2: treatPatient(); break;
                case 3: display(); break;
                case 4: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice");
            }
        } while (ch != 4);
    }
}
