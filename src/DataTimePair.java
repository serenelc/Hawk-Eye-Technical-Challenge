public class DataTimePair<D, T> {

        private final D data;
        private final T time;

        public DataTimePair(D data, T time) {
            this.data = data;
            this.time = time;
        }

        public D getDataValue() {
            return data;
        }

        public T getDateTime() {
            return time;
        }

        @Override
        public int hashCode() {
            return data.hashCode() + time.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof DataTimePair)) {
                return false;
            }
            DataTimePair pair = (DataTimePair) o;
            return this.data.equals(pair.getDataValue()) && this.time.equals(pair.getDateTime());
        }
}
