package com.tobias.salerservice.inner.domain;

import lombok.Data;

import java.util.Date;

@Data
public class RequestSaler {
    private int id;
    private String name;
    private String nickname;
    private String email;
    private Saler.Gender gender;
    private Date birth;
    private String phone;
    private String website;
}
