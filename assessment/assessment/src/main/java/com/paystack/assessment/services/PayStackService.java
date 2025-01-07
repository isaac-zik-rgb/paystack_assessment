package com.paystack.assessment.services;


import com.paystack.assessment.dtos.request.PaymentRequestDto;
import com.paystack.assessment.dtos.response.PayStackResponse;
import com.paystack.assessment.dtos.response.ResponseDto;

public interface PayStackService {
    ResponseDto<PayStackResponse> initializePayment(PaymentRequestDto paymentRequestDto);

}
