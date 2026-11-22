public class BinarySearch {
    public static void main(String[] args) {

        int a[] = {2, 4, 6, 7};
        int key = 6;

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == key) {
                System.out.println("Found at index " + mid);
                return;
            } else if (key < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Not Found");
    }

}
