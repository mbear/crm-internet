/**
 * 
 */
package com.zhisland.data.crm_internet.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhisland.data.crm_internet.entities.User;
import com.zhisland.data.crm_internet.mappers.UserMapper;

/**
 * @author Siva
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private UserMapper userMapper;
	
	public User findUserById(Integer userId) {
		return userMapper.findUserById(userId);
	}

	public List<User> findAllUsers() {
		return userMapper.findAllUsers(); 
	}
}
