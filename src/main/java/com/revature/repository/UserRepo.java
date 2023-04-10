package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	
	@Query(value="select * from user where username=?1",nativeQuery=true)
	User getUserByUsername(String username);

}
