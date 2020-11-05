package com.catc.hive.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeleHead {
    private String teleuid;
    private String telestatus;
    private String teletype;
    private String lineflag;
    private String serialnum;
    private String sendtimestr;
    private boolean ischangeline;
    private String telelevel;
    private String writtentimestr;
    private String senderaddr;
    private String receaddr;
    private String doublesign;
    private String sendermemo;
    private String telecontext;
    private int telelength;
    private int bodylength;
    private int forwardcount;
    private int bodypos;
    private String telebody;

}
