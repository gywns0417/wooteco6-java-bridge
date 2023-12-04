package bridge.dto;

import java.util.List;

public class BridgeDto {
    private final List<String> bridge;
    private final int tryCount;
    private final String correct;


    public BridgeDto(List<String> bridge, int tryCount, String correct) {
        this.bridge = bridge;
        this.tryCount = tryCount;
        this.correct = correct;
    }

    public List<String> bridge() {
        return bridge;
    }

    public int tryCount() {
        return tryCount;
    }

    public String isCorrect() {
        return correct;
    }
}
