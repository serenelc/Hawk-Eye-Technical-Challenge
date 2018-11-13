import java.time.LocalDateTime;

public class DataTimePair<D> implements Comparable<DataTimePair> {

        private final D data;
        private final java.time.LocalDateTime time;

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
