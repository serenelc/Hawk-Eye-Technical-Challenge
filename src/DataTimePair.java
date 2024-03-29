import java.time.LocalDateTime;

public class DataTimePair<D> implements Comparable<DataTimePair> {

        /* Currently takes generic type D, so can cast to double or int or long as required. */

        private final D data;
        private final java.time.LocalDateTime time;

        /* DataTimePair will be initialised with time now when it is created. */
        public DataTimePair (D data) {
            this.data = data;
            this.time = java.time.LocalDateTime.now();
        }

        public D getDataValue () {
            return data;
        }

        public java.time.LocalDateTime getDateTime () {
            return time;
        }

        @Override
        public int hashCode () {
            return data.hashCode () + time.hashCode ();
        }

        @Override
        public boolean equals (Object o) {
            if (!(o instanceof DataTimePair)) {
                return false;
            }
            DataTimePair pair = (DataTimePair) o;
            return this.data.equals (pair.getDataValue()) && this.time.equals (pair.getDateTime ());
        }

        @Override
        public int compareTo(DataTimePair other) {
            java.time.LocalDateTime t = other.getDateTime();
            return time.compareTo(t);
        }
}
