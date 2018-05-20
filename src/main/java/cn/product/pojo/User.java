package cn.product.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table( name = "users" )
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer uid;
    private String name;
    private String account;
    private String pass;
    private String phone;

    private Date retime;
    private Date logtime;
    private Byte type;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @JsonIgnore
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonSerialize( using = CustomDateSerializer.class )
    public Date getRetime() {
        return retime;
    }

    public void setRetime(Date retime) {
        this.retime = retime;
    }

    public Date getLogtime() {
        return logtime;
    }

    @JsonSerialize( using = CustomDateSerializer.class )
    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", pass='" + pass + '\'' +
                ", phone='" + phone + '\'' +
                ", retime=" + retime +
                ", logtime=" + logtime +
                ", type=" + type +
                '}';
    }
}
