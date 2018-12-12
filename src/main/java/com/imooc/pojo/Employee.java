package com.imooc.pojo;

import java.util.Date;

public class Employee {
    private Integer eid;

    private String ename;

    private String sex;

    private Date birthday;

    private Date joindate;

    private String eno;

    private String username;

    private String password;

    private Integer did;

    public Employee() {
		super();
	}

	public Employee(String ename, String sex, Date birthday, Date joindate, String eno, String username,
			String password, Integer did) {
		super();
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.joindate = joindate;
		this.eno = eno;
		this.username = username;
		this.password = password;
		this.did = did;
	}

	public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno == null ? null : eno.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}