package bridge.observer;

import bridge.dto.BridgeGameDto;

public interface Observer {
    void display(BridgeGameDto dto);
}
