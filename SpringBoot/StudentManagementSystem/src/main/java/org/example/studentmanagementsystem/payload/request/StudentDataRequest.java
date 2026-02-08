package org.example.studentmanagementsystem.payload.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDataRequest extends PageDataRequest{
    private String searchText;
}
