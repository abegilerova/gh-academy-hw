package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//raw input to list of tokens
public class Lexer {
    private final char EOF_CHAR = '\0';
    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList("if"));
    private final String input;
    private int position;
    private char currentChar;

    public Lexer(String input){
        this.input = input;
        this.position = 0;
        this.currentChar = input == null || input.isEmpty() ? EOF_CHAR : input.charAt(position);

    }

    public Token nextToken(){
        while(currentChar != EOF_CHAR){
            if(Character.isWhitespace(currentChar)){
                skipWhiteSpace();
                continue;
            }
            if(Character.isDigit(currentChar)){
                return readNumber();
            }

            if(Character.isLetter(currentChar)){
                return readIdentifier();
            }

            switch (currentChar){
                case '=':
                    advance();
                    return  new Token(TokenType.ASSIGHNMENT, "=");
                case '+':
                    advance();
                    return  new Token(TokenType.PLUS, "+");
                case ';':
                    advance();
                    return  new Token(TokenType.SEPARATOR, ";");
                case '*':
                    advance();
                    return new Token(TokenType.MUL, "*");
                default:
                    throw new LexerException("Unexpected character:  " + currentChar);
            }
        }
        return new Token(TokenType.EOF, "");
    }

    private Token readIdentifier(){
        StringBuilder builder = new StringBuilder();
        while(Character.isLetterOrDigit(currentChar)){
            builder.append(currentChar);
            advance();
        }
        String value = builder.toString();
        return KEYWORDS.contains(value) ? new Token(TokenType.IF, value ):
                new Token(TokenType.IDENTIFIER, value);
    }

    private Token readNumber(){
        StringBuilder builder = new StringBuilder();
        while(Character.isDigit(currentChar)){
            builder.append(currentChar);
            advance();
        }
        return new Token(TokenType.NUMBER, builder.toString());
    }

    private void skipWhiteSpace(){
        while(Character.isWhitespace(currentChar)){
            advance();
        }
    }

    private void advance(){
        position++;
        currentChar = position < input.length() ? input.charAt(position) : EOF_CHAR;
    }

    public static class Token {
        public final TokenType tokenType;
        public final String value;

        public Token(TokenType tokenType, String value){
            this.tokenType = tokenType;
            this.value = value;
        }

        @Override
        public  String toString(){
            return "Token{" + "tokenType=" + tokenType + " value ='" + value + '\'' + '}';
        }

    }

    public enum TokenType {
        NUMBER, IDENTIFIER, PLUS, EOF, ASSIGHNMENT, SEPARATOR, IF, MUL, DIV, MINUS
    }

}