package model;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionId = 1L;

    private String author;
    private String text;
    private String token;

    public Message(String a, String t) {
        author = a;
        text = t;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public String getToken() {
        return token;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("Autor: %s%nTexto: %s%nToken: %s", author, text, token);
    }
}
