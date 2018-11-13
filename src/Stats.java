import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Stats {

    private static LocalDateTime dateTime;
    private static ArrayList<DataTimePair> datas;
    private static int num;
    private static ArrayList<Double> ds;

    /* Stats constructor. Give it num to indicate how large a sample of data you want. Creates an empty
      ArrayList of length num. */
    public Stats (int num) {
        this.num = num;
        this.ds = new ArrayList (num);

        this.datas = new ArrayList<> (num);
    }

    /* Adds a single data value to the back of the ds list. If ds is full, the oldest element, which is
     at the front of the list is removed. */
    static void addData (double d) {
        ds.add (d);
        if (ds.size() > num) {
            ds.remove (0);
        }

        dateTime = java.time.LocalDateTime.now();
        DataTimePair dtp = new DataTimePair (d);
        datas.add (dtp);
        if (datas.size () > num) {
            datas.remove (0);
        }
    }

    /* Adds an array of values to the back of ds. If ds is full, the oldest elements are removed from the list.
      Will not add the array of values if the length of the array is larger than
      the size of the array list specified in the constructor. */
    static void addMultipleData (double[] ds) {
        assert (ds.length <= num);

        for (double d:ds) {
            addData (d);
        }
    }

    /* Gets the element from the list at the given index. Checks first that the given index is within
       the size of ds. */
    static double getElemAtIndex (int i) {
        assert (i < num);
        //return datas.get (i);
        return ds.get (i);
    }

    /* Sorts the list into ascending order then sums the elements in ds from the index start up to the index end. */
    static double getSum (int start, int end) {
        assert (end < num);
        Collections.sort (ds);
        //Collections.sort (datas);
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += ds.get (i);
        }
        return sum;
    }

    /* Sorts the list into ascending order then gets the mean of the elements from the index start
       up to the index end. */
    static double getMean(int start, int end) {
        assert (end < num);
        Collections.sort(ds);
        return getSum(start, end)/(end - start + 1);
    }

    /* Sorts the list into ascending order and then gets the median of the elements from the index
       start up to the index end. */
    static double getMedian(int start, int end) {
        assert (end < num);
        Collections.sort(ds);
        int size = end - start + 1;
        if (size % 2 == 0) {
            //ds has an even number of elements
            return (ds.get(size / 2) + ds.get((size / 2) - 1))/2;
        }
        else {
            //ds has an odd number of elements
            return ds.get(size / 2);
        }
    }

    /* Sorts the list into ascending order and then gets the standard deviation of the elements from
       the index start up to the index end. */
    static double getStandardDeviation(int start, int end) {
        assert (end < num);
        Collections.sort(ds);
        double differenceSquared = 0;
        double mean = getMean(start, end);
        for (int i = start; i <= end; i++) {
            differenceSquared += (Math.pow((ds.get(i) - mean), 2));
        }
        return Math.sqrt(differenceSquared);
    }

}
