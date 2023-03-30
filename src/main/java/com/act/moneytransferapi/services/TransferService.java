package com.act.moneytransferapi.services;

import com.act.moneytransferapi.domains.Account;
import com.act.moneytransferapi.domains.Transfer;
import com.act.moneytransferapi.dto.TransferRequest;
import com.act.moneytransferapi.repositories.AccountRepository;
import com.act.moneytransferapi.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired private TransferRepository transferRepository;

    public Transfer moneyTransfer(TransferRequest transferRequest) throws Exception {

        if (transferRequest.getSenderAccountId() == null || transferRequest.getReceiverAccountId() == null) {
            throw new Exception("Sender account or receiver account is empty");
        }

        if (transferRequest.getSenderAccountId().equals(transferRequest.getReceiverAccountId())) {
            throw new Exception("Sender account and receiver account cannot be the same");
        }

        Account senderAccount = accountRepository.findById(transferRequest.getSenderAccountId()).get();
        Account receiverAccount = accountRepository.findById(transferRequest.getReceiverAccountId()).get();

        if(senderAccount.getBalance() < transferRequest.getAmount()) {
            throw new Exception("Insufficient Balance. Sender doesn't have enough balance to send.");
        }

        Double newSenderBalance = senderAccount.getBalance() - transferRequest.getAmount();
        senderAccount.setBalance(newSenderBalance);
        accountRepository.save(senderAccount);

        Double newReceiverBalance = receiverAccount.getBalance() + transferRequest.getAmount();
        receiverAccount.setBalance(newReceiverBalance);
        accountRepository.save(receiverAccount);

        Transfer transfer = Transfer.builder()
                .senderAccount(senderAccount)
                .receiverAccount(receiverAccount)
                .amount(transferRequest.getAmount())
                .reason(transferRequest.getReason())
                .build();

        return transferRepository.save(transfer);
    }

    public Iterable<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }
}
