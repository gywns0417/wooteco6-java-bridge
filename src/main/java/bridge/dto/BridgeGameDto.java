package bridge.dto;

import java.util.List;

public class BridgeGameDto {
    private final List<String> bridge;
    private final List<String> crossResult;
    private final List<String> userChoice;
    private final String resultMap;

    public BridgeGameDto(List<String> bridge, List<String> crossResult, List<String> userChoice, String resultMap) {
        this.bridge = bridge;
        this.crossResult = crossResult;
        this.userChoice = userChoice;
        this.resultMap = resultMap;
    }

    public List<String> bridge() {
        return bridge;
    }

    public List<String> userChoice() {
        return userChoice;
    }

    public List<String> crossResult() {
        return crossResult;
    }

    public String getResultMap() {
        return resultMap;
    }
}
