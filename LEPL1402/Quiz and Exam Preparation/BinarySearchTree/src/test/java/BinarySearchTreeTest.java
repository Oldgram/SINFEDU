import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class BinarySearchTreeTest {

    @Test
    public void test1() {

        BinarySearchTree t = new BinarySearchTree();
        t.insert(2);
        t.insert(9);
        t.insert(5);
        t.insert(2);
        t.insert(6);
        t.insert(0);
        t.insert(9);
        t.insert(10);

        // 10 - 9 - 6 - 5 - 2 - 0

        List<Integer> result = t.decreasing();

        List<Integer> answer = Arrays.asList(10,9,6,5,2,0);

        Assert.assertEquals(answer,result);


    }

}
