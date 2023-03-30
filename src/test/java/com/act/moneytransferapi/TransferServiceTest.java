package com.act.moneytransferapi;

import com.act.moneytransferapi.domains.Transfer;
import com.act.moneytransferapi.dto.TransferRequest;
import com.act.moneytransferapi.services.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class TransferServiceTest {
    @Autowired
    private TransferService transferService;
    @Test
    public void shouldCreateSuccessfulTransfer() throws Exception {
        //given
        TransferRequest transferRequest = TransferRequest.builder()
                .senderAccountId(1L)
                .receiverAccountId(2L)
                .amount(400.00)
                .reason("Test")
                .build();

        //when
        Transfer transfer = transferService.moneyTransfer(transferRequest);

        //then
        assertNotNull(transfer.getUuid());
        assertEquals(1000.00,transfer.getSenderAccount().getBalance());
        assertEquals(2000.00,transfer.getReceiverAccount().getBalance());
    }


    @Test
    public void shouldFailToTransferMoneyIfBalanceIsInsufficient() {
        Exception exception = assertThrows(Exception.class, () -> {

            //given
            TransferRequest transferRequest = TransferRequest.builder()
                    .senderAccountId(1L)
                    .receiverAccountId(2L)
                    .amount(400000000.00)
                    .reason("Money Laundering")
                    .build();

            transferService.moneyTransfer(transferRequest);
        });

        String expectedMessage = "Insufficient Balance. Sender doesn't have enough balance to send.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
