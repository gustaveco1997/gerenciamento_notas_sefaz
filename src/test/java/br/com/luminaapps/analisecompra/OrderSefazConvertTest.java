package br.com.luminaapps.analisecompra;

import br.com.luminaapps.analisecompra.model.Order;
import br.com.luminaapps.analisecompra.service.OrderSefazConvert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OrderSefazConvertTest extends FilesSupportTest{
    @Test
    public void compra_convert(){
        File sefazFileHtml = new File(getSupportDir() + "sefaz_sample.html");
        OrderSefazConvert convert = new OrderSefazConvert(sefazFileHtml);
        Order order = convert.convert();
        assertNotNull(order);
        assertNotNull(order.getProducts());
        assertFalse(order.getProducts().isEmpty());

        assertEquals( LocalDateTime.of(2022, 6,18,16, 0), order.getCreatedAt());
        assertEquals(new BigDecimal("707,59"),order.getTotal());
        assertEquals(new BigDecimal("18,62"),order.getIcmsValue());
    }
}
