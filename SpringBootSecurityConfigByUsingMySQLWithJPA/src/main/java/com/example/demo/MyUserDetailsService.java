package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.model.MyUserDetails;
import com.example.demo.model.User;

@Component
public class MyUserDetailsService  implements UserDetailsService{
	
	@Autowired
	UserRepository respository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		  Optional<User> findByUserName = respository.findByUserName(userName);
		  
		  findByUserName.orElseThrow(()->new UsernameNotFoundException("Not Found"+userName));
		  
		  return findByUserName.map(MyUserDetails::new).get();
	}

	
	
}
