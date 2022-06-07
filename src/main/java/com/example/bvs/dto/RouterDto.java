package com.example.bvs.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RouterDto {
    private long accountId;
    private String accountName;
    private Date creationDate;
    private Date updateDate;
}