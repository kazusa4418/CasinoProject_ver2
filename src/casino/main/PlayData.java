package casino.main;

import java.io.Serializable;
import java.time.Duration;

public class PlayData implements Serializable {
    private String name;
    private int chips;
    private Duration time;

    public PlayData(String name) {
        this.name = name;
        this.chips = 0;
        this.time = Duration.ZERO;
    }

    public String getName() {
        return name;
    }

    public int getChips() {
        return chips;
    }

    public Duration getPlayTime() {
        return time;
    }

}
