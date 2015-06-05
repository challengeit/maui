package com.entopix.maui.stopwords;

import java.util.HashMap;

/**
 * Class that stores the objects for each language  
 * 
 * @author Challenge.IT
 **/
public class StopwordsMap {

	private HashMap<String, Stopwords> _stopwords;
	
	/**
	 * Creates an instance of {@link StopwordsMap}.
	 */
	public StopwordsMap(){
		_stopwords = new HashMap<String, Stopwords>();
	
		loadStopwords();
	}
	
	/**
	 * Retrieves the stopword according to the language 
	 * @param language The language to be searched
	 * @return the stopwords associated with that language
	 */
	public Stopwords retrieveStopwords(String language) {
		
		if(_stopwords.containsKey(language))
			return _stopwords.get(language);
		
		return _stopwords.get("English");
	}

	/**
	 * Loads the stopwords into the HashMap
	 */
	private void loadStopwords() {
		_stopwords.put("English", new StopwordsEnglish());//StopwordsMap.class.getClassLoader().getResourceAsStream("maui/stopwords/stopwords_en.txt")));
		_stopwords.put("Portuguese", new StopwordsPortuguese());
		_stopwords.put("Galician", new StopwordsPortuguese());//Stopwords.class.getClassLoader().getResourceAsStream("maui/stopwords/stopwords_pt.txt")));
	}
	
	/**
	 * Adds stopwords to the HashMap
	 * @param lang The language of the stopwords
	 * @param stopwords The set of stopwords
	 */
	public void addStopwords(String lang, Stopwords stopwords){
		_stopwords.put(lang, stopwords);
	}

}
