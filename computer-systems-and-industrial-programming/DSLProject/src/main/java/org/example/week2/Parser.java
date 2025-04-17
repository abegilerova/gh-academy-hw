package org.example.week2;
import org.example.Lexer;
import java.util.List;

/*
<expression> ::= <term> | <term> "+" <expression> | <term> "-" <expression>
<term> ::= <factor> | <factor> "*" <term> | <factor> "/" <term>
<factor> ::= <number> | "(" <expression> ")"
 */

public class Parser {
    private final Lexer lexer;
    private Lexer.Token currentToken;

    public Parser(Lexer lexer){
        this.lexer = lexer;
        this.currentToken = lexer.nextToken();
    }

    public ASTNode parse (){
        return parseExpression();
    }

    public ASTNode parseExpression(){
        ASTNode leftTerm = parseTerm();

        if(currentToken.tokenType == Lexer.TokenType.PLUS ||
        currentToken.tokenType == Lexer.TokenType.MINUS){
            Lexer.TokenType op = currentToken.tokenType;
            consume(currentToken.tokenType);

            return new BinaryOpNode(op, leftTerm, parseExpression());
        }

        return leftTerm;
    }

    public ASTNode parseTerm(){
        ASTNode leftNode = parseFactor();


        if(currentToken.tokenType == Lexer.TokenType.MUL ||
        currentToken.tokenType == Lexer.TokenType.DIV){
            Lexer.TokenType op = currentToken.tokenType;
            consume(currentToken.tokenType);

            return new BinaryOpNode(op, leftNode, parseTerm());
        }

        return leftNode;
    }

    public ASTNode parseFactor(){
        if(currentToken.tokenType == Lexer.TokenType.NUMBER){
            consume(Lexer.TokenType.NUMBER);
            return new NumberNode(currentToken.value);
        }

        if(currentToken.tokenType == Lexer.TokenType.IDENTIFIER){
            consume(Lexer.TokenType.IDENTIFIER);
            return new IdentifierNode(currentToken.value);
        }
        throw new ParserException("Unexpected Token Type: " + currentToken.tokenType.name());
    }

    private void consume(Lexer.TokenType tokenType){
        if(currentToken.tokenType == tokenType){
            currentToken = lexer.nextToken();
        }else {
            throw new ParserException("Unexpected Token Type: " + currentToken.tokenType.name());
        }
    }

    static class ASTNode {}

    static class BinaryOpNode extends  ASTNode {
        final Lexer.TokenType op;
        final  ASTNode left;
        final  ASTNode right;

        BinaryOpNode (Lexer.TokenType op, ASTNode left, ASTNode right){
            this.op = op;
            this.left = left;
            this.right = right;
        }

    }

    static class IdentifierNode extends ASTNode {
        final String value;

        IdentifierNode(String value){
            this.value = value;
        }

    }

    static class NumberNode extends  ASTNode {
        final String value;

        NumberNode(String value ){
            this.value = value;
        }
    }
}
