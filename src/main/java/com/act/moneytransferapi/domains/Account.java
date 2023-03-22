package com.act.moneytransferapi.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Middle name cannot be empty")
    private String middleName;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @Column(nullable = false)
    @NotNull(message = "Date of birth must be set")
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Phone number cannot be empty")
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "Pin must be set")
    @Min(4)
    @Max(6)
    private Integer pin;

    @Column(nullable = false)
    private Double balance = 0.0;

    @Column(nullable = false)
    private LocalDate openingDate = LocalDate.now();

//    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "firstName")
//    private User user;
}

// EXAMPLE OF SETTER AND GETTER METHODS
//    public String getFirstName() {
//        return firstName.toUpperCase();
//    }
//    public void setFirstName(String firstName) {
//        //validation
//        this.firstName = firstName;
//    }
//    Account myAccount = new Account();
//FAIL myAccount.firstName = "Biniam";
//CORRECT myAccount.setFirstName("Biniam");

