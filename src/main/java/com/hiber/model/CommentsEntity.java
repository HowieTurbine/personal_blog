package com.hiber.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Comments", schema = "blog_data", catalog = "")
public class CommentsEntity {
    private int idC;
    private int idA;

    public CommentsEntity() {

    }

    public CommentsEntity(int idC, int idA, String username, String com, Timestamp time) {

        this.idC = idC;
        this.idA = idA;
        this.username = username;
        this.com = com;
        this.time = time;
    }

    private String username;
    private String com;
    private Timestamp time;

    @Id
    @Column(name = "Id_C")
    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    @Basic
    @Column(name = "Id_A")
    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "com")
    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentsEntity that = (CommentsEntity) o;

        if (idC != that.idC) return false;
        if (idA != that.idA) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (com != null ? !com.equals(that.com) : that.com != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idC;
        result = 31 * result + idA;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (com != null ? com.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
