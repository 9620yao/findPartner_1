package com.yc.ssm.entity;

import java.io.Serializable;
/**
 * 
 * @author Administrator 管理员
 *
 */
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;
	private String baid; // 管理员编号
	private String baemail;// 管理员邮箱
	private String baname; // 管理员姓名
	private String bapwd; // 管理员密码
	private String badate;// 注册时间

	public Administrator() {
	}

	public Administrator(String baid, String baemail, String baname, String bapwd, String badate) {
		this.baid = baid;
		this.baemail = baemail;
		this.baname = baname;
		this.bapwd = bapwd;
		this.badate = badate;
	}

	public String getBaid() {
		return baid;
	}

	public void setBaid(String baid) {
		this.baid = baid;
	}

	public String getBaemail() {
		return baemail;
	}

	public void setBaemail(String baemail) {
		this.baemail = baemail;
	}

	public String getBaname() {
		return baname;
	}

	public void setBaname(String baname) {
		this.baname = baname;
	}

	public String getBapwd() {
		return bapwd;
	}

	public void setBapwd(String bapwd) {
		this.bapwd = bapwd;
	}

	public String getBadate() {
		return badate;
	}

	public void setBadate(String badate) {
		this.badate = badate;
	}

	@Override
	public String toString() {
		return "\nAdministrator [baid=" + baid + ", baemail=" + baemail + ", baname=" + baname + ", bapwd=" + bapwd
				+ ", badate=" + badate + "]";
	}

}
