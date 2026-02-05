package org.example.databasetablerelations.payload.response;

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
             .message(message)
             .data(data)
             .build();
 }
}
