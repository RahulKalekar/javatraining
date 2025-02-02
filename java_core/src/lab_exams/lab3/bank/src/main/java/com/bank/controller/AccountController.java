package com.bank.controller;

import com.bank.dto.AccountDto;
import com.bank.model.Account;
import com.bank.service.AccountService;
import com.bank.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(@RequestBody AccountDto accountBean) {      //taking the account dto plate
            accountService.transfer(accountBean.getFrom(), accountBean.getTo(), accountBean.getAmount());
            return ResponseEntity.ok("Transfer successful");

    }

    @PostMapping("/deposit")
    public ResponseEntity<String> depositFunds(@RequestParam int accountId, @RequestParam double amount) {

            accountService.deposit(accountId, amount);
            return ResponseEntity.ok("Deposit successful");

    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable int id) {

            Account account = accountService.getAccount(id);
        return ResponseEntity.ok(account);

    }
    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
