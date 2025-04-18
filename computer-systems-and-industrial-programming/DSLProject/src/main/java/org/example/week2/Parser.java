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
            String value = currentToken.value;
            consume(Lexer.TokenType.NUMBER);
            return new NumberNode(value);
        }

        if(currentToken.tokenType == Lexer.TokenType.IDENTIFIER){
            String value = currentToken.value;
            consume(Lexer.TokenType.IDENTIFIER);
            return new IdentifierNode(value);
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

    public static class ASTNode {}

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

    public static void printAST(Parser.ASTNode node, int indent) {
        String indentStr = "  ".repeat(indent);

        if (node instanceof Parser.NumberNode) {
            System.out.println(indentStr + "Number: " + ((Parser.NumberNode) node).value);
        } else if (node instanceof Parser.IdentifierNode) {
            System.out.println(indentStr + "Identifier: " + ((Parser.IdentifierNode) node).value);
        } else if (node instanceof Parser.BinaryOpNode) {
            Parser.BinaryOpNode bin = (Parser.BinaryOpNode) node;
            System.out.println(indentStr + "BinaryOp: " + bin.op);
            printAST(bin.left, indent + 1);
            printAST(bin.right, indent + 1);
        } else {
            System.out.println(indentStr + "Unknown node");
        }
    }
}
