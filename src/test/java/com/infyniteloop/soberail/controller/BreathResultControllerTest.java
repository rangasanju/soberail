package com.infyniteloop.soberail.controller;

import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.model.BreathResult;
import com.infyniteloop.soberail.response.BreathResultResponse;
import com.infyniteloop.soberail.response.Meta;
import com.infyniteloop.soberail.service.BreathResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BreathResultControllerTest {

    @Mock
    private BreathResultService breathResultService;

    @InjectMocks
    private BreathResultController breathResultController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getBARecordByIdTest() throws ResourceNotFoundException {
        UUID id = UUID.randomUUID();
        BreathResult mockResult = new BreathResult();
        mockResult.setId(id);
        mockResult.setResult(0.08F);

        when(breathResultService.findById(id)).thenReturn(mockResult);

        BreathResult result = breathResultController.getBARecordById(id);

        assertEquals(id, result.getId());
        assertEquals(0.08, result.getResult(), 0.001);
    }


//    @Test
//    void testGetBARecordsByTesterId() throws ResourceNotFoundException {
//        UUID testerId = UUID.randomUUID();
//        int pageNo = 0;
//        int pageSize = 10;
//
//        List<BreathResult> results = new ArrayList<>();
//        results.add(new BreathResult());
//        results.add(new BreathResult());
//
//        Page<BreathResult> page = new PageImpl<>(results);
//
//        Meta meta = Meta.builder().totalRecords(10).totalPages(2).build();
//
//        BreathResultResponse expectedResponse = new BreathResultResponse(page,meta);
//
//        Mockito.when(breathResultService.findAllByTesterId(testerId, pageNo, pageSize)).thenReturn(expectedResponse);
//
//        BreathResultResponse actualResponse = breathResultController.getBARecordsByTesterId(testerId, pageNo, pageSize);
//
//        assertEquals(expectedResponse, actualResponse);
//
//        Mockito.verify(breathResultService, times(1)).findAllByTesterId(testerId, pageNo, pageSize);
//    }
}