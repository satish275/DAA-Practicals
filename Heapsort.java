import java.util.Scanner;

public class Heapsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = n / 2 - 1; i >= 0; i--) {
            int parent = i;
            while (true) {
                int largest = parent;
                int left = 2 * parent + 1;
                int right = 2 * parent + 2;
                if (left < n && a[left] > a[largest]) {
                    largest = left;
                }
                if (right < n && a[right] > a[largest]) {
                    largest = right;
                }
                if (largest != parent) {
                    int temp = a[parent];
                    a[parent] = a[largest];
                    a[largest] = temp;

                    parent = largest;
                } else {
                    break;
                }
            }
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            int parent = 0;
            while (true) {
                int largest = parent;
                int left = 2 * parent + 1;
                int right = 2 * parent + 2;
                if (left < i && a[left] > a[largest]) {
                    largest = left;
                }
                if (right < i && a[right] > a[largest]) {
                    largest = right;
                }

                if (largest != parent) {
                    temp = a[parent];
                    a[parent] = a[largest];
                    a[largest] = temp;

                    parent = largest;
                } else {
                    break;
                }
            }
        }
        System.out.println("Sorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        sc.close();
    }
}