package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private double amount;
    private PaymentMode paymentMode;
    private String referenceNumber;
    private PaymentStatus status;
}
