package bridge.config;

public enum AnswerSetting {
    ANSWER_CORRECT("O"),
    ANSWER_INCORRECT("X"),
    MESSAGE_CORRECT("성공"),
    MESSAGE_INCORRECT("실패");

    private final String answer;


    AnswerSetting(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
