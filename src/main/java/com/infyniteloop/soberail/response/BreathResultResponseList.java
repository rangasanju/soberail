package com.infyniteloop.soberail.response;

import com.infyniteloop.soberail.dto.BreathResultDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BreathResultResponseList {
    private List<BreathResultDto> records;
}
