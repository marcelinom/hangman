package io.hangman.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import io.hangman.dto.WordDto;


public interface WordService {
    WordDto reset();
    void init(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException;
    void saveWord(WordDto wordDto);
    List<WordDto> getAllWords();
}
