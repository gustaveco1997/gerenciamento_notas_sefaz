package br.com.luminaapps.analisecompra.service;

import br.com.luminaapps.analisecompra.model.Product;
import br.com.luminaapps.analisecompra.service.exceptions.CannotFindFileOrUrlParserException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j(topic = "ProductSfazConvert")
public class ProductSefazConvert {
    private final Document document;

    public ProductSefazConvert(File file) {
        document = convertToDocument(file);
    }

    public List<Product> convert() {
        Elements tables = document.select("#myTable");
        Element table = tables.get(0);
        Elements linhaProduto = table.select("tr");

        List<Product> products = new ArrayList<>();
        linhaProduto.forEach(linha -> {
            Elements childrens = linha.children();

            Product product = new Product();
            product.setCode(new CodeCleannerXml().get(childrens.get(0).text()));
            product.setName(new NameCleannerXml().get(childrens.get(0).text()));
            product.setQuantity(new QuantityCleannerXml().get(childrens.get(1).text()));
            product.setTotalValue(new TotalCleannerXml().get(childrens.get(3).text()));
            products.add(product);
        });

        return products;
    }


    private Document convertToDocument(File file) throws CannotFindFileOrUrlParserException {
        try {
            return Jsoup.parse(file, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            throw new CannotFindFileOrUrlParserException(e.getMessage());
        }
    }
}
