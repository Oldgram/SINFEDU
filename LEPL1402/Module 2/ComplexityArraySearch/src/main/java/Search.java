public class Search {
    /**
     * @param tab is an ordered array of int.
     * @return index of elem or -1
     */
    public static int search(int[] tab, int elem) {
        int first = 0, last = tab.length - 1, middle = 0;
        boolean found = false;

        while (first <= last && !found) {
            middle = (first + last) / 2;
            if (tab[middle] == elem) {
                found = true;
            } else {
                if (elem < tab[middle]) {
                    last = middle - 1;
                } else {
                    first = middle + 1;
                }
            }
        }

        if (found) {
            return middle;
        } else {
            return -1;
        }
    }
}


