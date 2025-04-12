package org.example.week2;

import org.example.Lexer;

import java.util.List;

public class Parser {
public static List<Lexer.Token> listOfTokens;
static int currentIndex ;

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
    Lexer.Token currentToken = peek();
    if(currentToken.tokenType != Lexer.TokenType.IDENTIFIER && currentIndex != 0){
        return false;
    } else if (currentToken.tokenType != Lexer.TokenType.ASSIGHNMENT && currentIndex != 1){
        return false;
    } else if(currentToken.tokenType.toString() != "NUMBER" && currentIndex != 2){
        return false;
    }  else if(currentToken.tokenType.toString() != "PLUS" && currentIndex != 3){
        return false;
    }  else if(currentToken.tokenType.toString() != "NUMBER" && currentIndex != 4){
        return false;
    }

    advance();

    return true;
}

public static void advance(){
    currentIndex++;
}

public static Lexer.Token peek(){
    return listOfTokens.get(currentIndex);

}

}
