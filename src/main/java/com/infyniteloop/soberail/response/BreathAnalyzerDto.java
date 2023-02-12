package com.infyniteloop.soberail.response;

import com.infyniteloop.soberail.model.BreathAnalyzer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Meta;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreathAnalyzerDto {
    private BreathAnalyzerResponse data;
    private Meta meta;


}
