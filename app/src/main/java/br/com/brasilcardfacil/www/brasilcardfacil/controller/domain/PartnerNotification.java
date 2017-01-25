package br.com.brasilcardfacil.www.brasilcardfacil.controller.domain;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class PartnerNotification {

    public String name, url_logo, description, address, phone, site;
    public Double latitude, longitude;

    public PartnerNotification() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public PartnerNotification(String name, String url_logo, String description, String address, String phone,
                                String site, Double latitude, Double longitude) {
        this.name = name;
        this.url_logo = url_logo;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.site = site;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
