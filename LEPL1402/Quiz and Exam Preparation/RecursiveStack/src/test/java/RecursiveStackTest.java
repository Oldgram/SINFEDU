import org.junit.Assert;
import org.junit.Test;


public class RecursiveStackTest {

    @Test
    public void test() {

        RecursiveStack stack = RecursiveStack.makeRecursiveStack();

        Assert.assertEquals(0, stack.size());
        stack = stack.addTop(1);


        stack = stack.addTop(2);
        RecursiveStack oldStack = stack;
        Assert.assertEquals(2, stack.top());
        stack = stack.addTop(3);
        Assert.assertEquals(2, oldStack.size());
        Assert.assertEquals(2, oldStack.top());
        Assert.assertEquals(3, stack.top());
        Assert.assertEquals(3, stack.size());
        stack = stack.removeTop();
        stack = stack.removeTop();
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(1, stack.top());
        stack = stack.removeTop();
        Assert.assertEquals(0, stack.size());
    }





}
