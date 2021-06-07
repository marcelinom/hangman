package io.hangman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.hangman.dto.WordDto;
import io.hangman.service.WordService;

@RequestMapping("/word")
@RestController
public class WordController {
	@Autowired WordService wordService;

	@RequestMapping("/reset")
	public WordDto newWord() {
		return wordService.reset();
	}
	
	@RequestMapping("/getAllWords")
	public List<WordDto> getAllWords() {
		return wordService.getAllWords();
	}
	
	@RequestMapping(value= "/save", method= RequestMethod.POST)
	public void saveWord(@RequestBody WordDto wordDto) {
		wordService.saveWord(wordDto);
	}
}
