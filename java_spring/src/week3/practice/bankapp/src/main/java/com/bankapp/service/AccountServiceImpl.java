package com.bankapp.service;

import com.bankapp.dto.AccountDto;
import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.entity.Account;
import com.bankapp.exceptions.AccountNotFoundException;
import com.bankapp.exceptions.NotSufficientBalanceException;
import com.bankapp.repo.AccountRepo;
import com.bankapp.service.aspect.Loggable;
import com.bankapp.util.ConvertUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.export.newrelic.NewRelicProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional//from spring
public class AccountServiceImpl implements AccountService {
    private AccountRepo accountRepo;
    private Environment environment;
    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, Environment environment) {
        this.accountRepo = accountRepo;
        this.environment = environment;
    }

    @Override
    @Loggable
    public List<AccountDto> getAll() {
        return accountRepo.findAll().stream().map(ConvertUtil::convertToAccountDto).toList();
    }

    @Override
    public AccountDto getById(int id) {
        return accountRepo.findById(id).map(ConvertUtil::convertToAccountDto)
                .orElseThrow(()->new AccountNotFoundException("Account not found with id: "+id));
    }

    @Override
    public String transfer(TransferDto transferDto) {
        //get both accounts
        Account fromAcc=ConvertUtil.convertToAccount(getById(transferDto.getFromAccId()));
        Account toAcc=ConvertUtil.convertToAccount(getById(transferDto.getToAccId()));
        //update both accounts
        fromAcc.setBalance(fromAcc.getBalance().subtract(transferDto.getAmount()));
        toAcc.setBalance(toAcc.getBalance().add(transferDto.getAmount()));
        //save both accounts
        accountRepo.save(fromAcc);
        accountRepo.save(toAcc);
        return "Transfer successful";
        //validate amount
    }

    @Override
    public String deposit(DepositDto depositDto) {
        Account account=ConvertUtil.convertToAccount(getById(depositDto.getAccountId()));
        account.setBalance(account.getBalance().add(depositDto.getAmount()));
        accountRepo.save(account);
        //call environment using appliction.properties
        return "Deposit successful";
    }

    @Override
    public String withdraw(WithdrawDto withdrawDto) {
        Account account=ConvertUtil.convertToAccount(getById(withdrawDto.getAccountId()));
        account.setBalance(account.getBalance().subtract(withdrawDto.getAmount()));
        BigDecimal tempBalance=account.getBalance();
        if(tempBalance.compareTo(BigDecimal.ZERO)<0){
            throw new NotSufficientBalanceException( "Insufficient balance");
        }
        accountRepo.save(account);
        return environment.getProperty("withdraw.success");
    }
}

