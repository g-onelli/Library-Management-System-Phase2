package com.springboot.backend.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.UserInfoDto;
import com.springboot.backend.dto.UserResetDto;
import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/users")
	public List<UserInfo> getAllUsers() {
		List<UserInfo> list = userRepository.findAll();
		return list; 
	}
	@PostMapping("/users")
	public UserInfo postUser(@RequestBody UserInfo user) {
		String password = user.getPassword();
		password = passwordEncoder.encode(password);
		user.setPassword(password);
		return userRepository.save(user);
	}
	//update entire user
	@PutMapping("/users/{id}")
	public UserInfo updateUser(@PathVariable("id") Integer id, @RequestBody UserInfo newUsers) {
		Optional<UserInfo> optional = userRepository.findById(id);
		if(optional.isPresent()) {	
			UserInfo existingUsers = optional.get();
			existingUsers.setUsername(newUsers.getUsername());
			existingUsers.setRole(newUsers.getRole());
			String password = newUsers.getPassword();
			password = passwordEncoder.encode(password);
			existingUsers.setPassword(password);
			return userRepository.save(existingUsers);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
	//update password for a user
	@PutMapping("/users/password/{id}")
	public UserInfo updatePassword(@PathVariable("id") Integer id, @RequestBody UserInfo newUsers) {
		Optional<UserInfo> optional = userRepository.findById(id);
		if(optional.isPresent()) {	
			UserInfo existingUsers = optional.get();
			String password = newUsers.getPassword();
			password = passwordEncoder.encode(password);
			existingUsers.setPassword(password);
			return userRepository.save(existingUsers);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}
	@GetMapping("/login")
	public UserInfoDto login(Principal principal) {
		String username = principal.getName();
		UserInfo info = userRepository.getByUsername(username);
		UserInfoDto dto = new UserInfoDto();
		dto.setId(info.getId());
		dto.setUsername(info.getUsername());
		dto.setRole(info.getRole());
		return dto;
		
	}
	@GetMapping("/role")
	public UserInfoDto role(Principal principal) {
		String username = principal.getName();
		UserInfo info = userRepository.getByUsername(username);
		UserInfoDto dto = new UserInfoDto();
		dto.setRole(info.getRole());
		return dto;
	}
	@GetMapping("/validate-security-answer/{encodedText}")
	public boolean validateSecurityQuestion(@PathVariable("encodedText") String encodedText) {
		boolean status = false;
		String str = new String(Base64.getDecoder().decode(encodedText));
		String[] sarr = str.split("--");
		String username = sarr[0];
		String answer = sarr[1];
		UserInfo info = userRepository.getByUsername(username);
		if(info.getSecurityAnswer().equalsIgnoreCase(answer)) {
			status = true;
		}
		return status;
	}
	@GetMapping("/user/security/info/{username}")
	public UserResetDto getUserInfo(@PathVariable("username") String username) {
		UserInfo info = userRepository.getByUsername(username);
		UserResetDto dto = new UserResetDto(info.getId(), info.getSecurityQuestion(), "");
		return dto;
	}
	@PutMapping("/user/reset-password/{encodedText}")
	public void resetPassword(@PathVariable("encodedText") String encodedText) {
		boolean status=false;
		String str = new String(Base64.getDecoder().decode(encodedText)); 
		//username + '--'+answer
		String[] sarr =str.split("--");
		String username = sarr[0]; 
		String password=sarr[1];

		String encodedPassword = this.passwordEncoder.encode(password);
		userRepository.resetPassword(username,encodedPassword,LocalDate.now());

	}
}
