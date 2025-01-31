package com.bank.service;

import com.bank.model.Account;

import java.util.List;

public interface AccountService {
    void transfer(int from, int to, double amount);
    void deposit(int id, double amount);
    Account getAccount(int id);
    List<Account> getAllAccounts();
}
