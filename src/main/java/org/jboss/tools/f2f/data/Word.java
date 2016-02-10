package org.jboss.tools.f2f.data;

public class Word implements Comparable<Word>{
	
	private String word;
	private int count;
	private Double frequency;
	private Double density;
	
	
	
	
	public Word(String word, int count, Double frequency, Double density) {
		super();
		this.word = word;
		this.count = count;
		this.frequency = frequency;
		this.density = density;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getFrequency() {
		return frequency;
	}
	public void setFrequency(Double frequency) {
		this.frequency = frequency;
	}
	public Double getDensity() {
		return density;
	}
	public void setDensity(Double density) {
		this.density = density;
	}
	@Override
	public int compareTo(Word o) {
		return o.getCount() - count;
	}
	
	

}
