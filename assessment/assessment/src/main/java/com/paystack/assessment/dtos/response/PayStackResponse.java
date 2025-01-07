package com.paystack.assessment.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayStackResponse {
    private String authorization_url;
    private String reference;
    private String access_code;
}
