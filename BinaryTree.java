
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
    }
}

public class BinaryTree {
    static Node root = null;

    static Node insert(Node root, int x) {
        if (root == null) return new Node(x);

        if (x < root.data)
            root.left = insert(root.left, x);
        else if (x > root.data)
            root.right = insert(root.right, x);

        return root;
    }

    static void search(Node root, int x) {
        if (root == null)
            System.out.println("Not Found");
        else if (root.data == x)
            System.out.println("Found");
        else if (x < root.data)
            search(root.left, x);
        else
            search(root.right, x);
    }

    static Node delete(Node root, int x) {
        if (root == null) return null;

        if (x < root.data)
            root.left = delete(root.left, x);
        else if (x > root.data)
            root.right = delete(root.right, x);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node t = root.right;
            while (t.left != null)
                t = t.left;

            root.data = t.data;
            root.right = delete(root.right, t.data);
        }
        return root;
    }

    static void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, x;

        do {
            System.out.println("\n1.Insert 2.Search 3.Delete 4.Display 5.Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter roll number: ");
                    x = sc.nextInt();
                    root = insert(root, x);
                    break;

                case 2:
                    System.out.print("Enter roll number: ");
                    x = sc.nextInt();
                    search(root, x);
                    break;

                case 3:
                    System.out.print("Enter roll number: ");
                    x = sc.nextInt();
                    root = delete(root, x);
                    break;

                case 4:
                    display(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
            }
        } while (ch != 5);

        sc.close();
    }
}
