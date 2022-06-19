package br.com.luminaapps.analisecompra.service;

import br.com.luminaapps.analisecompra.model.Order;
import br.com.luminaapps.analisecompra.service.exceptions.CannotFindFileOrUrlParserException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class OrderSefazConvert {
    private final Document document;

    public OrderSefazConvert(File file) {
        this.document = convertToDocument(file);
    }

    public Order convert() {
        return null;
    }

    private Document convertToDocument(File file) throws CannotFindFileOrUrlParserException {
        try {
            return Jsoup.parse(file, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            throw new CannotFindFileOrUrlParserException(e.getMessage());
        }
    }
}
