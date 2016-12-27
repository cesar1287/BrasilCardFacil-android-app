package br.com.brasilcardfacil.www.brasilcardfacil.controller.domain;

import java.io.Serializable;

public class Partner implements Serializable{

    private String name, url_logo, description, address, phone, site;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlLogo() {
        return url_logo;
    }

    public void setUrlLogo(String url_logo) {
        this.url_logo = url_logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
