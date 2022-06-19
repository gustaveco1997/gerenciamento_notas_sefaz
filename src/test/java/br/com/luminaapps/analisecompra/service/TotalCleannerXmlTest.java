package br.com.luminaapps.analisecompra.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
public class TotalCleannerXmlTest {
    @Test
    public void total_test() {
        String line = "Valor total R$: R$ 2,38";
        assertEquals(new BigDecimal("2.38"),new TotalCleannerXml().get(line));
    }
}
