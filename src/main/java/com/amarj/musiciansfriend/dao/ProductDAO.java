package com.amarj.musiciansfriend.dao;

import java.util.List;

import com.amarj.musiciansfriend.model.Product;

public interface ProductDAO {
	
    public List<Product> list();
	
	public Product get(String id);
	
	public boolean save(Product product);
	
	public boolean delete(String id);

	public Product getDeleteById(String id);

	

}
