package org.example;
import org.example.week2.Parser;

public class Main {
    public static void main(String[] args) {
      String rawInput = "43 + x";
      Lexer lexer = new Lexer(rawInput);
//
//      Lexer.Token token;
//      do {
//          token = lexer.nextToken();
//          System.out.println(token);
//      }while(token.tokenType != Lexer.TokenType.EOF);

        Parser parser = new Parser(new Lexer(rawInput));
        Parser.ASTNode tree = parser.parse();
        parser.printAST(tree, 0);

    }
}