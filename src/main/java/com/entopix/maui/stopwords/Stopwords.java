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

	public Stopwords(List<String> words) {
		stopwords.addAll(words);
	}

	public Stopwords(InputStream input) {
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
