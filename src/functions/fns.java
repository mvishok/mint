package functions;

import java.util.ArrayList;
import java.util.List;

public class fns {

    private List<Object> parse(List<String> args){
        List<Object> parsed = new ArrayList<>();
        for (int i = 0; i < args.size(); i++) {
            String arg = args.get(i);
            
            //if it is a literal, remove the quotes
            if (arg.startsWith("\"") && arg.endsWith("\"")) {
                parsed.add(i, arg.substring(1, arg.length() - 1));
            } else if (arg.startsWith("'") && arg.endsWith("'")) {
                parsed.add(i, arg.substring(1, arg.length() - 1));
            } else if (arg.equals("true") || arg.equals("false")) {
                parsed.add(i, Boolean.parseBoolean(arg));
            } else if (arg.contains(".")) {
                try {
                    parsed.add(i, Double.parseDouble(arg));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number: " + arg);
                }
            } else {
                try {
                    parsed.add(i, Integer.parseInt(arg));
                } catch (NumberFormatException e) {
                    parsed.add(i, arg);
                }
            }
        }
        return parsed;
    }

    public void print(List<String> args) {
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    public void main(){
        List<String> args = new ArrayList<>();
        args.add("'World'");
        args.add("123");
        List<Object> parsed = parse(args);
        System.out.println(parsed);
    }

    
}
