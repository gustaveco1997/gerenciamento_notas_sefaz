package br.com.luminaapps.analisecompra.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameCleannerXmlTest {
    @Test
    public void cleanner_name() {
        String line = "CR DENT COLG TOT 90G (Código: 412216)";
        assertEquals("CR DENT COLG TOT 90G", new NameCleannerXml().get(line));
    }
}