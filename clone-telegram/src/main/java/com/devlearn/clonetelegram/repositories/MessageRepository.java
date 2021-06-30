package com.devlearn.clonetelegram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devlearn.clonetelegram.entities.Message;
import com.devlearn.clonetelegram.repositories.interfaces.MessageInterface;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query(value = "SELECT  m.id as msId, m.text, m.view, to_char(m.registry_date,'hh:mm:ss') as date, m.user_uuid as userUuid, u.image   "
			+ "     FROM TB_MESSAGE m   "
			+ "         inner join TB_USER u on u.uuid = m.user_uuid"
			+ "     WHERE"
			+ "         (m.user_uuid = ?1 or m.user_send_uuid = ?1) "
			+ "     order by m.registry_date ", nativeQuery = true)
	List<MessageInterface> listByUserUuid(String uuid);
}
