
import java.util.Scanner;

public class Sorting {
    static void selectionSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[min])
                    min = j;

            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    static void insertionSort(int a[], int n) {
        for (int i = 1; i < n; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students : ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter student's marks:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("1.Selection Sort 2.Insertion Sort");
        int ch = sc.nextInt();

        if (ch == 1)
            selectionSort(a, n);
        else if (ch == 2)
            insertionSort(a, n);
        else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        System.out.println("Sorted marks:");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

        sc.close();
    }
}
