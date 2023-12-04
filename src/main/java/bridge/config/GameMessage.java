package bridge.config;

import static bridge.config.GameSetting.MAX_BRIDGE_SIZE;
import static bridge.config.GameSetting.MIN_BRIDGE_SIZE;
import static bridge.config.KeySetting.KEY_DOWN;
import static bridge.config.KeySetting.KEY_UP;

public enum GameMessage {
    WELCOME_MESSAGE("다리 건너기 게임을 시작합니다.\n" ),
    REQUEST_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    REQUEST_MOVE_MESSAGE(String.format("\n이동할 칸을 선택해주세요. (위: %s, 아래: %s)", KEY_UP.getKey(), KEY_DOWN.getKey())),
    REQUEST_RETRY_MESSAGE(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
            MIN_BRIDGE_SIZE.getValue(), MAX_BRIDGE_SIZE.getValue())),
    RESULT_MESSAGE("최종 게임 결과"),
    RESULT_IS_WIN("게임 성공 여부: "),
    RESULT_TOTAL_TRY_COUNT("총 시도한 횟수: ");

    private final String message;


    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
