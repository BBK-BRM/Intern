package org.example.studentmanagementsystem.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalResponse {
    private boolean status;
    private String code;
    private String message;
    private Object data;
}
