package com.paystack.assessment.services.impl;

import com.paystack.assessment.dtos.request.PaymentRequestDto;
import com.paystack.assessment.dtos.response.PayStackResponse;
import com.paystack.assessment.dtos.response.ResponseDto;
import com.paystack.assessment.services.PayStackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PayStackServiceImp implements PayStackService {
    private final RestClientService restClientService;
    @Override
    public ResponseDto<PayStackResponse> initializePayment(PaymentRequestDto paymentRequestDto) {
        paymentRequestDto.setReference(UUID.randomUUID().toString());
        paymentRequestDto.setCallback_url("http://www.dashboard.com");
        return restClientService.initializePayment(paymentRequestDto);
    }
}