package com.devlearn.clonetelegram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devlearn.clonetelegram.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from tb_user where uuid = ?1 ", nativeQuery = true)
	User getByUuid(String uuid);
	
	User findByName(String name);
}
