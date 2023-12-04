package bridge.config;

public enum KeySetting {
    KEY_UP("U"),
    KEY_DOWN("D"),
    KEY_RESTART("R"),
    KEY_QUIT("Q");

    private final String key;

    KeySetting(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
