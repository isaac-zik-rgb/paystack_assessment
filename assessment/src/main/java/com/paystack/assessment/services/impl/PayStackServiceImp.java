package com.paystack.assessment.services.impl;

import com.paystack.assessment.dtos.request.PaymentRequestDto;
import com.paystack.assessment.dtos.response.PayStackResponse;
import com.paystack.assessment.dtos.response.ResponseDto;
import com.paystack.assessment.dtos.response.VerificationResponseDto;
import com.paystack.assessment.services.PayStackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayStackServiceImp implements PayStackService {
    private final RestClientService restClientService;
    @Override
    public ResponseDto<PayStackResponse> initializePayment(PaymentRequestDto paymentRequestDto) {
        paymentRequestDto.setReference(UUID.randomUUID().toString().substring(12));
        paymentRequestDto.setCallback_url("https://paystack-assessment.vercel.app/dashboard.html");
        return restClientService.initializePayment(paymentRequestDto);
    }

    @Override
    public ResponseDto<VerificationResponseDto> verifyTransaction(String txRef) {
        log.info("making request to restclient with tx_ref: {}", txRef);
        return restClientService.verifyTransaction(txRef);
    }
}
