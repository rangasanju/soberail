package com.infyniteloop.soberail.controller;

import com.infyniteloop.soberail.dto.BreathResultDto;
import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.model.BreathResult;
import com.infyniteloop.soberail.response.BreathResultResponse;
import com.infyniteloop.soberail.service.BreathResultService;
import com.infyniteloop.soberail.system.customannotation.ValidUUID;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/breath-test")
@Validated
@CrossOrigin(origins = "https://editor.swagger.io")
public class BreathResultController {

    @Autowired
    public BreathResultService breathResultService;


    /************************************************************************************************
     * http://localhost:8080/breath-test/all
     *
     * @param
     * @return BreathResultResponseDto
     * @throws
     */
    @GetMapping("/all")
    public ResponseEntity<Page<BreathResultDto>> getAllBARecords(@RequestParam(defaultValue = "0") @Min(value = 0, message = "Page number must be greater than or equal to 0") Integer pageNo,
                                                                 @RequestParam(defaultValue = "10") @Min(value = 1, message = "Page size must be greater than or equal to 1")
                                                  @Max(value = 100, message = "Page size must be less than or equal to 100") Integer pageSize) {
        return new ResponseEntity<>(breathResultService.findAll(pageNo,pageSize), HttpStatus.OK);
    }

    /************************************************************************************************
     * http://localhost:8080/breath-test/{id}
     *
     * @param id
     * @return BreathResult
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public BreathResult getBARecordById(@PathVariable @ValidUUID UUID id) throws ResourceNotFoundException {
        return breathResultService.findById(id);
    }


    /************************************************************************************************
     * http://localhost:8080/breath-test/tester/{id}
     *
     * @param id
     * @return BreathResult
     * @throws ResourceNotFoundException
     */
    @GetMapping("/tester/{id}")
    public ResponseEntity<Page<BreathResultDto>> getBARecordsByTesterId(@PathVariable @ValidUUID UUID id, @RequestParam(defaultValue = "0") @Min(value = 0, message = "Page number must be greater than or equal to 0") Integer pageNo,
                                                       @RequestParam(defaultValue = "10") @Min(value = 1, message = "Page size must be greater than or equal to 1")
                                                          @Max(value = 100, message = "Page size must be less than or equal to 100") Integer pageSize) throws ResourceNotFoundException {
        return new ResponseEntity<>(breathResultService.findAllByTesterId(id, pageNo, pageSize), HttpStatus.OK);
    }


    /************************************************************************************************
     * http://localhost:8080/breath-test
     *
     * @param result
     * @return BreathResultResponseDto
     * @throws
     */
    @PostMapping()
    public BreathResult addBreathTestRecord(@RequestBody BreathResult result) {
        return breathResultService.saveBreathResult(result);
    }
}
