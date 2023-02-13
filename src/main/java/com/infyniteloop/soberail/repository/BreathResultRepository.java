package com.infyniteloop.soberail.repository;

import com.infyniteloop.soberail.model.BreathResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BreathResultRepository extends JpaRepository<BreathResult, UUID> {

    public Page<BreathResult> findByTesterId(UUID id, Pageable paging);
}
