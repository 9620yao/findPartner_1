package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 添加主页表，用来动态显示个人中心和他的主页
 * 
 * @author 姚秋林
 *
 */
public class Homepage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String hid;// 主键
	private String hpid;// 用来存放说说/图片的编号
	private String hpuseid;// 用来存放说说/图片发表人的编号
	private String hpdate;// 用来存放说说/图片 的发表时间

	public Homepage() {
	}

	public Homepage(String hid, String hpid, String hpuseid, String hpdate) {
		this.hid = hid;
		this.hpid = hpid;
		this.hpuseid = hpuseid;
		this.hpdate = hpdate;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getHpid() {
		return hpid;
	}

	public void setHpid(String hpid) {
		this.hpid = hpid;
	}

	public String getHpuseid() {
		return hpuseid;
	}

	public void setHpuseid(String hpuseid) {
		this.hpuseid = hpuseid;
	}

	public String getHpdate() {
		return hpdate;
	}

	public void setHpdate(String hpdate) {
		this.hpdate = hpdate;
	}

	@Override
	public String toString() {
		return "\nHomepage [hid=" + hid + ", hpid=" + hpid + ", hpuseid=" + hpuseid + ", hpdate=" + hpdate + "]";
	}

}
