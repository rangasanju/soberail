package com.infyniteloop.soberail.service;

import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.model.BreathResult;
import com.infyniteloop.soberail.response.BreathResultResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public interface BreathResultService {
    public BreathResultResponse findAll(int pageNo, int pageSize);

    public BreathResultResponse findAllByTesterId(UUID id, int pageNo, int pageSiz);

    public BreathResult saveBreathResult(BreathResult breathResult);

    public BreathResult findById(UUID id) throws ResourceNotFoundException;


}
