/**
 * 
 */
package com.amarj.musiciansfriend.dao;

import java.util.List;

import com.amarj.musiciansfriend.model.MyCart;

/**
 * @author amarj
 *
 */

public interface MyCartDAO {

public List<MyCart> list(String userID);
	
	public MyCart getCart(long id);
	
	public boolean save(MyCart myCart);
	
	public boolean delete(MyCart myCart);
	
	public boolean update(MyCart myCart);
	
	public Long getTotalAmount(String userID);
	

}
