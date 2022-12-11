package com.tobias.salerservice.inner.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Saler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickname;
    private String email;
    private String gender;
    private String birth;
    private String phone;
    private String website;
    private boolean verified;

    public static Saler createClient(RequestSaler requestSaler){
        Saler saler = new Saler();
        saler.setName(requestSaler.getName());
        saler.setNickname(requestSaler.getNickname());
        saler.setEmail(requestSaler.getEmail());
        saler.setGender(requestSaler.getGender());
        saler.setBirth(requestSaler.getBirth());
        saler.setPhone(requestSaler.getPhone());
        saler.setWebsite(requestSaler.getWebsite());
        saler.setVerified(false);
        return saler;
    }
}
