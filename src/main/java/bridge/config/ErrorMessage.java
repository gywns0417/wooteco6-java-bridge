package bridge.config;

import static bridge.config.GameSetting.MAX_BRIDGE_SIZE;
import static bridge.config.GameSetting.MIN_BRIDGE_SIZE;
import static bridge.config.KeySetting.*;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR] "),
    ERROR_BRIDGE_SIZE_INPUT(String.format("%s다리 길이는 %d부터 %d 사이의 숫자여야 합니다.", ERROR_MESSAGE.getMessage(),
            MIN_BRIDGE_SIZE.getValue(), MAX_BRIDGE_SIZE.getValue())),
    ERROR_MOVING_INPUT(String.format("%s이동할 칸은 %s 또는 %s만 입력할 수 있습니다.", ERROR_MESSAGE.getMessage(),
            KEY_UP.getKey(), KEY_DOWN.getKey())),
    ERROR_COMMAND_INPUT(String.format("%s재시작 여부 입력은 %s 또는 %s만 입력할 수 있습니다.", ERROR_MESSAGE.getMessage(),
            KEY_RESTART.getKey(), KEY_QUIT.getKey()));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
