package io.hangman.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hangman.converter.UserConverter;
import io.hangman.dto.UserDto;
import io.hangman.dto.WordDto;
import io.hangman.entity.User;
import io.hangman.repository.UserRepository;
import io.hangman.service.UserService;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto reset(UserDto userDto, WordDto wordDto) {
		User user = null;
		if (userDto == null) user = new User(null, wordDto.getWordName());
		else user = new User(userDto.getUserId(), wordDto.getWordName());
		user.setUserWordPage(wordDto.getWordName().replaceAll(".", "-"));
		user = userRepository.save(user);
		return UserConverter.entityToDto(user);
	}	
	
	@Override
	public UserDto checkLetter(Integer userId, String letter) {
		User user = userRepository.getOne(userId);
		if (user == null || user.getUserWord()==null || Boolean.TRUE.equals(user.getUserFinished())) {
			return null;
		} else if (letter == null || letter.length()==0 || (user.getUserLetters()!=null && user.getUserLetters().contains(letter.toUpperCase().substring(0, 1)))) {
			return UserConverter.entityToDto(user);
		} else {
			int lastIdx = -1;
			Boolean guessed = null;
			char testCh = letter.toUpperCase().charAt(0);
			user.setUserLetters(user.getUserLetters()==null?Character.toString(testCh):user.getUserLetters()+testCh);
			StringBuilder wordPage = new StringBuilder(user.getUserWordPage());
			do {
				lastIdx = user.getUserWord().indexOf(testCh, lastIdx+1);	
				if (lastIdx>-1) {
					wordPage.setCharAt(lastIdx, testCh);
				} else if (user.getUserWordPage().equals(wordPage.toString())) {
					user.setUserFailures(user.getUserFailures()==null?1:user.getUserFailures()+1);
					if (user.getUserFailures()>=MAX_FAILURES) {
						user.setUserFinished(true);
						guessed = false;
					}
				}
			} while (lastIdx>-1 && lastIdx < user.getUserWord().length()-1);
			
			user.setUserWordPage(wordPage.toString());
			if (!Boolean.TRUE.equals(user.getUserFinished())) {
				if (user.getUserWordPage().equals(user.getUserWord())) {
					user.setUserFinished(true);
					guessed = true;
				}
			}
			
			UserDto dto = UserConverter.entityToDto(user);
			dto.setUserGuessed(guessed);
			userRepository.save(user);
			return dto;
		}		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = null;
		try {
			user = userRepository.getOne(userId);
			if (user != null) return UserConverter.entityToDto(user);
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public void saveUser(UserDto userDto) {
		userRepository.save(UserConverter.dtoToEntity(userDto));
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
	}
	
	@Override
	public List<User> getAllUsersNaked() {
		return userRepository.findAll();
	}
}
