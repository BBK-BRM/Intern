package org.example.studentmanagementsystem.payload.response;

import org.example.studentmanagementsystem.exception.GlobalException;

public class GlobalResponseBuilder {
    public static GlobalResponse buildSuccessResponse(String message){
        return GlobalResponse.builder()
                .status(true)
                .message(message)
                .build();
    }

    public static GlobalResponse buildSuccessResponseWithData(String message,Object data){
        return GlobalResponse.builder()
                .status(true)
                .data(data)
                .message(message)
                .build();
    }

    public static GlobalResponse buildFailResponse(GlobalException e){
        return GlobalResponse.builder()
                .status(false)
                .message(e.getMessage())
                .build();
    }

    public static GlobalResponse buildUnknownExceptionResponse(Exception e){
        return GlobalResponse.builder()
                .status(false)
                .message(e.getMessage())
                .build();
    }
}
