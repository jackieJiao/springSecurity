package com.sinoway.houtai.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.houtai.entitys.User;
import com.sinoway.houtai.mapper.UserMapper;



@Service
@Transactional
public class CustomerUserDetailsService implements UserDetailsService {

	protected Logger logger = Logger.getLogger("service");


	
	@Resource
	private UserMapper userMapper;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		System.out.println("loadUserByUsername");
		UserDetails userDetail = null;
		User user=null;
		try {
			
		    user =userMapper.checkUser(username);
		    logger.debug(username);
		    System.out.println(username);
			userDetail = new org.springframework.security.core.userdetails.User(user.getUsername(),
					user.getPassword().toLowerCase(), true, true, true, true, getAuthorities(user.getAccess()));
			System.out.println("UserDetails");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(username);
			logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("Error in retrieving user");
		}

		return userDetail;
	}
	public Collection<GrantedAuthority> getAuthorities(Integer access) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(3);

		logger.debug("Grant ROLE_USER to this user");
		authList.add(new GrantedAuthorityImpl("ROLE_USER"));
		if (access.compareTo(1) == 0) {
			System.out.println("Grant ROLE_ADMIN to this user");
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));

		} 
		return authList;
	}

}
