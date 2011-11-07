package com.jsing.common.string;

public class StringTrimmer {
    private String string;
    private int start = 0;
    private int end;

    public StringTrimmer(String string) {
        this.string = string;
        if (this.string == null)
            return;
        this.end = this.string.length();
    }

    public StringTrimmer getAfterNext(String stringToSearch) {
        if (this.string == null)
            return this;
        int index = getIndex(stringToSearch);
        if (index > -1) {
            this.start = Math.min(this.end, index + stringToSearch.length());
        } else {
            this.start = this.end;
        }
        return this;
    }

    public StringTrimmer getBeforeNext(String stringToSearch) {
        if (this.string == null)
            return this;
        int index = getIndex(stringToSearch);
        if (index > -1 && index < this.end) {
            this.end = Math.max(this.start, index);
        }
        return this;
    }

    public StringTrimmer getBeforeLast(String stringToSearch) {
        if (this.string == null)
            return this;
        int index = getLastIndex(stringToSearch);
        if (index > -1) {
            this.end = Math.max(this.start, index);
        }
        return this;
    }

    private int getIndex(String stringToSearch) {
        if (stringToSearch == null)
            return -1;
        return this.string.indexOf(stringToSearch, this.start);
    }

    private int getLastIndex(String stringToSearch) {
        if (stringToSearch == null || this.end - this.start == 0)
            return -1;

        // TODO: better implementation
        return this.toString().lastIndexOf(stringToSearch)+this.start;
    }

    @Override
    public String toString() {
        if (this.string == null)
            return null;
        return this.string.substring(this.start, this.end);
    }
}
