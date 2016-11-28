package ngordnet;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Collection;
import java.lang.Math;

public class YearlyRecord  {

    private Map<String,Integer> words;
    private TreeMap<String, Number> sortedWords;
    private YearlyComparator comparater;


    /** Creates a new empty YearlyRecord. */
    public YearlyRecord(){
        this(new HashMap<String, Integer>());
    }

    /** Creates a YearlyRecord using the given data. */
    public YearlyRecord(HashMap<String, Integer> otherCountMap){
        this.words = otherCountMap;
        comparater = new YearlyComparator();
        sortedWords = new TreeMap<String, Number>(comparater);
        sortedWords.putAll(otherCountMap);
    }

     /** Returns the number of times WORD appeared in this year. */
    public int count(String word) {
        return words.get(word);
    }

    /** Records that WORD occurred COUNT times in this year. */
    public void put(String word, int count) {
        words.put(word,count);
        sortedWords.put(word, count);
    }
    /** Returns the number of words recorded this year. */
    public int size(){
        return sortedWords.size();
    }

    /** Returns all words in ascending order of count. */
    public Collection<String> words() {
        return sortedWords.keySet();
    }

   private class YearlyComparator implements Comparator<String> {

        private Map<String, Integer> wordsCopy;

        public YearlyComparator() {
            this.wordsCopy = words;
        }

        public int compare(String x, String y) {
            if (wordsCopy.get(x).intValue() <= wordsCopy.get(y).intValue()) {
                return -1;
            }
            return 1;     
        }
    }

    /** Returns all counts in ascending order of count. */
    public Collection<Number> counts() {
        return sortedWords.values();
    }

    /** Returns rank of WORD. Most common word is rank 1. 
    * If two words have the same rank, break ties arbitrarily. 
    * No two words should have the same rank.
    */
    public int rank(String word) {
        Integer rank = words.get(word);
        Integer[] rankings = sortedWords.values().toArray(new Integer[size()]);
        int index = Arrays.binarySearch(rankings, rank) + 1;
        return Math.abs(index - size()) + 1;
    }

}


