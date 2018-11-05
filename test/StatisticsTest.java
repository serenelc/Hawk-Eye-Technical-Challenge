import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class StatisticsTest {

    private double[] sampleFiveElems = {1,2,3,4,5};
    private double[] sampleSixElems = {2,4,6,8,9,10};
    Stats sample;

    @Test
    public void testSum() {
        sample = new Stats(5);
        sample.addMultipleData(sampleFiveElems);
        Assert.assertThat(sample.getSum(), CoreMatchers.is(15.0));
    }

    @Test
    public void testMean() {
        sample = new Stats(6);
        sample.addMultipleData(sampleFiveElems);
        sample.addData(6);
        Assert.assertThat(sample.getMean(), CoreMatchers.is(3.5));
    }

    @Test
    public void testMedianEven() {
        sample = new Stats(6);
        sample.addMultipleData(sampleSixElems);
        Assert.assertThat(sample.getMedian(), CoreMatchers.is(7.0));
    }

    @Test
    public void testMedianOdd() {
        sample = new Stats(7);
        sample.addMultipleData(sampleSixElems);
        sample.addData(1);
        Assert.assertThat(sample.getMedian(), CoreMatchers.is(6.0));
    }

    @Test
    public void testStandardDeviation() {
        sample = new Stats(5);
        sample.addMultipleData(sampleFiveElems);
        Assert.assertThat(sample.getStandardDeviation(), CoreMatchers.is(Math.sqrt(10.0)));
    }
}
