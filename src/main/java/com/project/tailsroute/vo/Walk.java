package com.project.tailsroute.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Walk {
    private int id;
    private String regDate;
    private String updateDate;
    private int memberId;
    private String routeName;
    private String purchaseDate;
    private String purchaseTime;
    private String routePicture;
    private double routedistance;
    private String location;
}