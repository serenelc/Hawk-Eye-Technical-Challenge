class Stats {

    //mean, median, sum, standard deviation

    static double getSum(double[] ns) {
        int sum = 0;
        for (double n : ns) {
            sum += n;
        }
        return sum;
    }

    static double getMean(double[] ns) {
        return getSum(ns)/ns.length;
    }

    static double getMedian(double[] ns) {
        //sort the list into order first.
        int length = ns.length;
        if (length % 2 == 0) {
            //ns has an even number of elements
            return (ns[length / 2] + ns[(length / 2) + 1])/2;
        }
        else {
            //ns has an odd number of elements
            return ns[length / 2];
        }
    }

    static double getStandardDeviation(double[] ns) {
        double[] differenceSquared = new double[ns.length];
        double mean = getMean(ns);
        for (int i = 0; i < ns.length; i++) {
            differenceSquared[i] = Math.pow((ns[i] - mean), 2);
        }
        return Math.sqrt(getSum(differenceSquared));
    }
}
