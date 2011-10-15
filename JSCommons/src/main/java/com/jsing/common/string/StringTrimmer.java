package com.jsing.common.string;


public class StringTrimmer {
    private String string;
    private int start=0;
    private int end;

    public StringTrimmer(String string) {
        this.string = string;
        if(this.string==null)
        	return;
        this.end = this.string.length();
    }

    public StringTrimmer getAfterNext(String stringToSearch) {
        if(this.string==null)
        	return this;
        int index = getIndex(stringToSearch);
        if (index > -1) {
            this.start = Math.min(this.end, index + stringToSearch.length());
        } else {
            this.start = this.end;
        }
        return this;
    }

    private int getIndex(String stringToSearch) {
    	if(stringToSearch == null)
    		return -1;
		return this.string.indexOf(stringToSearch, this.start);
	}

	public StringTrimmer getBeforeNext(String stringToSearch) {
        if(this.string==null)
        	return this;
        int index = getIndex(stringToSearch);
        if (index > -1) {
            this.end = Math.max(this.start, index );
        }
        return this;
    }

    @Override
    public String toString() {
    	 if(this.string==null)
         	return null;
    	 return this.string.substring(this.start, this.end);
    }
}
