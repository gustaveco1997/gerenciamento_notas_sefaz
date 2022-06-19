package br.com.luminaapps.analisecompra.service;

public class CodeCleannerXml {
    public String get(String value) {
        String exp = "(.*digo: )|(\\))";
        return value.replaceAll(exp, "").trim();
    }
}
