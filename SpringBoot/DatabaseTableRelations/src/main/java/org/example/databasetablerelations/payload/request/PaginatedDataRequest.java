package org.example.databasetablerelations.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginatedDataRequest {
    private int pageNo;
    private int pageSize;
    private String sortBy;
    private String sortDirection;
}
