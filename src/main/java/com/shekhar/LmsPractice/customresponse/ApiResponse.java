package com.shekhar.LmsPractice.customresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse {

    private String status;
    private String message;
    private Object data;
}
