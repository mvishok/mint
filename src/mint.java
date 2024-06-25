import interpreter.*;
import java.util.List;

public class mint {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("print\"my world\" 123 true\nif condition then\nprint \"inside if\"\nelse\nprint \"inside else\"\nend\nrepeat 3 times\nprint \"repeat body\"\nend\n");
        List<String> tokens = lexer.tokenize();
        Executor executor = new Executor(tokens);
        executor.execute();
    }
}
