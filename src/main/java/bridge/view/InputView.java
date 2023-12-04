package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static bridge.config.ErrorMessage.*;
import static bridge.config.GameMessage.*;
import static bridge.config.KeySetting.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final Pattern bridgeSizePattern =  Pattern.compile("^([3-9]|1[0-9]|20)$");
    private static final Pattern movingPattern = Pattern.compile(String.format("^[%s%s]$",
            KEY_UP.getKey(), KEY_DOWN.getKey()));
    private static final Pattern gameCommandPattern = Pattern.compile(String.format("^[%s%s]$",
            KEY_RESTART.getKey(), KEY_QUIT.getKey()));

    public static String readBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE_MESSAGE.getMessage());
        String input = getUserInput();
        if (!bridgeSizePattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_INPUT.getMessage());
        }
        return input;
    }

    public static String readMoving() {
        System.out.println(REQUEST_MOVE_MESSAGE.getMessage());
        String input = getUserInput();
        if (!movingPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_MOVING_INPUT.getMessage());
        }
        return input;
    }

    public static String readGameCommand() {
        System.out.println(REQUEST_RETRY_MESSAGE.getMessage());
        String input = getUserInput();
        if (!gameCommandPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_COMMAND_INPUT.getMessage());
        }
        return input;
    }

    private static String getUserInput() {
        return Console.readLine();
    }
}
