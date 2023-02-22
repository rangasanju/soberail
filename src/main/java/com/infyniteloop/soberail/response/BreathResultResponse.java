package com.infyniteloop.soberail.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BreathResultResponse {
    private BreathResultResponseList data;
    private Meta meta;


}
