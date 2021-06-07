package io.hangman.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import io.hangman.converter.WordConverter;
import io.hangman.dto.WordDto;
import io.hangman.entity.Word;
import io.hangman.repository.WordRepository;
import io.hangman.service.WordService;

@Service
public class WordServiceimpl implements WordService {
	@Autowired WordRepository wordRepository;

	@Override
	public WordDto reset() {
		List<WordDto> allWords = wordRepository.findAll().stream().map(WordConverter::entityToDto).collect(Collectors.toList());
		if (allWords.size()>0) {
			return allWords.get((int) Math.ceil(Math.random()*(allWords.size()-1)));						
		} else return null;
	}

	@Override
	public void init(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
		DefaultHandler handler = new DefaultHandler() {
			boolean tokenWord = false;

			public void startElement(String uri, String localName, String qName, Attributes attributes)	throws SAXException {
				if (qName.equalsIgnoreCase("word"))
					tokenWord = true;
			}

			public void characters(char ch[], int start, int length) throws SAXException {
				if (tokenWord) {
					String w = new String(ch, start, length);
					if (w.length()>0) {
						Word wd = new Word(null, w.toUpperCase());
						wordRepository.save(wd);
					}
					tokenWord = false;
				}
			}
		};
 		saxParser.parse(inputStream, handler);
	}

	@Override
	public void saveWord(WordDto wordDto) {
		wordRepository.save(WordConverter.dtoToEntity(wordDto));		
	}

	@Override
	public List<WordDto> getAllWords() {
 		return wordRepository.findAll().stream().map(WordConverter::entityToDto).collect(Collectors.toList());
	}

}
