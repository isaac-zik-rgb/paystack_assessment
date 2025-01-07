package com.paystack.assessment.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationResponseDto {
    private Long id;
    private String domain;
    private String status;
    private String reference;
    private String receipt_number;
    private BigDecimal amount;
}
