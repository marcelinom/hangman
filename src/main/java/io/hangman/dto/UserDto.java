package io.hangman.dto;

import java.util.Arrays;

public class UserDto {
    Integer userId;
	Integer userFailures;
	Boolean userGuessed;
    Boolean userFinished;
    String userLetters;
    char[] wordIdxs;

    public UserDto() {}
    
    public UserDto(Integer userId) {
		this.userId = userId;
	}

	public UserDto(Integer userId, Integer userFailures, Boolean userFinished, String userLetters) {
		this.userId = userId;
		this.userFailures = userFailures;
		this.userFinished = userFinished;
		this.userLetters = userLetters;
	}

	public UserDto(Integer userId, Integer userFailures, Boolean userGuessed,
			Boolean userFinished, char[] wordIdxs) {
		this.userId = userId;
		this.userFailures = userFailures;
		this.userGuessed = userGuessed;
		this.userFinished = userFinished;
		this.wordIdxs = wordIdxs;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserLetters() {
		return userLetters;
	}

	public void setUserLetters(String userLetters) {
		this.userLetters = userLetters;
	}

	public Integer getUserFailures() {
		return userFailures;
	}

	public void setUserFailures(Integer userFailures) {
		this.userFailures = userFailures;
	}

	public Boolean getUserGuessed() {
		return userGuessed;
	}

	public void setUserGuessed(Boolean userGuessed) {
		this.userGuessed = userGuessed;
	}

	public Boolean getUserFinished() {
		return userFinished;
	}

	public void setUserFinished(Boolean userFinished) {
		this.userFinished = userFinished;
	}

	public char[] getWordIdxs() {
		return wordIdxs;
	}

	public void setWordIdxs(char[] wordIdxs) {
		this.wordIdxs = wordIdxs;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userFailures=" + userFailures + ", userGuessed=" + userGuessed
				+ ", userFinished=" + userFinished + ", userLetters=" + userLetters + ", wordIdxs="
				+ Arrays.toString(wordIdxs) + "]";
	}
	
}
