package com.infyniteloop.soberail.repository;

import com.infyniteloop.soberail.model.BreathResult;
import com.infyniteloop.soberail.response.BreathResultResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BreathResultRepository extends JpaRepository<BreathResult, UUID> {

    public Page<BreathResult> findAllByTesterId(UUID id, Pageable paging);
}
