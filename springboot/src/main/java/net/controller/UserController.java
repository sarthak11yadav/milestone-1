package net.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.model.User;
import net.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public String saveUser(@RequestBody User user)
	{
		
		return userService.saveUser(user);
	}
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User>getUserById(@PathVariable("id") long userid)
	{
		return new ResponseEntity<User>(userService.getUserById(userid),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User>updateUser(@PathVariable("id") long id,@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.updateUser(user,id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteUser(@PathVariable("id") long id)
	{
		
		userService.deleteUser(id);
		return new ResponseEntity<String>("User deleted Sucessfully",HttpStatus.OK);
	}
	
	
	
	

}
