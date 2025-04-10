package org.example;

//raw input to list of tokens
public class Lexer {
    private final char EOF_CHAR = '\0';
    private final String input;
    private int position;
    private char currentChar;

    public Lexer(String input){
        this.input = input;
        this.position = 0;
        this.currentChar = input == null || input.isEmpty() ? EOF_CHAR : input.charAt(position);

    }

    public Token nextToken(){
        return null;
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
        NUMBER, IDENTIFIER, PLUS, EOF
    }

}