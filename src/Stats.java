import java.time.LocalDateTime;
import java.util.ArrayList;

class Stats {

   // static LocalDateTime dateTime = java.time.LocalDateTime.now();
    //DataTimePair datas = new DataTimePair (0, dateTime);

    private static int num;
    private static ArrayList<Double> ds;

    /* Stats constructor. Give it num to indicate how large a sample of data you want.*/
    public Stats (int num) {
        this.num = num;
        this.ds = new ArrayList(num);
    }

    /* Adds a single data value to the back of the list. If the array list is full, the oldest element, which is
     at the front of the list is removed. */
    static void addData(double d) {
        ds.add(d);
        if (ds.size() > num) {
            ds.remove(0);
        }
    }

    /* Adds an array of values to the back of the list. If the array list is full, the oldest elements are
      removed from the list. Will not add the array of values if the length of the array is larger than
      the size of the array list specified in the constructor. */
    static void addMultipleData(double[] ds) {
        assert(ds.length <= num);
        for (double d:ds) {
            addData(d);
        }
    }


    static double getSum() {
        int sum = 0;
        for (double d : ds) {
            sum += d;
        }
        return sum;
    }

    static double getMean() {
        return getSum()/ds.size();
    }

    static double getMedian() {
        //sort the list into order first.
        int size = ds.size();
        if (size % 2 == 0) {
            //ds has an even number of elements
            return (ds.get(size / 2) + ds.get((size / 2) + 1)/2);
        }
        else {
            //ns has an odd number of elements
            return ds.get(size / 2);
        }
    }

    static double getStandardDeviation() {
        Stats differenceSquared = new Stats(ds.size());
        double mean = getMean();
        for (int i = 0; i < ds.size(); i++) {
            differenceSquared.addData(Math.pow((ds.get(i) - mean), 2));
        }
        return Math.sqrt(differenceSquared.getSum());
    }
}
