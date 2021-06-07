package io.hangman;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.SAXException;

import io.hangman.service.WordService;

@SpringBootApplication
public class BootDesafio {
	@Autowired ResourceLoader resourceLoader;
	@Autowired WordService wordService;

	public static void main(String[] args) {
		SpringApplication.run(BootDesafio.class, args);
	}

	@PostConstruct
	public void setupWords() throws ParserConfigurationException, SAXException, IOException {
		Resource resource = resourceLoader.getResource("classpath:words.xml");
		wordService.init(resource.getInputStream());
	}

}
