package br.com.brasilcardfacil.www.brasilcardfacil.controller.domain;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class OfferNotification {

    public String url_banner, name, description, about, address, phone;
    public double latitude, longitude;

    public OfferNotification() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public OfferNotification(String name, String url_logo, String description, String address, String phone,
                               String site, Double latitude, Double longitude) {
        this.name = name;
        this.url_banner = url_logo;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.about = site;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
