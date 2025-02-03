package com.bankapp.controller;

import com.bankapp.dto.AccountDto;
import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<AccountDto> getAllAccounts() {
        return accountService.getAll();
    }

    @GetMapping( "/accounts/{id}")
    public AccountDto getAccountById(@PathVariable int id) {
        return accountService.getById(id);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferDto transferDto) {
        return accountService.transfer(transferDto);
    }

    @PostMapping("/deposit")
    public String deposit(@Valid @RequestBody DepositDto depositDto) {
        return accountService.deposit(depositDto);
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody WithdrawDto withdrawDto) {
        return accountService.withdraw(withdrawDto);
    }


}
