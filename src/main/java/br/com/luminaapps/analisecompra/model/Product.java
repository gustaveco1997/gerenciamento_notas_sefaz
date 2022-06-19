package br.com.luminaapps.analisecompra.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String code;
    private String name;
    private String quantity;
    private BigDecimal totalValue;
}
