package br.com.brasilcardfacil.www.brasilcardfacil.controller.domain;

import java.io.Serializable;

public class ActiveHealth implements Serializable{

    private String title, url_banner, description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlBanner() {
        return url_banner;
    }

    public void setUrlBanner(String url_banner) {
        this.url_banner = url_banner;
    }
}
