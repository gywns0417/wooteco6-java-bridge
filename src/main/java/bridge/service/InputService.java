package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static bridge.config.AnswerSetting.ANSWER_INCORRECT;
import static bridge.config.KeySetting.KEY_QUIT;
import static bridge.config.KeySetting.KEY_RESTART;

public class InputService {
    public Bridge getBridgeSize(Supplier<String> inputSupplier,
                                Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
                BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
                return new Bridge(bridgeMaker.makeBridge(Integer.parseInt(inputSupplier.get())));
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        }
    }

    public BridgeGame getMoving(Supplier<String> inputSupplier,
                                Consumer<String> errorMessagePrinter, BridgeGame bridgeGame) {
        List<String> bridgeResult = bridgeGame.getCrossResult();
        do {
            try {
                bridgeGame.move(inputSupplier.get());
                bridgeResult = bridgeGame.getCrossResult();
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        } while (!bridgeResult.contains(ANSWER_INCORRECT.getAnswer()) &&
                bridgeResult.size() != bridgeGame.getBridge().size());

        return bridgeGame;
    }

    public void retry(Supplier<String> inputSupplier, Runnable retryGame,
                      Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                String input = inputSupplier.get();
                if (input.equals(KEY_RESTART.getKey())) {
                    retryGame.run();
                }
                else if (input.equals(KEY_QUIT.getKey())) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        }
    }
}
