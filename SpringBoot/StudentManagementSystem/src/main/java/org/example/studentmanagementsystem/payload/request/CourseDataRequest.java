package org.example.studentmanagementsystem.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDataRequest extends PageDataRequest{
    private String searchText;
}
