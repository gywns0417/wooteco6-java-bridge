package bridge.domain;

import bridge.dto.BridgeGameDto;
import bridge.observer.Observer;
import bridge.observer.Subject;

import java.util.ArrayList;
import java.util.List;

import static bridge.config.AnswerSetting.ANSWER_CORRECT;
import static bridge.config.AnswerSetting.ANSWER_INCORRECT;
import static bridge.config.KeySetting.KEY_DOWN;
import static bridge.config.KeySetting.KEY_UP;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame implements Subject {
    private final List<String> bridge;
    private final List<String> crossResult = new ArrayList<>();
    private final List<String> userChoice = new ArrayList<>();
    private int moveCount;
    private final List<Observer> observers = new ArrayList<>();

    public BridgeGame(List<String> bridge) {
        moveCount = 0;
        this.bridge = bridge;
    }

    public void move(String input) {
        String answer = bridge.get(moveCount);
        userChoice.add(input);
        if (input.equals(answer)) {
            crossResult.add(ANSWER_CORRECT.getAnswer());
            moveCount++;
            notifyObservers();
            return;
        }
        crossResult.add(ANSWER_INCORRECT.getAnswer());
        moveCount++;
        notifyObservers();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getCrossResult() {
        return crossResult;
    }

    public BridgeGameDto toDto() {
        return new BridgeGameDto(bridge, crossResult, userChoice, createResultMap());
    }

    private String createResultMap() {
        StringBuilder line1 = new StringBuilder("[");
        StringBuilder line2 = new StringBuilder("[");


        for (int i = 0; i < crossResult.size(); i++) {
            if (userChoice.get(i).equals(KEY_UP.getKey())) {
                line1.append(" ").append(crossResult.get(i)).append(" ");
                line2.append("   ");
            }
            else if (userChoice.get(i).equals(KEY_DOWN.getKey())) {
                line1.append("   ");
                line2.append(" ").append(crossResult.get(i)).append(" ");
            }
            if (i < crossResult.size() - 1) {
                line1.append("|");
                line2.append("|");
            }
        }

        line1.append("]");
        line2.append("]");

        return line1 + "\n" + line2 + "\n";
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.display(toDto());
        }
    }
}
