package com.infyniteloop.soberail.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Meta;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreathResultDto {
    private BreathResultResponse data;
    private Meta meta;


}
