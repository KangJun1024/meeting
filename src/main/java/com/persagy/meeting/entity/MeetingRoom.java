package com.persagy.meeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "meeting_room",indexes = {

})
public class MeetingRoom implements Serializable {
    @Id
    @Column(name = "room_id",length = 36)
    private String roomId;
    @Column(name = "name",length = 100,nullable = false)
    private String name;
    @Column(name = "type_id",length = 36)
    private String typeId;
    @Column(name = "capacity",length = 36)
    private String capacity;
    @Column(name = "equipments",length = 100)
    private String equipments;
    @Column(name = "pictures",length = 100)
    private String pictures;
    @Column(name = "create_time",nullable = false)
    private String createTime;
    @Column(name = "update_time",nullable = false)
    private String updateTime;
    @Column(name = "status",length = 1,nullable = false) //1:启动;0:停用;2:停用
    private String status;
    @Column(name = "valid",length = 1,nullable = false)
    private Boolean valid;

    private static final long serialVersionUID = 1L;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getEquipments() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}