package br.com.luminaapps.analisecompra;

import br.com.luminaapps.analisecompra.model.Product;
import br.com.luminaapps.analisecompra.service.ProductSefazConvert;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSefazConvertTest extends FilesSupportTest {
    @Test
    public void extracaoProdutosHtmlSefaz() {
        File sefazFileHtml = new File(getSupportDir() + "sefaz_sample.html");
        ProductSefazConvert convert = new ProductSefazConvert(sefazFileHtml);
        List<Product> products = convert.convert();
        assertNotNull(products);
        assertFalse(products.isEmpty());

        Product first = products.get(0);
        MatcherAssert.assertThat(first.getName(), is(equalTo("CR DENT COLG TOT 90G")));
        MatcherAssert.assertThat(first.getCode(), is(equalTo("412216")));
        assertEquals(new BigDecimal("9.90"), first.getTotalValue());

        Product third = products.get(2);
        MatcherAssert.assertThat(third.getName(), is(equalTo("DET LIQ YPE 500ML")));
        MatcherAssert.assertThat(third.getCode(), is(equalTo("114257")));
        assertEquals(new BigDecimal("2.38"), third.getTotalValue());
    }
}
