package com.hilmiyetgin.plannit.repository;

import com.hilmiyetgin.plannit.domain.Event;
import com.hilmiyetgin.plannit.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByOrganizer(Profile organizer);
}
