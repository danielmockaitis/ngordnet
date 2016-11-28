package ngordnet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class YearlyRecordTest {
    @Test
    public void basic() {
        YearlyRecord yr = new YearlyRecord();
        yr.put("quayside", 95);        
        yr.put("surrogate", 340);
        yr.put("merchantman", 181);      
        assertEquals(95, yr.count("quayside")); // should print 3
    }
    @Test
    public void size() {
        YearlyRecord yr = new YearlyRecord();
        yr.put("quayside", 95);        
        yr.put("surrogate", 340);
        yr.put("merchantman", 181);      
        assertEquals(3, yr.size()); // should print 3
    }
    @Test
    public void words() {
        YearlyRecord yr = new YearlyRecord();
        yr.put("quayside", 95);        
        yr.put("surrogate", 340);
        yr.put("merchantman", 181);
        yr.put("dumb", 321);        
        yr.put("south", 10);
        yr.put("danny", 200);
        Collection<String> sorted = yr.words();
        Iterator c = sorted.iterator();
        assertEquals("south", c.next());
        assertEquals("quayside", c.next());
        assertEquals("merchantman", c.next());
        assertEquals("danny", c.next());
        assertEquals("dumb", c.next());
        assertEquals("surrogate", c.next());
    }

    @Test
    public void values() {
        YearlyRecord yr = new YearlyRecord();
        yr.put("quayside", 95);        
        yr.put("surrogate", 340);
        yr.put("merchantman", 181);
        yr.put("dumb", 321);        
        yr.put("south", 10);
        yr.put("danny", 200);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(95);
        nums.add(181);
        nums.add(340);
        nums.add(321);
        nums.add(10);
        nums.add(200);
        Collection<Number> x = yr.counts();
        Iterator c = x.iterator();
        assertEquals(10, c.next());
        assertEquals(95, c.next());
        assertEquals(181, c.next());
        assertEquals(200, c.next());
        assertEquals(321, c.next());
        assertEquals(340, c.next());
    }

    @Test
    public void rank() {
        YearlyRecord yr = new YearlyRecord();
        yr.put("quayside", 95);        
        yr.put("surrogate", 340);
        yr.put("merchantman", 181);
        assertEquals(3, yr.rank("quayside"));
        assertEquals(2, yr.rank("merchantman"));
        assertEquals(1, yr.rank("surrogate"));
    }

    @Test
    public void inputData() {
        HashMap<String, Integer> rawData = new HashMap<String, Integer>();
        rawData.put("berry", 1290);
        rawData.put("auscultating", 6);
        rawData.put("temporariness", 20);
        rawData.put("puppetry", 191);
        YearlyRecord yr2 = new YearlyRecord(rawData);
        assertEquals(4, yr2.rank("auscultating")); // should print 4
    }
    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(YearlyRecordTest.class);
    }

}