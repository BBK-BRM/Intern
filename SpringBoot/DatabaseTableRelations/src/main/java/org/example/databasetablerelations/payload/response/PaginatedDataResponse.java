package org.example.databasetablerelations.payload.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginatedDataResponse {
    private int totalPageNo;
    private Object data;
}
