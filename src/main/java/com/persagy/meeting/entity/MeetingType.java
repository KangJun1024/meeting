package com.persagy.meeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "meeting_type",indexes = {

})
public class MeetingType implements Serializable {
    @Id
    @Column(name = "type_id",length = 36)
    private String typeId;
    @Column(name = "type_name",length = 100,nullable = false)
    private String typeName;
    @Column(name = "create_time",nullable = false)
    private String createTime;
    @Column(name = "update_time",nullable = false)
    private String updateTime;
    @Column(name = "valid",length = 1,nullable = false)
    private Boolean valid;

    private static final long serialVersionUID = 1L;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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