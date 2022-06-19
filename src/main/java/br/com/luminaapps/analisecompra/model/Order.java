package br.com.luminaapps.analisecompra.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private BigDecimal total;
    private List<Product> products;
    private BigDecimal icmsValue;
    private LocalDateTime createdAt;
}
