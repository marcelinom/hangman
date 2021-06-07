package io.hangman.converter;

import io.hangman.dto.UserDto;
import io.hangman.entity.User;

public class UserConverter {
	public static User dtoToEntity(UserDto userDto) {
		User user = new User(userDto.getUserId(), userDto.getUserFailures(), userDto.getUserFinished(), userDto.getUserLetters());
		return user;
	}

	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto(user.getUserId(), user.getUserFailures(), user.getUserFinished(), user.getUserLetters());
		if (user.getUserWordPage() != null) userDto.setWordIdxs(user.getUserWordPage().toCharArray());
		return userDto;
	}
}
