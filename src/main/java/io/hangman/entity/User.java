package io.hangman.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
	
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer userId;
    @Column
    private String userWord;
    @Column
    private String userLetters;
    @Column
	private Integer userFailures;
    @Column
    private Boolean userFinished;
    @Column
    private String userWordPage;
        
	public User() {}

	public User(Integer userId, String userWord) {
		this.userId = userId;
		this.userWord = userWord;
	}

	public User(Integer userId, Integer userFailures, Boolean userFinished, String userLetters) {
		this.userId = userId;
		this.userFailures = userFailures;
		this.userFinished = userFinished;
		this.userLetters = userLetters;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserWordPage() {
		return userWordPage;
	}

	public void setUserWordPage(String userWordPage) {
		this.userWordPage = userWordPage;
	}

	public String getUserLetters() {
		return userLetters;
	}

	public void setUserLetters(String userLetters) {
		this.userLetters = userLetters;
	}

	public Boolean getUserFinished() {
		return userFinished;
	}

	public void setUserFinished(Boolean userFinished) {
		this.userFinished = userFinished;
	}

	public String getUserWord() {
		return userWord;
	}

	public void setUserWord(String userWord) {
		this.userWord = userWord;
	}

	public Integer getUserFailures() {
		return userFailures;
	}

	public void setUserFailures(Integer userFailures) {
		this.userFailures = userFailures;
	}

	public int hits() {
		return getUserLetters().length()-(getUserFailures()==null?0:getUserFailures());
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userWord=" + userWord + ", userLetters=" + userLetters + ", userFailures="
				+ userFailures + ", userFinished=" + userFinished + "]";
	}
    	
 }
