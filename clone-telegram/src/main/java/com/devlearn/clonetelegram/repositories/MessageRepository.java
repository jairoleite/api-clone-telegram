package com.devlearn.clonetelegram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devlearn.clonetelegram.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query(value = "select * from tb_message where user_uuid = ?1", nativeQuery = true)
	List<Message> listByUserUuid(String uuid);
}
