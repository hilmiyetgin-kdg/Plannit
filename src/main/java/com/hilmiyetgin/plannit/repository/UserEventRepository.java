package com.hilmiyetgin.plannit.repository;

import com.hilmiyetgin.plannit.domain.Event;
import com.hilmiyetgin.plannit.domain.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
}
