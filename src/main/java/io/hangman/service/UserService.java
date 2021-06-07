package io.hangman.service;

import java.util.List;

import io.hangman.dto.UserDto;
import io.hangman.dto.WordDto;
import io.hangman.entity.User;

public interface UserService {
	static int MAX_FAILURES = 6;
	
	UserDto reset(UserDto userDto, WordDto wordDto);
	UserDto checkLetter(Integer userId, String letter);
    UserDto getUserById(Integer userId);
    void saveUser(UserDto userDto);
    List<UserDto> getAllUsers();
    List<User> getAllUsersNaked();
}
