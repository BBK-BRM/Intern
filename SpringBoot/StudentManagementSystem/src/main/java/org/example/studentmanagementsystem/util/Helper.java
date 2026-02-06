package org.example.studentmanagementsystem.util;

import org.example.studentmanagementsystem.payload.request.PageDataRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Helper {
    public static Pageable getPage(PageDataRequest request) {
        int pageNo = Math.max(request.getPageNo(), 0);
        int pageSize = Math.max(request.getSize(), 0);
        String sortBy = request.getSortBY() != null ? request.getSortBY() : "id";
        Sort.Direction direction = "asc".equalsIgnoreCase(request.getSortDirection())
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;
        return PageRequest.of(pageNo, pageSize, Sort.by(direction,sortBy));
    }
}
