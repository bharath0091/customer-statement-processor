package com.bank.fileProcessor;

public enum FileType {
    CSV,
    XML,
    INVALID;

    public static FileType getFileType(String type) {
        switch (type) {
            case "text/csv" : return CSV;
            case "application/xml" : return XML;
            default : return INVALID;
        }
    }
}
