package br.com.brasilcardfacil.www.brasilcardfacil.controller.domain;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

    public String name;
    public String email;
    public String birth;
    public String phone;
    public String sex;
    public String plan;
    public String profile_pic;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String name, String email, String birth, String phone, String sex, String plan, String profile_pic) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.phone = phone;
        this.sex = sex;
        this.plan = plan;
        this.profile_pic = profile_pic;
    }

}