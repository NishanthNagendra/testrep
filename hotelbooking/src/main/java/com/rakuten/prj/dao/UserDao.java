/**
 * 
 */
package com.rakuten.prj.dao;

import java.util.List;

import com.rakuten.prj.entity.User;

/**
 * @author nishanth
 *
 */
public interface UserDao {
	User getUser(String userId);
	List<User> getAllUsers();
	void addUser(User u);
}
