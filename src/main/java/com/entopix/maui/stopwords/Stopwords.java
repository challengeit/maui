package com.entopix.maui.stopwords;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that can test whether a given string is a stop word. Lowercases all
 * words before the test.
 *
 * @author Eibe Frank (eibe@cs.waikato.ac.nz)
 * @version 2.0
 */
public abstract class Stopwords implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(Stopwords.class);
    
    private static final long serialVersionUID = 1L;

    protected Set<String> stopwords = new HashSet<String>();
    private Hashtable<String, Double> m_Stopwords = null;

    public Stopwords(List<String> words) {
        stopwords.addAll(words);
    }
    
    public Stopwords(InputStream input) {
        //File txt = new File(filePath);
        InputStreamReader is;
        String sw;
        try {
            is = new InputStreamReader(input, "UTF-8");
            BufferedReader br = new BufferedReader(is);
            while ((sw = br.readLine()) != null) {
               
                    stopwords.add(sw);
                
            }
            br.close();
        } catch (IOException e) {
            log.error("Unable to read stopwords", e);
        }
    	
//    	if (m_Stopwords == null) {
//			m_Stopwords = new Hashtable<String, Double>();
//			Double dummy = new Double(0);
//			InputStreamReader is;
//			String sw = null;
//			try {
//				is = new InputStreamReader(input, "UTF-8");
//				BufferedReader br = new BufferedReader(is);
//				while ((sw = br.readLine()) != null) {
//					m_Stopwords.put(sw, dummy);
//				}
//				br.close();
//			} catch (Exception e) {
//				System.err.println(String.format("Could not load the stopwords"));
//			}
//
//		}
    }

    /**
     * Note: this method doesn't lowercase the input to stay generic
     * @param word to test
     * @return True if the given string is a stop word.
     */
    public boolean isStopword(String word) {
    	return stopwords.contains(word.toLowerCase());
    }
}
