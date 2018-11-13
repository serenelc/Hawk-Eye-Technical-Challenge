import static java.time.LocalDateTime.now;

public class Main {

    private static Stats test = new Stats (8);

    public static void main(String[] args) {
        test.addData(1);
        test.addData(3);
        test.addData(2);
        test.addData(4);
        test.addData(5);
        System.out.println("The mean is: " + test.getMean(0, 4));
        java.time.LocalDateTime now = now();
        java.time.LocalDateTime before = now().minusMinutes(3);
        System.out.println("The mean with time is: " + test.getMeanWithTime(before, now));
        //System.out.println("the standard deviation is " + test.getStandardDeviation());
        //System.out.println("Add 6...");
        //test.addData(6);
        //System.out.println("The new mean is: " + test.getMean());
        //System.out.println("The median is: " + test.getMedian());
    }
}

