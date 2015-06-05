package com.entopix.maui.stopwords;

import java.io.InputStream;

/**
 * Class that can test whether a given string is a stop word. Lowercases all
 * words before the test.
 *
 * @author Eibe Frank (eibe@cs.waikato.ac.nz)
 * @version 1.0
 */
public class StopwordsEnglish extends Stopwords {

    private static final long serialVersionUID = 1L;
    
    /**
     * Default constructor uses a static stopword list
     */
    public StopwordsEnglish() {
        super(StopwordsStatic.ENGLISH);
    }

    public StopwordsEnglish(InputStream input) {
        super(input);
    }
 
}
