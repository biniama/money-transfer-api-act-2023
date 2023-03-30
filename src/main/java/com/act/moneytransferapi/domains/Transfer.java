package com.act.moneytransferapi.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="transfer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

    @Id
    //Universally Unique Identification aka GUID
    //123e4567-e89b-12d3-a456-426614174000
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false) // , columnDefinition = "text"
    private String reason;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "Sender account is mandatory")
    private Account senderAccount;


    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "Receiver account is mandatory")
    private Account receiverAccount;

}
