package com.infyniteloop.soberail.service.impl;

import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.model.BreathResult;
import com.infyniteloop.soberail.repository.BreathResultRepository;
import com.infyniteloop.soberail.response.BreathResultResponseDto;
import com.infyniteloop.soberail.response.BreathResultResponse;
import com.infyniteloop.soberail.response.Meta;
import com.infyniteloop.soberail.service.BreathResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;


@Service
public class BreathResultServiceImpl implements BreathResultService {

    @Autowired
    BreathResultRepository repository;

    @Override
    public BreathResultResponseDto findAll(int pageNo, int pageSize) {

        // Prepare page information
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<BreathResult> pagedResult = repository.findAll(paging);

        // Check if result has contents
        if (pagedResult.hasContent()) {
            return new BreathResultResponseDto(new BreathResultResponse(pagedResult.getContent()),
                    new Meta(pagedResult.getTotalElements(), pagedResult.getTotalPages()));
        } else {
            // else return empty reponse
            return new BreathResultResponseDto(new BreathResultResponse(new ArrayList<>()),
                    new Meta());
        }

    }

    @Override
    public BreathResultResponseDto findAllByTesterId(UUID id, int pageNo, int pageSize) {
        // Prepare page information
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<BreathResult> pagedResult = repository.findByTesterId(id, paging);

        // Check if result has contents
        if (pagedResult.hasContent()) {
            return new BreathResultResponseDto(new BreathResultResponse(pagedResult.getContent()),
                    new Meta(pagedResult.getTotalElements(), pagedResult.getTotalPages()));
        } else {
            // else return empty reponse
            return new BreathResultResponseDto(new BreathResultResponse(new ArrayList<>()),
                    new Meta());
        }
    }

    @Override
    public BreathResult saveBreathResult(BreathResult breathResult) {
        return repository.save(breathResult);
    }

    @Override
    public BreathResult findById(UUID id) throws ResourceNotFoundException {

        Optional<BreathResult> breathResult = repository.findById(id);
        if (!breathResult.isPresent())
            throw new ResourceNotFoundException("Phone number with id  " + id + " Not Found ");

        return breathResult.get();
    }

}
