package com.trung.example.kiemtratuan9;

public class date_class {
    String title;
    String description;
    String result;
    int button;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getResult() {
        return result;
    }

    public int getButton() {
        return button;
    }

    public date_class(String title, String description, String result, int button) {
        this.title = title;
        this.description = description;
        this.result = result;
        this.button = button;
    }
}
