package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceProductDTO {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private Integer tax;
    private BigDecimal total;
    private BigDecimal profitLoss;
    private int remainingQuantity;
    private InvoiceDTO invoice;
    private ProductDTO product;
}
