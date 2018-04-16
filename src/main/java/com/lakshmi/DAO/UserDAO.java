package com.lakshmi.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lakshmi.domain.User;
public interface UserDAO {

	public void registerUser(User user);
	public boolean isUserExists(String username,String password);
	User retrievUser(Integer userId);
	public void deleteUser(Integer userId);
	
	
	List<User> findByEmail(String email);	
	List<User> userList();
	
	
	
	

}
