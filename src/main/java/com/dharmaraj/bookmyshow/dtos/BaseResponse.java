package com.dharmaraj.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private ResponseStatus responseStatus;

    private Object message;
}
