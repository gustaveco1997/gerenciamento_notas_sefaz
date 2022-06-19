package br.com.luminaapps.analisecompra;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

@Slf4j
public class DocumentJsoupSimpleConverterTest extends FilesSupportTest {
    @Test
    public void convertLocalFile() throws IOException {
        File file = new File(getSupportDir() + "sefaz_sample.html");
        assertTrue(file.isFile());

        Document doc =  Jsoup.parse(file);
        assertEquals("Secretaria de Estado de Fazenda de Minas Gerais - SEF/MG", doc.title());
        assertNotNull(doc.body(), "The body is null");
    }

    @Test
    public void convertWikipedia() throws IOException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        log.info(doc.title());
        assertEquals("Wikipedia, the free encyclopedia", doc.title());
    }


}
