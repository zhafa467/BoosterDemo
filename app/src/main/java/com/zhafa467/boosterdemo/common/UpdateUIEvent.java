package com.zhafa467.boosterdemo.common;

/**
 * Created by fan zhang on 16/12/21.
 */

public class UpdateUIEvent {
    int[] scheme;
    private int score;

    public UpdateUIEvent(int[] scheme, int score) {
        this.scheme = scheme;
        this.score = score;
    }

    public int[] getScheme() {
        return scheme;
    }

    public void setScheme(int[] scheme) {
        this.scheme = scheme;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
