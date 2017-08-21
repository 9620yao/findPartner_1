package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 主页视图，按时间顺序显示主页信息
 * 
 * @author 姚秋林
 *
 */
public class Homepage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String hpid;// 用来存放说说/图片的编号
	private String hpuserid;// 用来存放说说/图片发表人的编号
	private String hpdate;// 用来存放说说/图片 的发表时间
	private Users user;
	private Speaks speak;
	private Albumpic albumpic;
	private String h_uuid;// 标识符

	public Homepage() {
	}

	public Homepage(String hpid, String hpuserid, String hpdate) {
		this.hpid = hpid;
		this.hpuserid = hpuserid;
		this.hpdate = hpdate;
	}

	public String getHpid() {
		return hpid;
	}

	public void setHpid(String hpid) {
		this.hpid = hpid;
	}

	public String getHpuserid() {
		return hpuserid;
	}

	public void setHpuserid(String hpuserid) {
		this.hpuserid = hpuserid;
	}

	public String getHpdate() {
		return hpdate;
	}

	public void setHpdate(String hpdate) {
		this.hpdate = hpdate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Speaks getSpeak() {
		return speak;
	}

	public void setSpeak(Speaks speak) {
		this.speak = speak;
	}

	public Albumpic getAlbumpic() {
		return albumpic;
	}

	public void setAlbumpic(Albumpic albumpic) {
		this.albumpic = albumpic;
	}

	public String getH_uuid() {
		return h_uuid;
	}

	public void setH_uuid(String h_uuid) {
		this.h_uuid = h_uuid;
	}

	@Override
	public String toString() {
		return "\nHomepage [hpid=" + hpid + ", hpuserid=" + hpuserid + ", hpdate=" + hpdate + ", user=" + user
				+ ", speak=" + speak + ", albumpic=" + albumpic + ", h_uuid=" + h_uuid + "]";
	}

}
