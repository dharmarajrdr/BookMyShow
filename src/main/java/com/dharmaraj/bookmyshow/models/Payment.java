package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    private String referenceNumber;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;
}
