package com.duoduopin.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class picPOJO {
    private Integer id;
    private long userid;
    private String name;
    private String url;
    public picPOJO(long userid,String name,String url)
    {
        this.userid = userid;
        this.name = name;
        this.url = url;
    }
    public picPOJO(){

    }
}
