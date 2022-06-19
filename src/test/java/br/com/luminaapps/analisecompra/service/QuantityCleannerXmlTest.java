package br.com.luminaapps.analisecompra.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuantityCleannerXmlTest {
    @Test
    public void quantity() {
        String line = "Qtde total de ?tens: 1.000";
        assertEquals("1.0", new QuantityCleannerXml().get(line));
    }

}
