package io.hangman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.hangman.dto.UserDto;
import io.hangman.dto.WordDto;
import io.hangman.entity.User;
import io.hangman.service.UserService;
import io.hangman.service.WordService;


@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired UserService userService;
	@Autowired WordService wordService;

	@RequestMapping(value= "/reset/{userId}", method= RequestMethod.PUT)
	public UserDto reset(@PathVariable Integer userId) {
		WordDto wordDto = wordService.reset();
		UserDto userDto = userService.getUserById(userId);
		return userService.reset(userDto, wordDto);
	}
	
	@RequestMapping(value= "/checkLetter/{userId}/{letter}", method= RequestMethod.PUT)
	public UserDto checkLetter(@PathVariable Integer userId, @PathVariable String letter) {
		return userService.checkLetter(userId, letter);
	}
	
	@RequestMapping("/getUser/{userId}")
	public UserDto getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}
	
	@RequestMapping("/getAllUsers")
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/getAllUsersNaked")
	public List<User> getAllUsersNaked() {
		return userService.getAllUsersNaked();
	}
	
	@RequestMapping(value= "/saveUser", method= RequestMethod.POST)
	public void saveUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
	}
}
