package br.com.luminaapps.analisecompra;

public abstract class FilesSupportTest {
    protected String getSupportDir(){
        return String.format("src/test/java/%s/support/", getPackageDirs());
    }

    private String getPackageDirs(){
        return DocumentJsoupSimpleConverterTest.class.getPackage().getName().replace(".","/");
    }

}
