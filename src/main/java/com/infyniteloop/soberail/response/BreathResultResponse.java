package com.infyniteloop.soberail.response;

import com.infyniteloop.soberail.model.BreathResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreathResultResponse {
    private List<BreathResult> records;
}
