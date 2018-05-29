package com.hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "login", schema = "blog_data", catalog = "")
public class UserEntity {
    private int uId;
    private String uName;
    private String uPassword;
    private Identity identity;


    @Id
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_name")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "u_password")
    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "identity")
    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (uId != that.uId) return false;
        if (uName != null ? !uName.equals(that.uName) : that.uName != null) return false;
        if (uPassword != null ? !uPassword.equals(that.uPassword) : that.uPassword != null) return false;
        if (identity != null ? !identity.equals(that.identity) : that.identity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + (uPassword != null ? uPassword.hashCode() : 0);
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        return result;
    }
}
