package io.hangman.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Word implements Serializable{
    private static final long serialVersionUID = 1L;
	
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer wordId;
    @Column
    private String wordName;

	public Word() {}

	public Word(Integer wordId, String wordName) {
		this.wordId = wordId;
		this.wordName = wordName;
	}
    
    public Integer getWordId() {
		return wordId;
	}
    
	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}
	
	public String getWordName() {
		return wordName;
	}
	
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
    
}
