package com.infyniteloop.soberail.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreathResultResponse {
    private BreathResultResponseList data;
    private Meta meta;


}
