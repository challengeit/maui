package com.entopix.maui.stopwords;

import java.util.HashMap;

/**
 * Class that stores the objects for each language  
 * 
 * @author Challenge.IT
 **/
public class StopwordsMap {

	private static HashMap<String, Stopwords> stopwords;
	

	/**
	 * Retrieves the stopword according to the language 
	 * @param language The language to be searched
	 * @return the stopwords associated with that language
	 */
	public static Stopwords retrieveStopwords(String language) {
		
		if(stopwords.containsKey(language))
			return stopwords.get(language);
		
		return stopwords.get("English");
	}

	/**
	 * Loads the stopwords into the HashMap
	 */
	static {
		stopwords = new HashMap<String, Stopwords>();
		stopwords.put("English", new StopwordsEnglish());
		stopwords.put("Portuguese", new StopwordsPortuguese());
		stopwords.put("Galician", new StopwordsPortuguese());
	}
	
	/**
	 * Adds stopwords to the HashMap
	 * @param lang The language of the stopwords
	 * @param newStopwords The set of stopwords
	 */
	public static void addStopwords(String lang, Stopwords newStopwords){
		stopwords.put(lang, newStopwords);
	}

}
