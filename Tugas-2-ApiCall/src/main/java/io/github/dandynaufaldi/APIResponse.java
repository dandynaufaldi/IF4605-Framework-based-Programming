package io.github.dandynaufaldi;

import java.util.List;

public class APIResponse {
	private List<Result> results; 
	
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		String res = "";
		for (Result result : results) {
			res += result.toString();
		}
		return res;
	}
}

class Result {
	private String word;
	private String language;
	private List<LexicalEntry> lexicalEntries;
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public List<LexicalEntry> getLexicalEntries() {
		return lexicalEntries;
	}
	
	public void setLexicalEntries(List<LexicalEntry> lexicalEntries) {
		this.lexicalEntries = lexicalEntries;
	}
	
	@Override
	public String toString() {
		String res = "Antonyms for " + word + " in language " + language.toUpperCase() + "\n";
		for (LexicalEntry lexicalEntry : lexicalEntries) {
			res += lexicalEntry.toString();
		}
		return res;
	}
	
}

class LexicalEntry {
	private String language;
	private String lexicalCategory;
	private List<Entry> entries;
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getLexicalCategory() {
		return lexicalCategory;
	}
	
	public void setLexicalCategory(String lexicalCategory) {
		this.lexicalCategory = lexicalCategory;
	}
	
	public List<Entry> getEntries() {
		return entries;
	}
	
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
	
	@Override
	public String toString() {
		String res = "Category: " + lexicalCategory + "\n";
		for (Entry entry : entries) {
			res += entry.toString();
		}
		return res;
	}
}

class Entry {
	private String homographNumber;
	private List<Sense> senses;
	
	public String getHomographNumber() {
		return homographNumber;
	}
	
	public void setHomographNumber(String homographNumber) {
		this.homographNumber = homographNumber;
	}
	
	public List<Sense> getSenses() {
		return senses;
	}
	
	public void setSenses(List<Sense> senses) {
		this.senses = senses;
	}
	
	@Override
	public String toString() {
		String res = "";
		for (Sense sense : senses) {
			res += sense.toString();
		}
		return res;
	}
	
}

class Sense {
	private List<Antonym> antonyms;
	private List<Example> examples;
	
	public List<Antonym> getAntonyms() {
		return antonyms;
	}
	
	public void setAntonyms(List<Antonym> antonyms) {
		this.antonyms = antonyms;
	}
	
	public List<Example> getExamples() {
		return examples;
	}
	
	public void setExamples(List<Example> examples) {
		this.examples = examples;
	}
	
	@Override
	public String toString() {
		String res = "";
		res += "[ANTONYMS]\n";
		for (Antonym antonym : antonyms) {
			res += antonym.toString();
		}
		res += "[EXAMPLE]\n";
		for (Example example : examples) {
			res += example.toString();
		}
		return res;
	}
	
}

class Antonym {
	private String language;
	private String text;
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "- " + this.getText() + "\n";
	}
	
}

class Example {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "- " + this.getText() + "\n";
	}
	
}