public class Main {

    private static double[] test = {1,2,4,3,5};

    public static void main(String[] args) {
        //System.out.println("Our test array is: " + test.toString());
        System.out.println("The sum is: " + Stats.getSum(test));
        System.out.println("The mean is: " + Stats.getMean(test));
        System.out.println("The median is " + Stats.getMedian(test));
        System.out.println("The standard deviation is " + Stats.getStandardDeviation(test));
    }
}
