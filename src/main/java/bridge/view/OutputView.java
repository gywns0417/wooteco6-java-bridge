package bridge.view;

import bridge.dto.BridgeDto;
import bridge.dto.BridgeGameDto;

import static bridge.config.GameMessage.*;

public class OutputView {
    public static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE.getMessage());
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printMap(BridgeGameDto dto) {
        System.out.println(dto.getResultMap());
    }

    public static void printResult(BridgeGameDto bridgeGameDto, BridgeDto bridgeDto) {
        System.out.println(RESULT_MESSAGE.getMessage());
        System.out.println(bridgeGameDto.getResultMap());
        System.out.println(RESULT_IS_WIN.getMessage() + bridgeDto.isCorrect());
        System.out.print(RESULT_TOTAL_TRY_COUNT.getMessage() + bridgeDto.tryCount());
    }
}
