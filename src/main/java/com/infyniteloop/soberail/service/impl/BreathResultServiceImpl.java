package com.infyniteloop.soberail.service.impl;

import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.mapper.BreathResultMapper;
import com.infyniteloop.soberail.model.BreathResult;
import com.infyniteloop.soberail.repository.BreathResultRepository;
import com.infyniteloop.soberail.response.BreathResultResponse;
import com.infyniteloop.soberail.response.BreathResultResponseList;
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

    @Autowired
    BreathResultMapper mapper;

    @Override
    public BreathResultResponse findAll(int pageNo, int pageSize) {

        // Prepare page information
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<BreathResult> pagedResult = repository.findAll(paging);

        if (pagedResult.hasContent()) {

            BreathResultResponseList records = BreathResultResponseList.builder()
                    .records(pagedResult.map(mapper::toDto).getContent())
                    .build();

            return BreathResultResponse.builder()
                    .data(records)
                    .meta(new Meta(pagedResult.getTotalElements(), pagedResult.getTotalPages()))
                    .build();

        } else {
            // else return empty reponse
            return BreathResultResponse.builder()
                    .data(new BreathResultResponseList(new ArrayList<>()))
                    .meta(new Meta())
                    .build();
        }

    }

    @Override
    public BreathResultResponse findAllByTesterId(UUID id, int pageNo, int pageSize) {
        // Prepare page information
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<BreathResult> pagedResult = repository.findByTesterId(id, paging);


        if (pagedResult.hasContent()) {

            BreathResultResponseList records = BreathResultResponseList.builder()
                    .records(pagedResult.map(mapper::toDto).getContent())
                    .build();

            return BreathResultResponse.builder()
                    .data(records)
                    .meta(new Meta(pagedResult.getTotalElements(), pagedResult.getTotalPages()))
                    .build();

        } else {
            // else return empty reponse
            return BreathResultResponse.builder()
                    .data(new BreathResultResponseList(new ArrayList<>()))
                    .meta(new Meta())
                    .build();
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
            throw new ResourceNotFoundException("Record with id  " + id + " Not Found ");

        return breathResult.get();
    }

}
