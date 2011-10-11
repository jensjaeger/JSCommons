package com.jsing.common.file;

import java.io.File;
import java.io.IOException;

public abstract class MultipleFileHandler {
	public void iterateDir(File dir) throws IOException {
		for (File f : dir.listFiles()) {
			handleFile(f);
		}
	}

	protected abstract void handleFile(File f) throws IOException;
}
