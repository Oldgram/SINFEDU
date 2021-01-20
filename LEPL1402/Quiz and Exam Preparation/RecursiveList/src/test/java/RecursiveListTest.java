import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RecursiveListTest {

    @Test
    public void test() {

        RecursiveList<Integer> l = RecursiveList.toList(1,2,3);

        RecursiveList<Integer> rl = l.reverse();

        RecursiveList<Integer> rrl = rl.reverse();


        Assert.assertEquals(Arrays.asList(3,2,1),toList(rl));
        Assert.assertEquals(toList(l),toList(rrl));


    }

    public static List<Integer> toList(RecursiveList<Integer> list) {
        List<Integer> result = new ArrayList<>();
        list.forEach(result::add);
        return result;
    }






}
