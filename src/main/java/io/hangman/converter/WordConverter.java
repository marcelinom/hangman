package io.hangman.converter;

import io.hangman.dto.WordDto;
import io.hangman.entity.Word;

public class WordConverter {
	public static Word dtoToEntity(WordDto wordDto) {
		Word word = new Word(wordDto.getWordId(), wordDto.getWordName());
		return word;
	}

	public static WordDto entityToDto(Word word) {
		WordDto wordDto = new WordDto(word.getWordId(), word.getWordName());
		return wordDto;
	}
}
