import java.time.LocalDateTime;
import java.util.ArrayList;

class Stats {

   // static LocalDateTime dateTime = java.time.LocalDateTime.now();
    //DataTimePair datas = new DataTimePair (0, dateTime);

    private static int num;
    private static ArrayList<Double> ds;

    public Stats (int num) {
        this.num = num;
        this.ds = new ArrayList(num);
    }

    static void addData(double d) {
        //default adds to end of list. Want to add to front of list.
        ds.add(0, d);
        if (ds.size() == num) {
            ds.remove(num - 1);
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
