package org.example.week2;

import org.example.Lexer;

import java.util.List;

public class Parser {
private  List<Lexer.Token> listOfTokens;
private  int currentIndex ;

public Parser(){
this.listOfTokens = List.of(
        new Lexer.Token(Lexer.TokenType.IDENTIFIER, "x"),
        new Lexer.Token(Lexer.TokenType.ASSIGHNMENT, "="),
        new Lexer.Token(Lexer.TokenType.NUMBER, "5"),
        new Lexer.Token(Lexer.TokenType.PLUS, "+"),
        new Lexer.Token(Lexer.TokenType.NUMBER, "3"),
        new Lexer.Token(Lexer.TokenType.EOF, "")
);

this.currentIndex = 0;
}

public boolean parseAndValidate(){

    if (peek().tokenType != Lexer.TokenType.IDENTIFIER) return false;
    advance();

    if (peek().tokenType != Lexer.TokenType.ASSIGHNMENT) return false;
    advance();

    if (peek().tokenType != Lexer.TokenType.NUMBER) return false;
    advance();

    if (peek().tokenType != Lexer.TokenType.PLUS) return false;
    advance();

    if (peek().tokenType != Lexer.TokenType.NUMBER) return false;
    advance();

    return peek().tokenType == Lexer.TokenType.EOF;
}

public void advance(){
    currentIndex++;
}

public Lexer.Token peek(){
    return listOfTokens.get(currentIndex);

}

}
