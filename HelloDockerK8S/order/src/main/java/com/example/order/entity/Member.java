package com.example.order.entity;

import java.io.Serializable;

/**
 * @TableName member
 */
public class Member implements Serializable {
    private String id;

    private String memberCode;

    private String memberName;

    private String memberRemark;

    private Integer memberLevel;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberRemark() {
        return memberRemark;
    }

    public void setMemberRemark(String memberRemark) {
        this.memberRemark = memberRemark;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Member other = (Member) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMemberCode() == null ? other.getMemberCode() == null : this.getMemberCode().equals(other.getMemberCode()))
            && (this.getMemberName() == null ? other.getMemberName() == null : this.getMemberName().equals(other.getMemberName()))
            && (this.getMemberRemark() == null ? other.getMemberRemark() == null : this.getMemberRemark().equals(other.getMemberRemark()))
            && (this.getMemberLevel() == null ? other.getMemberLevel() == null : this.getMemberLevel().equals(other.getMemberLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMemberCode() == null) ? 0 : getMemberCode().hashCode());
        result = prime * result + ((getMemberName() == null) ? 0 : getMemberName().hashCode());
        result = prime * result + ((getMemberRemark() == null) ? 0 : getMemberRemark().hashCode());
        result = prime * result + ((getMemberLevel() == null) ? 0 : getMemberLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberCode=").append(memberCode);
        sb.append(", memberName=").append(memberName);
        sb.append(", memberRemark=").append(memberRemark);
        sb.append(", memberLevel=").append(memberLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}