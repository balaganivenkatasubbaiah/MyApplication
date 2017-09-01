package com.lyrebirdstudio.photoactivity;

public class PlayStoreVersionMessage {
    String language;
    String message;
    String title;

    public PlayStoreVersionMessage(String language, String title, String message) {
        this.language = language;
        this.title = title;
        this.message = message;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTitle() {
        return this.title;
    }
}
