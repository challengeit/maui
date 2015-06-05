package com.entopix.maui.stopwords;

import java.io.FileInputStream;

/**
 * Class that can test whether a given string is a stop word. Lowercases all
 * words before the test.
 *
 * @author Eibe Frank (eibe@cs.waikato.ac.nz)
 * @version 1.0
 */
public class StopwordsGerman extends Stopwords {

    private static final long serialVersionUID = 1L;
    
    /**
     * Default constructor uses a static stopword list
     */
    public StopwordsGerman() {
        // http://snowball.tartarus.org/german/stop.txt
        super(StopwordsStatic.GERMAN);
    }

    public StopwordsGerman(FileInputStream input) {
        super(input);
    }
    
}
