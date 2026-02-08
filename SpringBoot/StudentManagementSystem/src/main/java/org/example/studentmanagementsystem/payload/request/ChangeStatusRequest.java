package org.example.studentmanagementsystem.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.studentmanagementsystem.Enum.ChangeStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeStatusRequest {
    private ChangeStatus status;
}
