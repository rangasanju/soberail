package com.infyniteloop.soberail.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Meta {
    private long totalRecords;
    private long totalPages;
}
