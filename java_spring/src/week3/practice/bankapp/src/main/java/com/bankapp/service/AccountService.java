package com.bankapp.service;

import com.bankapp.dto.AccountDto;
import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface AccountService {
    //always return Dto to user
    public List<AccountDto> getAll();
    public AccountDto getById(int id);

    public String transfer(TransferDto transferDto);
    public String deposit(DepositDto depositDto);
    public String withdraw(WithdrawDto withdrawDto);
}
