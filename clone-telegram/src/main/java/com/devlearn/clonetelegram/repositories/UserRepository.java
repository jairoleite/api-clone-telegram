package com.devlearn.clonetelegram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devlearn.clonetelegram.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "select * from tb_user where name <> ?1 order by name", nativeQuery = true)
	List<User> listAllNotInName(String notIncludeUser);

	@Query(value = "select * from tb_user where uuid = ?1 ", nativeQuery = true)
	User getByUuid(String uuid);
	
	User findByName(String name);
}
