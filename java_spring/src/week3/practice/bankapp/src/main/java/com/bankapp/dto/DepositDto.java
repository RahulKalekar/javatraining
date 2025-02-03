package com.bankapp.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositDto {
    @NotNull(message = "Account id is required please god")
    private Integer accountId;
    @Range(min = 500, message = "Amount should be greater than 500")
    @NotNull(message = "Amount cannot be null.")
    private BigDecimal amount;
}
