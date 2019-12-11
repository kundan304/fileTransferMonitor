package com.queueManager;

import java.io.File;

public class FileMapper {
   private File file;
   private boolean isLastFile;
public File getFile() {
	return file;
}
public void setFile(File file) {
	this.file = file;
}
public boolean isLastFile() {
	return isLastFile;
}
public void setLastFile(boolean isLastFile) {
	this.isLastFile = isLastFile;
}
}
