package com.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {
    private int fromAccId;
    private int toAccId;
    @Range(min = 500, message = "Amount should be greater than 500")
    private BigDecimal amount;
}
