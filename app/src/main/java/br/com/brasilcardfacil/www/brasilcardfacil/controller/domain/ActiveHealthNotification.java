package br.com.brasilcardfacil.www.brasilcardfacil.controller.domain;

public class ActiveHealthNotification {

    public String title, url_banner, description;

    public ActiveHealthNotification() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ActiveHealthNotification(String title, String url_banner, String description) {
        this.title = title;
        this.url_banner = url_banner;
        this.description = description;
    }
}
