package br.com.luminaapps.analisecompra.service;

import java.math.BigDecimal;

public class TotalCleannerXml {
    public BigDecimal get(String value) {
        String exp = ".*[R$ ]";
        value = value.replaceAll(exp, "").trim().replace(",", ".");
        return new BigDecimal(value);
    }
}
