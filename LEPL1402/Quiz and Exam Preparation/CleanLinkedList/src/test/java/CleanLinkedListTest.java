import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CleanLinkedListTest {

    @Test
    public void test1() {

        CleanLinkedList input = new CleanLinkedList();
        input.add(3,3,3,4,5,5,6,6,6,7,9,9,9,9,10,10);

        List expected = Arrays.asList(3,4,5,6,7,9,10);


        List answer = new ArrayList();

        CleanLinkedList.Node n = input.clean().first;
        while (n != null) {
            answer.add(n.v);
            n = n.next;
        }

        Assert.assertEquals(expected,answer);
    }

}
