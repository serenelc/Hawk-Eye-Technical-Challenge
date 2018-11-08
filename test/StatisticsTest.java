import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class StatisticsTest {

    private double[] sampleFiveElems = {1,2,3,4,5};
    private double[] sampleSixElems = {2,4,6,8,9,10};
    Stats sample;

    @Test
    public void testAddingOneData() {
        sample = new Stats(1);
        sample.addData(4.66);
        Assert.assertThat(sample.getElemAtIndex(0), CoreMatchers.is(4.66));
    }

    @Test
    public void testSum() {
        sample = new Stats(5);
        sample.addMultipleData(sampleFiveElems);
        Assert.assertThat(sample.getSum(0, 4), CoreMatchers.is(15.0));
    }

    @Test
    public void testMean() {
        sample = new Stats(6);
        sample.addMultipleData(sampleFiveElems);
        sample.addData(6);
        Assert.assertThat(sample.getMean(0, 5), CoreMatchers.is(3.5));
    }

    @Test
    public void testMedianEven() {
        sample = new Stats(6);
        sample.addMultipleData(sampleSixElems);
        Assert.assertThat(sample.getMedian(0, 5), CoreMatchers.is(7.0));
    }

    @Test
    public void testMedianOdd() {
        sample = new Stats(7);
        sample.addMultipleData(sampleSixElems);
        sample.addData(1);
        Assert.assertThat(sample.getMedian(0, 6), CoreMatchers.is(6.0));
    }

    @Test
    public void testStandardDeviation() {
        sample = new Stats(5);
        sample.addMultipleData(sampleFiveElems);
        Assert.assertThat(sample.getStandardDeviation(0, 4), CoreMatchers.is(Math.sqrt(10.0)));
    }
}
