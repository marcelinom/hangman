package io.hangman.dto;

public class WordDto {
	Integer wordId;
    String wordName;
    
	public WordDto() {
	}

	public WordDto(Integer wordId, String wordName) {
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

	@Override
	public String toString() {
		return "WordDto [wordId=" + wordId + ", wordName=" + wordName + "]";
	}
        	
}
