package com.act.moneytransferapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferRequest {
    private Long senderAccountId;
    private Long receiverAccountId;
    private Double amount;
    private String reason;

}
