package com.paystack.assessment.services.impl;

import com.paystack.assessment.dtos.request.PaymentRequestDto;
import com.paystack.assessment.dtos.response.PayStackResponse;
import com.paystack.assessment.dtos.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestClientService {
    private final RestClient payStackRestClient;
    @Value("${paystack.test.key}")
    private String payStackToken;


    public ResponseDto<PayStackResponse> initializePayment(PaymentRequestDto paymentRequestDto) {
       log.info("making request to paysatck");
        ResponseEntity<ResponseDto<PayStackResponse>> response =
                payStackRestClient.post()
                        .uri("transaction/initialize")
                        .header("Authorization", "Bearer " + payStackToken)
                        .header("Content-Type", "application/json")
                        .body(paymentRequestDto)
                        .retrieve()
                        .toEntity(new ParameterizedTypeReference<>() {
                        });

        log.info("done making request");
        log.info("logging body: {}", response.getBody().getData());
        return response.getBody();
    }
}
