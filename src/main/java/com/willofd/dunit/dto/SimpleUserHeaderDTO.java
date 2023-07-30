package com.willofd.dunit.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author Ivan Partola
 */
@ToString
@Data
public class SimpleUserHeaderDTO {
    private String username;
    private BigDecimal balance;
    private String currency;
}
