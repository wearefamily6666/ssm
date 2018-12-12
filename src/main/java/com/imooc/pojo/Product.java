package com.imooc.pojo;

public class Product {
    private Integer pid;

    private String pname;

    private Long pcount;

    private String pintroduce;

    public Product(String pname, Long pcount, String pintroduce) {
		super();
		this.pname = pname;
		this.pcount = pcount;
		this.pintroduce = pintroduce;
	}

	public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Long getPcount() {
        return pcount;
    }

    public void setPcount(Long pcount) {
        this.pcount = pcount;
    }

    public String getPintroduce() {
        return pintroduce;
    }

    public void setPintroduce(String pintroduce) {
        this.pintroduce = pintroduce == null ? null : pintroduce.trim();
    }
}