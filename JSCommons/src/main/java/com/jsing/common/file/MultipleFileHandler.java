package com.jsing.common.file;

import java.io.File;
import java.io.IOException;

public abstract class MultipleFileHandler {
    
    boolean isRecursive = true;
    
	public void iterateDir(File dir) throws IOException {
		for (File f : dir.listFiles()) {
			handleFile(f);
		}
	}
	
    public MultipleFileHandler setRecursive(boolean isRecursive) {
        this.isRecursive = isRecursive;
        return this;
    }

	protected void handleDir(File f) throws IOException {
	    if(isRecursive){
	        iterateDir(f);
	    }
	}
	
	protected void handleFile(File f) throws IOException{
	    // default: do nothing, can be overriden by child class
	}
}
