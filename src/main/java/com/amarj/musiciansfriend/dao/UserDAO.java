package com.amarj.musiciansfriend.dao;

import java.util.List;

import com.amarj.musiciansfriend.model.User;

public interface UserDAO {
	
	
	//to fetch the list of all the users.
	public List<User>list();
	
	//to fetch the user on the basis of UserID
	public User getUser(String id);
	
	//create and save the record of new users
	public boolean save(User user);
	
	//Update the user record
	public boolean update(User user);
	
	//Validate User by ID and password only
	
	public boolean validate(String userID, String password);
	
	
	//delete user on the basis of userID
     public boolean delete(String id);
	
	  public User deleteUserByID(String id);

	
	
	

}
