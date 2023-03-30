package com.act.moneytransferapi.controllers;

import com.act.moneytransferapi.domains.Account;
import com.act.moneytransferapi.domains.Transfer;
import com.act.moneytransferapi.dto.TransferRequest;
import com.act.moneytransferapi.services.AccountService;
import com.act.moneytransferapi.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.dsig.TransformService;

@RestController
@RequestMapping
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/api/transfers")
    public ResponseEntity<?> transfer(@RequestBody TransferRequest transferRequest) {

        try {
            Transfer transfer = transferService.moneyTransfer(transferRequest);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(transfer);
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                                .body("{\"error\":" + ex.getMessage() + "}");

        }
    }

    @GetMapping("/api/transfers")
    public Iterable<Transfer> getAllTransfers() {
        return transferService.getAllTransfers();
    }
}
