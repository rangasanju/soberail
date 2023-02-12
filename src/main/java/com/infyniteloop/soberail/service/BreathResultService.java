package com.infyniteloop.soberail.service;

import com.infyniteloop.soberail.model.BreathResult;
import com.infyniteloop.soberail.response.BreathResultDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public interface BreathResultService {
    public List<BreathResultDto> findAll();

    public BreathResult saveBreathResult();

    public BreathResult findById(UUID id);

    public BreathResult findByTesterId(UUID id);

}
