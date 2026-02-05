package org.example.databasetablerelations.util;

import org.example.databasetablerelations.payload.request.PaginatedDataRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class Helper {
    public static Pageable getPageable(PaginatedDataRequest request){

        int pageNo = Math.max(request.getPageNo(), 0);
        int pageSize = Math.max(request.getPageSize(), 0);
        String sortBy = (request.getSortBy() != null)? request.getSortBy() : "id";
        Sort.Direction direction = "ASC" .equalsIgnoreCase(request.getSortDirection())?Sort.Direction.ASC:Sort.Direction.DESC;

        return PageRequest.of(pageNo,pageSize, Sort.by(direction,sortBy));
    }
}
