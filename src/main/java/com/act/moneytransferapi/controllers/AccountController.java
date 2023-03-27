package com.act.moneytransferapi.controllers;

import com.act.moneytransferapi.domains.Account;
import com.act.moneytransferapi.repositories.AccountRepository;
import com.act.moneytransferapi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @Autowired
//    private AccountRepository accountRepository;

    @PostMapping("/api/accounts")
    public ResponseEntity<?> createAccount(@RequestBody Account account) {

        try {
            Account savedAccount = accountService.registerAccount(account);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedAccount);
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                                .body("{\"error\":" + ex.getMessage() + "}");

        }
    }

    @GetMapping("/api/accounts")
    public Iterable<Account> getAllAccounts() {
        return accountService.getAllAccounts();
//        return accountRepository.findAll();
    }
}
