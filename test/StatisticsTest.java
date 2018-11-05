import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class StatisticsTest {

    private Stats sampleTwo = new Stats(6);
    private double[] sampleData = {1,2,3,4,5};

    @Test
    public void testSum() {
        Stats sampleOne = new Stats(5);
        sampleOne.addMultipleData(sampleData);
        Assert.assertThat(sampleOne.getSum(), CoreMatchers.is(15.0));
    }

    @Test
    public void testMean() {

    }

    @Test
    public void testMedian() {

    }

    @Test
    public void testStandardDeviation() {

    }
}
