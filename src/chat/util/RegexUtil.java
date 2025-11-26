package chat.util;

public class RegexUtil {

    private static final String REGEX = "\\|";

    public static Command getCommand(String userCommand){
        String command = userCommand.split(REGEX)[0];
        return switch (command) {
            case "/join" -> Command.JOIN;
            case "/message" -> Command.MESSAGE;
            case "/change" -> Command.CHANGE;
            case "/users" -> Command.USERS;
            case "/exit" -> Command.EXIT;
            default -> null;
        };
    }

    public static String getDetail(String userCommand){
        return userCommand.split(REGEX)[1];
    }
}
