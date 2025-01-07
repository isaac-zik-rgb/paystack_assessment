package com.paystack.assessment.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {
private String amount;
private String email;
private String reference;
private String callback_url;
}
