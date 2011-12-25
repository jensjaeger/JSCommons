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
        return getAfterNext(stringToSearch, false);
    }

    /**
     * retains the substring after the stringToSearch, including the
     * stringToSearch.
     */
    public StringTrimmer getAfterNextInc(String stringToSearch) {
        return getAfterNext(stringToSearch, true);
    }

    private StringTrimmer getAfterNext(String stringToSearch, boolean includeSearchString) {
        if (this.string == null)
            return this;
        int index = getIndex(stringToSearch);
        calcNewStart(index, stringToSearch, includeSearchString);
        return this;
    }

    public StringTrimmer getBeforeNext(String stringToSearch) {
        return getBeforeNext(stringToSearch, false);
    }

    public StringTrimmer getBeforeNextInc(String stringToSearch) {
        return getBeforeNext(stringToSearch, true);
    }

    private StringTrimmer getBeforeNext(String stringToSearch, boolean includeSearchString) {
        if (this.string == null)
            return this;
        int index = getIndex(stringToSearch);
        if (index > -1 && index < this.end) {
            this.end = Math.max(this.start, index);
        }
        return this;
    }

    public StringTrimmer getBeforeLast(String stringToSearch) {
        return getBeforeLast(stringToSearch, false);
    }

    public StringTrimmer getBeforeLastInc(String stringToSearch) {
        return getBeforeLast(stringToSearch, true);
    }

    private StringTrimmer getBeforeLast(String stringToSearch, boolean includeSearchString) {
        if (this.string == null)
            return this;
        int index = getLastIndex(stringToSearch);
        calcNewEnd(index, stringToSearch, includeSearchString);
        return this;
    }

    public StringTrimmer getAfterLast(String stringToSearch) {
        return getAfterLast(stringToSearch, false);
    }

    public StringTrimmer getAfterLastInc(String stringToSearch) {
        return getAfterLast(stringToSearch, true);
    }

    private StringTrimmer getAfterLast(String stringToSearch, boolean includeSearchString) {
        if (this.string == null)
            return this;
        int index = getLastIndex(stringToSearch);
        calcNewStart(index, stringToSearch, includeSearchString);
        return this;
    }

    private void calcNewStart(int index, String stringToSearch, boolean includeSearchString) {
        if (index > -1) {
            int newEnd = index;
            if (!includeSearchString)
                newEnd += stringToSearch.length();
            this.start = Math.min(this.end, newEnd);
        } else {
            this.start = this.end;
        }
    }

    private void calcNewEnd(int index, String stringToSearch, boolean includeSearchString) {
        if (index > -1) {
            int newEnd = index;
            if (includeSearchString)
                newEnd += stringToSearch.length();
            this.end = Math.max(this.start, newEnd);
        }
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

        int index = this.toString().lastIndexOf(stringToSearch);
        if (index > -1)
            index = index + this.start;

        // TODO: better implementation
        // int index = this.string.lastIndexOf(stringToSearch, this.end); //
        // this.toString().lastIndexOf(stringToSearch);
        // if (index > -1 && index >= this.start) {
        // index = index + this.start;
        // } else {
        // index = -1;
        // }
        return index;
    }

    @Override
    public String toString() {
        if (this.string == null)
            return null;
        return this.string.substring(this.start, this.end);
    }
}
