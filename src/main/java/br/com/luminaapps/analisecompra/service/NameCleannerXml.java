package br.com.luminaapps.analisecompra.service;


public class NameCleannerXml {
    public String get(String value) {
        String exp = ".C[^\\p{ASCII}]digo: [ .\\d]*.";
        return value.replaceAll(exp, "").trim();
    }
}
