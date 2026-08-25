import java.util.Scanner;

class BrowserHistory {
    String[] stack = new String[10];
    int top = -1;

    void push(String url) {
        if (top == stack.length - 1)
            System.out.println("Stack Overflow");
        else {
            stack[++top] = url;
            System.out.println("Visited: " + url);
        }
    }

    void pop() {
        if (top == -1)
            System.out.println("No history available");
        else
            System.out.println("Back from: " + stack[top--]);
    }

    void peek() {
        if (top == -1)
            System.out.println("No page in history");
        else
            System.out.println("Current page: " + stack[top]);
    }

    void display() {
        if (top == -1)
            System.out.println("History is empty");
        else {
            System.out.println("Browser History:");
            for (int i = top; i >= 0; i--)
                System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BrowserHistory b = new BrowserHistory();

        while (true) {
            System.out.println("\n1.Push  2.Pop  3.Peek  4.Display  5.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter URL: ");
                    b.push(sc.nextLine());
                    break;
                case 2:
                    b.pop();
                    break;
                case 3:
                    b.peek();
                    break;
                case 4:
                    b.display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}