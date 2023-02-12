package com.infyniteloop.soberail.repository;

import com.infyniteloop.soberail.model.BreathResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BreathResultRepository extends JpaRepository<BreathResult, UUID> {
}
