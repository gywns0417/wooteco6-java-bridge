package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.config.KeySetting.KEY_DOWN;
import static bridge.config.KeySetting.KEY_UP;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            if (randomNumber == 0) {
                bridge.add(KEY_DOWN.getKey());
                continue;
            }
            bridge.add(KEY_UP.getKey());
        }
        return bridge;
    }
}
