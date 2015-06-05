package com.entopix.maui.stopwords;

import java.io.InputStream;

public class StopwordsPortuguese extends Stopwords {

    private static final long serialVersionUID = 1L;
    
    /**
     * Default constructor uses a static stopword list
     * @param inputStream 
     */
    public StopwordsPortuguese() {
        super(StopwordsStatic.PORTUGUESE);
    }

    public StopwordsPortuguese(InputStream input) {
        super(input);
    }

}
