package com.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawDto {
    private int accountId;
    @Range(min = 500, message = "Amount should be greater than 500")
    private BigDecimal amount;
}
