package Decorator;

public class Data {
    String author;
    String content;
    Boolean isCompressed;
    Boolean isEncrypted;

    Boolean getIsCompressed() {
        return isCompressed;
    }

    void setIsCompressed(Boolean isCompressed) {
        this.isCompressed = isCompressed;
    }

    Boolean getIsEncrypted() {
        return isEncrypted;
    }

    void setIsEncrypted(Boolean isEncrypted) {
        this.isEncrypted = isEncrypted;
    }

    Data(String author, String content) {
        this.author = author;
        this.content = content;
        this.isEncrypted = false;
        this.isCompressed = false;
    }
}
