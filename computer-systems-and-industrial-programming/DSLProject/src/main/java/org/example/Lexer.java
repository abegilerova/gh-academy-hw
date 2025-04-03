import java.util.*;
import java.util.regex.*;

class Token {
    enum Type {
        CONFIG, UPDATE, COMPUTE, SHOW, IDENTIFIER, NUMBER, OPERATOR, STRING, EQUALS, PERCENT, END
    }

    Type type;
    String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        return "(" + type + ", " + value + ")";
    }
}

public class DSLLexer {
    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "(?<CONFIG>config)|" +
                    "(?<UPDATE>update)|" +
                    "(?<COMPUTE>compute)|" +
                    "(?<SHOW>show)|" +
                    "(?<EQUALS>=)|" +
                    "(?<PERCENT>%)|" +
                    "(?<OPERATOR>[+\-*/])|" +
                    "(?<STRING>\"[a-zA-Z_][a-zA-Z0-9_]*\")|" +
                    "(?<NUMBER>\d+(\.\d+)?)|" +
                    "(?<IDENTIFIER>[a-zA-Z_][a-zA-Z0-9_]*)"
    );

    private final Matcher matcher;
    private final List<Token> tokens = new ArrayList<>();

    public DSLLexer(String input) {
        matcher = TOKEN_PATTERN.matcher(input);
    }

    public List<Token> tokenize() {
        while (matcher.find()) {
            if (matcher.group("CONFIG") != null) tokens.add(new Token(Token.Type.CONFIG, "config"));
            else if (matcher.group("UPDATE") != null) tokens.add(new Token(Token.Type.UPDATE, "update"));
            else if (matcher.group("COMPUTE") != null) tokens.add(new Token(Token.Type.COMPUTE, "compute"));
            else if (matcher.group("SHOW") != null) tokens.add(new Token(Token.Type.SHOW, "show"));
            else if (matcher.group("EQUALS") != null) tokens.add(new Token(Token.Type.EQUALS, "="));
            else if (matcher.group("PERCENT") != null) tokens.add(new Token(Token.Type.PERCENT, "%"));
            else if (matcher.group("OPERATOR") != null) tokens.add(new Token(Token.Type.OPERATOR, matcher.group("OPERATOR")));
            else if (matcher.group("STRING") != null) tokens.add(new Token(Token.Type.STRING, matcher.group("STRING")));
            else if (matcher.group("NUMBER") != null) tokens.add(new Token(Token.Type.NUMBER, matcher.group("NUMBER")));
            else if (matcher.group("IDENTIFIER") != null) tokens.add(new Token(Token.Type.IDENTIFIER, matcher.group("IDENTIFIER")));
        }
        tokens.add(new Token(Token.Type.END, "EOF"));
        return tokens;
    }

    public static void main(String[] args) {
        String input = "config \"num_users\" = 100; update \"num_users\" = 200 compute \"totalRequests\" = %num_users * %request_rate, show configs.";
        DSLLexer lexer = new DSLLexer(input);
        List<Token> tokens = lexer.tokenize();
        tokens.forEach(System.out::println);
    }
}
