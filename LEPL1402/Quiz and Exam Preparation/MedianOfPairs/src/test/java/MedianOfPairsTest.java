import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class MedianOfPairsTest {

    @Test
    public void test1() {

        List<MedianOfPairs.Pair> pairs = new LinkedList<>();
        pairs.add(new MedianOfPairs.Pair(4, 1));
        pairs.add(new MedianOfPairs.Pair(3, 8));
        pairs.add(new MedianOfPairs.Pair(4, 3));
        pairs.add(new MedianOfPairs.Pair(9, 1));
        pairs.add(new MedianOfPairs.Pair(3, 6));

        MedianOfPairs.Pair res = MedianOfPairs.median(pairs);

        Assert.assertEquals(4, res.first);
        Assert.assertEquals(1, res.second);
    }

}
