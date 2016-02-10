package org.jboss.tools.f2f.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Word {
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String word;
	private int density;
	private int count;
	private int frequency;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getDensity() {
		return density;
	}
	public void setDensity(int density) {
		this.density = density;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
