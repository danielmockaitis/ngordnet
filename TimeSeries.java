package ngordnet;
import java.util.Collection;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.NavigableSet;


public class TimeSeries <T extends Number > extends TreeMap<Integer, T> {
    private TimeSeries<T> time;
    private int startYear;
    private int endYear;

    /** Constructs a new empty TimeSeries. */
    public TimeSeries(){
        super();
    }
    /** Returns the years in which this time series is valid. Doesn't really
      * need to be a NavigableSet. This is a private method and you don't have 
      * to implement it if you don't want to. */
    private NavigableSet<Integer> validYears(int startYear, int endYear){
        return null;
    }

    /** Creates a copy of TS, but only between STARTYEAR and ENDYEAR. 
     * inclusive of both end points. */
    public TimeSeries(TimeSeries<T> ts, int startYear, int endYear){
        this(ts);
        for(Integer key: super.keySet()){
            if ((key < startYear) || (key > endYear)){
                super.remove(key);
            }
        }
    }

    /** Creates a copy of TS. */
    public TimeSeries(TimeSeries<T> ts){
        this();
    }

    /** Returns the quotient of this time series divided by the relevant value in ts.
      * If ts is missing a key in this time series, return an IllegalArgumentException. */
    public TimeSeries<Double> dividedBy(TimeSeries<? extends Number> ts){
        TimeSeries<Double> divided = new TimeSeries<Double>();
        if (ts == null){
            throw new IllegalArgumentException();
        }
        else {
            for (Integer tsKey: ts.keySet()){
                for(Integer key: super.keySet()){
                    if (key.equals(tsKey)) {
                        divided.put(tsKey, (super.get(key).doubleValue() / ts.get(tsKey).doubleValue()) );
                    }
                    else if (!divided.containsKey(tsKey)) {
                        divided.put(tsKey, ts.get(tsKey).doubleValue());
                    }
                }
            }
        }
        return divided;
    }

    /** Returns the sum of this time series with the given ts. The result is a 
    * a Double time series (for simplicity). */
    public TimeSeries<Double> plus(TimeSeries<? extends Number> ts) {
        TimeSeries<Double> added = new TimeSeries<Double>();
        for (Integer tsKey: ts.keySet()){
            for(Integer key: super.keySet()){
                if (key.equals(tsKey)) {
                    added.put(tsKey, super.get(key).doubleValue() + ts.get(tsKey).doubleValue() );
                }
                else if (!added.containsKey(tsKey)) {
                    added.put(tsKey, ts.get(tsKey).doubleValue());
                }
            }
        }
        return added;
    }
    /** Returns all years for this time series (in any order). */
    public Collection<Number> years() {
        Collection<Number> years = new ArrayList<Number>();
        for (Integer key: super.keySet()){
            years.add(key);
        }
        return years;

    }

    /** Returns all data for this time series (in any order). */
    public Collection<Number> data() {
        Collection<Number> data = new ArrayList<Number>();
        for (Integer key: super.keySet()){
            data.add(super.get(key));
        }
        return data;
    }


}