
import java.util.Scanner;

public class GraphTraversal {
    static int[][] graph = new int[10][10];
    static boolean[] visited = new boolean[10];
    static int n;

    static void BFS(int start) {
        int[] queue = new int[n];
        int front = 0, rear = 0;

        for (int i = 0; i < n; i++)
            visited[i] = false;

        queue[rear++] = start;
        visited[start] = true;

        System.out.print("BFS: ");

        while (front < rear) {
            int v = queue[front++];
            System.out.print(v + " ");

            for (int i = 0; i < n; i++) {
                if (graph[v][i] == 1 && !visited[i]) {
                    queue[rear++] = i;
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    static void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < n; i++) {
            if (graph[v][i] == 1 && !visited[i])
                DFS(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        System.out.print("Enter starting city (0 to " + (n-1) + "): ");
        int start = sc.nextInt();

        BFS(start);

        for (int i = 0; i < n; i++)
            visited[i] = false;

        System.out.print("DFS: ");
        DFS(start);
        System.out.println();

        sc.close();
    }
}