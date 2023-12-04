package bridge.domain;

import bridge.dto.BridgeDto;

import java.util.List;

import static bridge.config.AnswerSetting.MESSAGE_CORRECT;
import static bridge.config.AnswerSetting.MESSAGE_INCORRECT;

public class Bridge {
    private final List<String> bridge;
    private int tryCount;
    private String correct = MESSAGE_INCORRECT.getAnswer();

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        tryCount = 0;
    }

    public BridgeDto toDto() {
        return new BridgeDto(bridge, tryCount, correct);
    }

    public void plusOneTryCount() {
        tryCount += 1;
    }

    public void answerCorrect() {
        correct = MESSAGE_CORRECT.getAnswer();
    }
}
