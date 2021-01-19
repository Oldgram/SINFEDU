public class MergeSort {

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    // Mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sorting(int[] a, int[] aux, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if(lo < hi){
            sorting(a, aux, lo, mid);
            sorting(a, aux, mid+1, hi);
        }
        merge(a,aux,lo,mid,hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order
     */
    public static void sort(int[] a) {
        int low = 0;
        int high = a.length - 1;
        int[] aux = new int[a.length];
        sorting(a, aux, low, high);
    }
}