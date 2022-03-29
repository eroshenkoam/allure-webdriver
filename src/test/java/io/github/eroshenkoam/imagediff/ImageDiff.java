package io.github.eroshenkoam.imagediff;

import java.io.Serializable;

public class ImageDiff implements Serializable {

    private String expected;
    private String actual;
    private String diff;

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }
}
