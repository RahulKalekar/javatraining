package com.bankapp.dto;

import com.bankapp.entity.Account;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private int id;
    private String name;
    private BigDecimal balance;
    public AccountDto(Account account) {
        this.id = account.getId();
        this.name = account.getName();
        this.balance = account.getBalance();
    }
}
