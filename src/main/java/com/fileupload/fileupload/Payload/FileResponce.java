package com.fileupload.fileupload.Payload;

public class FileResponce {
 private    String fileName;
   private String message;

    public FileResponce(String message, String fileName) {
        this.message = message;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
