package br.com.luminaapps.analisecompra.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodeCleannerXmlTest {
    @Test
    public void code() {
        String line = "CR DENT COLG TOT 90G (C�digo: 412216)";
        assertEquals("412216", new CodeCleannerXml().get(line));
    }
}
