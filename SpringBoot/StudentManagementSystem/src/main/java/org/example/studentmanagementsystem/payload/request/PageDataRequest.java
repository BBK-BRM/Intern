package org.example.studentmanagementsystem.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDataRequest {
    private int pageNo;
    private int size;
    private String sortBY;
    private String sortDirection;
}
