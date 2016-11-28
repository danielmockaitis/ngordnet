package ngordnet;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeSeriesTest {
    @Test
    public void basicMap() {
        TimeSeries<Double> ts = new TimeSeries<Double>();
        ts.put(1992, 3.6);
        ts.put(1993, 9.2);
        ts.put(1994, 15.2);
        ts.put(1995, 16.1);
        ts.put(1996, -15.7);
        assertEquals(true, ts.containsKey(1992));
        assertEquals(true, ts.containsKey(1993));
        assertEquals(true, ts.containsKey(1994));
        assertEquals(true, ts.containsKey(1995));
        assertEquals(true, ts.containsKey(1996));
    }

    @Test
    public void certainYearsTest() {
        TimeSeries<Double> ts = new TimeSeries<Double>();
        ts.put(1992, 3.6);
        ts.put(1993, 9.2);
        ts.put(1994, 15.2);
        ts.put(1995, 16.1);
        ts.put(1996, -15.7);
        ts.put(1998, -15.8);
        assertEquals(true, ts.containsKey(1992));
        assertEquals(true, ts.containsKey(1993));
        assertEquals(true, ts.containsKey(1994));
        assertEquals(true, ts.containsKey(1995));
        assertEquals(true, ts.containsKey(1996));
        TimeSeries<Double> ts2 = new TimeSeries<Double>(ts, 1990, 1997);
        assertEquals(false, ts2.containsKey(1998));

    }

    @Test
    public void years() {
        TimeSeries<Double> ts = new TimeSeries<Double>();
        ts.put(1992, 3.6);
        ts.put(1993, 9.2);
        ts.put(1994, 15.2);
        ts.put(1995, 16.1);
        ts.put(1996, -15.7);
        Collection<Number> years = ts.years();
        HashMap<Integer, Double> words = new HashMap<Integer, Double>();
        for (Number yearNumber : years) {
            int year = yearNumber.intValue();
            double value = 1;
            words.put(year, value);
        }
        assertEquals(true, words.containsKey(1992));
        assertEquals(true, words.containsKey(1993));
        assertEquals(true, words.containsKey(1994));
        assertEquals(true, words.containsKey(1995));
        assertEquals(true, words.containsKey(1996));
    }
    @Test
    public void data() {
        TimeSeries<Double> ts = new TimeSeries<Double>();
        ts.put(1992, 3.6);
        ts.put(1993, 9.2);
        ts.put(1994, 15.2);
        ts.put(1995, 16.1);
        ts.put(1996, -15.7);
        Collection<Number> data = ts.data();
        HashMap<Number, Integer> words = new HashMap<Number, Integer>();
        for (Number value : data) {
            words.put(value, 1);
        }
        assertEquals(true, words.containsKey(3.6));
        assertEquals(true, words.containsKey(9.2));
        assertEquals(true, words.containsKey(15.2));
        assertEquals(true, words.containsKey(16.1));
        assertEquals(true, words.containsKey(-15.7));
    }

    @Test
    public void plus() {
        TimeSeries<Double> ts = new TimeSeries<Double>();
        ts.put(1992, 3.6);
        ts.put(1993, 9.2);
        ts.put(1994, 15.2);
        ts.put(1995, 16.1);
        ts.put(1996, -15.7);

        TimeSeries<Integer> ts2 = new TimeSeries<Integer>();
        ts2.put(1991, 10);
        ts2.put(1992, -5);
        ts2.put(1993, 1);
        TimeSeries<Double> tSum = ts.plus(ts2);

        assertEquals(10, tSum.get(1991), 0); // should print 10
        assertEquals(-1.4, tSum.get(1992), 0.1); // should print -1.4        
    }

    @Test
    public void divide() {
        TimeSeries<Integer> ts2 = new TimeSeries<Integer>();
        ts2.put(1991, 10);
        ts2.put(1992, -5);
        ts2.put(1993, 1);
        TimeSeries<Double> ts3 = new TimeSeries<Double>();
        ts3.put(1991, 5.0);
        ts3.put(1992, 1.0);
        ts3.put(1993, 100.0);
        TimeSeries<Double> tQuotient = ts2.dividedBy(ts3);
        assertEquals(2.0, tQuotient.get(1991), 0); // should print 10       
    }


    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TimeSeriesTest.class);
    }

}