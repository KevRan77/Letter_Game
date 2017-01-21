package fr.esiea.Ranaivo_Remy.dictionary;

import org.junit.Before;

import fr.esiea.Ranaivo_Remy.dictionary.IDictionary;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Unit test sample for Dictionary.
 */
public class DictionaryTest {

    private IDictionary dictionary;

    @Before
    public void setup() {
        //TODO
    }

    public void testIsWord() {
        assertTrue(dictionary.isWord("maman"));
        assertFalse(dictionary.isWord("namam"));
    }
}
