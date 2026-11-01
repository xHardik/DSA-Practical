
import java.util.Scanner;

public class Sorting2 {

    static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);

            int i = l, j = m + 1, k = 0;
            int temp[] = new int[r - l + 1];

            while (i <= m && j <= r)
                temp[k++] = a[i] < a[j] ? a[i++] : a[j++];

            while (i <= m) temp[k++] = a[i++];
            while (j <= r) temp[k++] = a[j++];

            for (i = 0; i < k; i++)
                a[l + i] = temp[i];
        }
    }

    static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int pivot = a[high], i = low - 1;

            for (int j = low; j < high; j++) {
                if (a[j] < pivot) {
                    i++;
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }

            int t = a[i + 1];
            a[i + 1] = a[high];
            a[high] = t;

            int p = i + 1;
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter product prices:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("1.Merge Sort 2.Quick Sort");
        int ch = sc.nextInt();

        if (ch == 1)
            mergeSort(a, 0, n - 1);
        else if (ch == 2)
            quickSort(a, 0, n - 1);
        else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        System.out.println("Sorted prices:");
        for (int x : a)
            System.out.print(x + " ");

        sc.close();
    }
}
