
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Except{
    
    
    public static void outof(){
        int[] a = {1, 2, 3};
        System.out.println(a[-1]);
    }
    
    public static void concurr(){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);

        for (Integer i : a) {
            a.remove(1);
        }
    }
    
    public static void nullpointer(){
        String a = null, b = "1";

        System.out.println(a.equals(b));
    }
    
    
    
}