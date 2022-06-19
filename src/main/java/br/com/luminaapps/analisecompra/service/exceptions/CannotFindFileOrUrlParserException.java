package br.com.luminaapps.analisecompra.service.exceptions;

public class CannotFindFileOrUrlParserException extends RuntimeException{
    public CannotFindFileOrUrlParserException(String message){
        super(message);
    }
}
