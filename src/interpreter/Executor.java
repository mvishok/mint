package interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modules.*;
import functions.*;

public class Executor {

    private List<String> tokens;
    private int index;
    private Map<String, String> functions;

    logger log = new logger();
    fns fn = new fns();

    public Executor(List<String> tokens) {
        this.tokens = tokens;
        this.index = 0;
        this.functions = new HashMap<>();

        //for print functions
        functions.put("print", "print");
        functions.put("display", "print");
        functions.put("show", "print");
        functions.put("say", "print");
        functions.put("output", "print");
        functions.put("write", "print");
        functions.put("output", "print");


    }

    public void execute() {
        while (index < tokens.size()) {
            String token = tokens.get(index);
            if (functions.containsKey(token)) {

                if (functions.get(token).equals("print")) {
                    index++;
                    List<String> args = new ArrayList<String>();
                    while (index < tokens.size() && !tokens.get(index).equals("\\n")) {
                        args.add(tokens.get(index));
                        index++;
                    }
                    fn.print(args);
                }

            } else {
                log.log("Unknown function: " + token, "error");
            }
            index++;
        }
    }

    // public static void main(String[] args) {
    //     Lexer lexer = new Lexer("print \"my world\" 123 true\nif condition then\nprint \"inside if\"\nelse\nprint \"inside else\"\nend\nrepeat 3 times\nprint \"repeat body\"\nend\n");
    //     List<String> tokens = lexer.tokenize();
    //     Executor executor = new Executor(tokens);
    //     executor.execute();
    // }    
}
