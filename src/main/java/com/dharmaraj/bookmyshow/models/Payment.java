package com.dharmaraj.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel {

    private double amount;
    private PaymentMode paymentMode;
    private String referenceNumber;
    private PaymentStatus status;
}
