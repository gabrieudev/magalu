package com.api.magalu.repository;

import com.api.magalu.model.Communication;
import com.api.magalu.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, Long> {
    List<Communication> findByStatusAndDateTimeBefore(Status status, LocalDateTime dateTime);
}
