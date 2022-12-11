package com.tobias.salerservice.outer.dto;

import com.tobias.salerservice.inner.domain.Saler;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SalerDto implements Serializable {
    private int id;
    private String name;
    private String nickname;
    private String email;
    private String gender;
    private String birth;
    private String phone;
    private String website;
}


