package com.infyniteloop.soberail.response;

import com.infyniteloop.soberail.model.BreathAnalyzer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreathAnalyzerResponse {
    private List<BreathAnalyzer> records;
}
