package com.paystack.assessment.controller;

import com.paystack.assessment.dtos.request.PaymentRequestDto;
import com.paystack.assessment.services.PayStackService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/paystack/")
@RequiredArgsConstructor
public class PayStackController {
    private final PayStackService payStackService;


    @PostMapping("payment/initialize")
  public ResponseEntity<?>  initializePayment(@RequestBody PaymentRequestDto paymentRequestDto){
        return ResponseEntity.status(200).body(payStackService.initializePayment(paymentRequestDto));
    }


    @PostMapping("verify-transaction")
    public  ResponseEntity<?> verifyTransaction(@RequestParam String tx_ref){
        return  ResponseEntity.status(200).body(payStackService.verifyTransaction(tx_ref));
    }
}
