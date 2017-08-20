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
	private String hpuseid;// 用来存放说说/图片发表人的编号
	private String hpdate;// 用来存放说说/图片 的发表时间
	private Users user;
	private Speaks speak;
	private Albumpic albumpic;
	private String h_uuid;// 标识符

	public Homepage() {
	}

	public Homepage(String hpid, String hpuseid, String hpdate) {
		this.hpid = hpid;
		this.hpuseid = hpuseid;
		this.hpdate = hpdate;
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
		return "\nHomepage [hpid=" + hpid + ", hpuseid=" + hpuseid + ", hpdate=" + hpdate + ", user=" + user
				+ ", speak=" + speak + ", albumpic=" + albumpic + ", h_uuid=" + h_uuid + "]";
	}

}
