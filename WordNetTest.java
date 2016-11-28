package ngordnet;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class WordNetTest {

    @Test
    public void basicIsNoun1() {
        WordNet w = new WordNet("./wordnet/synsets.txt", "./wordnet/hyponyms.txt");
        assertEquals(true, w.isNoun("jump"));        
        assertEquals(true, w.isNoun("leap"));
        assertEquals(true, w.isNoun("nasal_decongestant"));
    }

    @Test
    public void basicIsNoun2() {
        WordNet w = new WordNet("./wordnet/synsets11.txt", "./wordnet/hyponyms11.txt");
        assertEquals(true, w.isNoun("jump"));        
        assertEquals(true, w.isNoun("leap"));
        assertEquals(true, w.isNoun("nasal_decongestant"));
    }

    @Test
    public void basicNouns3() {
        WordNet wn = new WordNet("./wordnet/synsets11.txt", "./wordnet/hyponyms11.txt");
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for (String noun : wn.nouns()) {
            words.put(noun, 1);
        }
        assertEquals(true, words.containsKey("augmentation"));
        assertEquals(true, words.containsKey("nasal_decongestant"));
        assertEquals(true, words.containsKey("change"));
        assertEquals(true, words.containsKey("action"));
        assertEquals(true, words.containsKey("antihistamine"));
        assertEquals(true, words.containsKey("increase"));
        assertEquals(true, words.containsKey("descent"));
        assertEquals(true, words.containsKey("parachuting"));
        assertEquals(true, words.containsKey("leap"));
        assertEquals(true, words.containsKey("demotion"));
        assertEquals(true, words.containsKey("jump"));
        assertEquals(true, words.containsKey("actifed"));

    }

    @Test
    public void basicHyponyms1() {
        WordNet wn = new WordNet("./wordnet/synsets11.txt", "./wordnet/hyponyms11.txt");
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for (String noun : wn.hyponyms("increase")) {
            words.put(noun, 1);
        }
        assertEquals(true, words.containsKey("augmentation"));
        assertEquals(true, words.containsKey("increase"));
        assertEquals(true, words.containsKey("leap"));
        assertEquals(true, words.containsKey("jump"));
        assertEquals(false, words.containsKey("demotion"));
        assertEquals(false, words.containsKey("parachuting"));
        assertEquals(4, words.size());
    }

    @Test
    public void basicHyponyms2() {
        WordNet wn = new WordNet("./wordnet/synsets11.txt", "./wordnet/hyponyms11.txt");
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for (String noun : wn.hyponyms("jump")) {
            words.put(noun, 1);
        }
        assertEquals(true, words.containsKey("parachuting"));
        assertEquals(true, words.containsKey("leap"));
        assertEquals(true, words.containsKey("jump"));
        assertEquals(false, words.containsKey("demotion"));
        assertEquals(3, words.size());
    }

    @Test
    public void basicHyponyms3() {
        WordNet wn2 = new WordNet("./wordnet/synsets14.txt", "./wordnet/hyponyms14.txt");
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for (String noun : wn2.hyponyms("change")) {
            words.put(noun, 1);
        }      
        assertEquals(true, words.containsKey("alteration"));
        assertEquals(true, words.containsKey("saltation"));
        assertEquals(true, words.containsKey("modification"));
        assertEquals(true, words.containsKey("change"));
        assertEquals(true, words.containsKey("variation"));
        assertEquals(true, words.containsKey("increase"));
        assertEquals(true, words.containsKey("transition"));
        assertEquals(true, words.containsKey("demotion"));
        assertEquals(true, words.containsKey("leap"));
        assertEquals(true, words.containsKey("jump"));
        assertEquals(10, words.size());        
    }


    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(WordNetTest.class);
    }

}