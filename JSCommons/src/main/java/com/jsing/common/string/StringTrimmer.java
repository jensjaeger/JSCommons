package com.jsing.common.string;


public class StringTrimmer {
    String string;

    public StringTrimmer(String string) {
        this.string = string;
    }

    public StringTrimmer getAfterNext(String stringToSearch) {
        int index = string.indexOf(stringToSearch);
        if (index > -1) {
            return new StringTrimmer(string.substring(index + stringToSearch.length()));
        } else {
            return new StringTrimmer("");
        }
    }

    public StringTrimmer getBeforeNext(String stringToSearch) {
        int index = string.indexOf(stringToSearch);
        if (index > -1) {
            return new StringTrimmer(string.substring(0, index));
        } else {
            return new StringTrimmer("");
        }
    }

    @Override
    public String toString() {
        return string;
    }
}
