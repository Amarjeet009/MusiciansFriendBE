package com.amarj.musiciansfriend.dao;

import java.util.List;

import com.amarj.musiciansfriend.model.Category;
/**
 * @author amarj
 *
 */
public interface CategoryDAO {

	// just declare the method related to CURD operations
	
		//get All Category 
		       /*access_specifire return_type method_name(parameter_list) throw exception_list*/
		
		/*public List<Category> getAllCategorie(Category category);*/
		
		public List<Category>list();
		
		//create category
		
		public boolean save(Category category);
		
		//update category
		//if you want to update by id is not possible. because update depends on other data also
		
		public boolean update(Category category);
		
	    //delete category by id
		
		public boolean delete(String id);
		
	    //delete category by full domain object i.e polymorphism
		
		public boolean delete(Category category);
		
		//get category by id
		
		public Category getCategoryByID(String id);
		
		// if you want to get category by name
		public Category getCategoryByName(String name);
		
}
