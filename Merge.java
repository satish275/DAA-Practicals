public class Merge {

    static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;

        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);

        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;

        while (i <= mid && j <= r) {
            if (a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= mid)
            temp[k++] = a[i++];

        while (j <= r)
            temp[k++] = a[j++];

        for (i = 0; i < temp.length; i++)
            a[l + i] = temp[i];
    }

    public static void main(String[] args) {
        int[] a = {2, 6, 7, 4};

        mergeSort(a, 0, a.length - 1);

        for (int x : a)
            System.out.print(x + " ");
    }
}