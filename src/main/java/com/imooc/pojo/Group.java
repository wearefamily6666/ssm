package com.imooc.pojo;

public class Group {
    private Integer gid;

    private String groupname;

    private String groupnotice;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getGroupnotice() {
        return groupnotice;
    }

    public void setGroupnotice(String groupnotice) {
        this.groupnotice = groupnotice == null ? null : groupnotice.trim();
    }
}