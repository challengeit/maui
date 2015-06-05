package com.entopix.maui.main;


import java.io.FileInputStream;

import org.junit.Test;

import com.entopix.maui.filters.MauiFilter;
import com.entopix.maui.stemmers.FrenchStemmer;
import com.entopix.maui.stemmers.Stemmer;
import com.entopix.maui.stopwords.Stopwords;
import com.entopix.maui.stopwords.StopwordsFrench;
import com.entopix.maui.util.DataLoader;


public class FrenchExampleTest {

	/**
	 * @throws Exception
	 */
	@Test
	public void testFrench() throws Exception {
		
		// location of the data
		String trainDir = "src/test/resources/data/term_assignment/train_fr";
		String testDir = "src/test/resources/data/term_assignment/test_fr";
		
		// name of the file for storing the model
		String modelName = "src/test/resources/data/models/french_model";
		
		// language specific settings
		Stemmer stemmer = new FrenchStemmer();
		Stopwords stopwords = new StopwordsFrench();
		String language = "fr";
		String encoding = "UTF-8";
		
		// vocabulary to use for term assignment
		String vocabulary = "src/test/resources/data/vocabularies/agrovoc_fr.rdf.gz";
		String format = "skos";
		
		// how many topics per document to extract
		int numTopicsToExtract = 8;
		
		// maui objects
		MauiModelBuilder modelBuilder = new MauiModelBuilder();
		MauiTopicExtractor topicExtractor = new MauiTopicExtractor();
		
		// Settings for the model builder
		modelBuilder.inputDirectoryName = trainDir;
		modelBuilder.modelName = modelName;
		modelBuilder.vocabularyFormat = format;
		modelBuilder.vocabularyName = vocabulary;
		modelBuilder.stemmer = stemmer;
		modelBuilder.stopwords = stopwords;
		modelBuilder.documentLanguage = language;
		modelBuilder.documentEncoding = encoding;
		modelBuilder.serialize = true;
		
		// Which features to use?
		modelBuilder.setBasicFeatures(true);
		modelBuilder.setKeyphrasenessFeature(true);
		modelBuilder.setFrequencyFeatures(false);
		modelBuilder.setPositionsFeatures(true);
		modelBuilder.setLengthFeature(true);
		modelBuilder.setThesaurusFeatures(true);
		
		// Run model builder
		MauiFilter filter = modelBuilder.buildModel(DataLoader.loadTestDocuments(trainDir));
		modelBuilder.saveModel(filter);
		
		// Settings for the topic extractor
		topicExtractor.inputDirectoryName = testDir;
		topicExtractor.modelName = new FileInputStream(modelName);
		topicExtractor.vocabularyName = vocabulary;
		topicExtractor.vocabularyFormat = format;
		topicExtractor.stemmer = stemmer;
		topicExtractor.stopwords = stopwords;
		topicExtractor.documentLanguage = language;
		topicExtractor.topicsPerDocument = numTopicsToExtract; 
		topicExtractor.cutOffTopicProbability = 0.0;
		topicExtractor.serialize = true;
		
		// Run topic extractor
		topicExtractor.loadModel();
		topicExtractor.extractTopics(DataLoader.loadTestDocuments(testDir));
	}

}
