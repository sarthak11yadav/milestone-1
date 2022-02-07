package net.service.impl;

import net.model.User;
import net.repository.UserRepository;
import net.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import net.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public boolean userNotExist(User user){

        User findByFirstName = userRepository.findByFirstName(user.getFirstName());
        User findByEmail = userRepository.findByEmail( user.getEmail());
        User findByNumber = userRepository.findByNumber(user.getNumber());

        if(findByFirstName==null && findByEmail==null && findByNumber==null ){
            return true;
        }else{
            return false;
        }

    }
	
	
	
	@Override
	public String saveUser(User user)
	{    
		
		
		if(userNotExist(user)){
            userRepository.save(user);
             return "Stored";
        }else{
            return "User Already Exist";
        }

		
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		Optional<User> user=userRepository.findById(id);
		
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			throw new ResourceNotFoundException("User","Id",id);
		}
		
	}

	@Override
	public User updateUser(User user, long id) {
		
		
	User existingUser=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
	
	existingUser.setFirstName(user.getFirstName());
	existingUser.setLastName(user.getLastName());
	existingUser.setEmail(user.getEmail());
	existingUser.setAddress(user.getAddress());
	existingUser.setNumber(user.getNumber());
	userRepository.save(existingUser);
	
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
		userRepository.deleteById(id);
		
		
	}
	

}
