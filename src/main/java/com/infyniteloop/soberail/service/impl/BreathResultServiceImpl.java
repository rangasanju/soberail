package com.infyniteloop.soberail.service.impl;

import com.infyniteloop.soberail.dto.BreathResultDto;
import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.mapper.BreathResultMapper;
import com.infyniteloop.soberail.model.BreathResult;
import com.infyniteloop.soberail.repository.BreathResultRepository;
import com.infyniteloop.soberail.service.BreathResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class BreathResultServiceImpl implements BreathResultService {

    @Autowired
    BreathResultRepository repository;

    @Autowired
    BreathResultMapper mapper;

    @Override
    public  Page<BreathResultDto> findAll(int pageNo, int pageSize) {

        // Prepare page information
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<BreathResult> pagedResult = repository.findAll(paging);

        return pagedResult.map(mapper::toDto);

    }

    @Override
    public Page<BreathResultDto> findAllByTesterId(UUID id, int pageNo, int pageSize) {
        // Prepare page information
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<BreathResult> pagedResult = repository.findByTesterId(id, paging);

        return pagedResult.map(mapper::toDto);

//        // Check if result has contents
//        if (pagedResult.hasContent()) {
//            return new BreathResultResponse(new BreathResultResponseList(pagedResult.getContent()),
//                    new Meta(pagedResult.getTotalElements(), pagedResult.getTotalPages()));
//        } else {
//            // else return empty reponse
//            return new BreathResultResponse(new BreathResultResponseList(new ArrayList<>()),
//                    new Meta());
//        }
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
