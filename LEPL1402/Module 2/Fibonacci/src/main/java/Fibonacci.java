public class Fibonacci {


    public static int fiboRecursive(int index){
        if (index == 0 || index == 1) {
            return index ;
        }
        return fiboRecursive(index - 1) + fiboRecursive( index - 2);
    }


    public static int fiboIterative(int index){
        int n1 = 0, n2 = 1;
        int temp;
        for (int i = 0; i < index; i++) {
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }

}
