public class LinearSearch {
    public static void main(String[] args) {

        int a[] = {2, 6, 7, 4};
        int key = 7;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                System.out.println("Found at index " + i);
                return;
            }
        }

        System.out.println("Not Found");
    }

}
