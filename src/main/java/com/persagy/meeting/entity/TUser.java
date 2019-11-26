package com.persagy.meeting.entity;

import java.io.Serializable;
import java.util.Date;

public class TUser implements Serializable {
    private String cUserId;

    private String cUserName;

    private String cMd5;

    private String cPassword;

    private String cState;

    private String cIsAdmin;

    private String cType;

    private Date cCreateTime;

    private Date cUpdateTime;

    private String cFunctions;

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }

    public String getcUserName() {
        return cUserName;
    }

    public void setcUserName(String cUserName) {
        this.cUserName = cUserName == null ? null : cUserName.trim();
    }

    public String getcMd5() {
        return cMd5;
    }

    public void setcMd5(String cMd5) {
        this.cMd5 = cMd5 == null ? null : cMd5.trim();
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState == null ? null : cState.trim();
    }

    public String getcIsAdmin() {
        return cIsAdmin;
    }

    public void setcIsAdmin(String cIsAdmin) {
        this.cIsAdmin = cIsAdmin == null ? null : cIsAdmin.trim();
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public Date getcUpdateTime() {
        return cUpdateTime;
    }

    public void setcUpdateTime(Date cUpdateTime) {
        this.cUpdateTime = cUpdateTime;
    }

    public String getcFunctions() {
        return cFunctions;
    }

    public void setcFunctions(String cFunctions) {
        this.cFunctions = cFunctions == null ? null : cFunctions.trim();
    }
}