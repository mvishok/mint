package modules;

public class logger {

    public Boolean l;

    public logger(){
        this.l = true;
    }

    public void log(String message, String type) {
        switch (type) {
            case "info":
                if (this.l) System.out.println("[INFO] " + message);
                break;
            case "warn":
                if (this.l) System.out.println("[WARNING] " + message);
                break;
            case "error":
                System.out.println("[ERROR] " + message);
                System.exit(1);
            default:
                System.out.println(message);
        }
    }
}
