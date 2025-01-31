package com.bank.service;

import com.bank.dao.AccountDao;
import com.bank.model.Account;
import com.bank.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(int from, int to, double amount) {
        Account fromAccount = accountDao.findById(from).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        Account toAccount = accountDao.findById(to).orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountDao.save(fromAccount);
        accountDao.save(toAccount);
    }

    @Override
    public void deposit(int id, double amount) {
        Account account = accountDao.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        accountDao.save(account);
    }

    @Override
    public Account getAccount(int id) {
        return accountDao.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }
    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }
}


