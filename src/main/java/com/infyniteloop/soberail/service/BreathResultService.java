package com.infyniteloop.soberail.service;

import com.infyniteloop.soberail.dto.BreathResultDto;
import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.model.BreathResult;
import com.infyniteloop.soberail.response.BreathResultResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public interface BreathResultService {
    public Page<BreathResultDto> findAll(int pageNo, int pageSize);

    public Page<BreathResultDto> findAllByTesterId(UUID id, int pageNo, int pageSiz);

    public BreathResult saveBreathResult(BreathResult breathResult);

    public BreathResult findById(UUID id) throws ResourceNotFoundException;


}
