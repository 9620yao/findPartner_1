package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 好友
 * 
 * @author 苏利
 *
 */
public class Friends implements Serializable {

	private static final long serialVersionUID = 1L;
	private String aid; // 用户编号
	private String fid; // 好友编号
	private String sure; // 屏蔽状态

	public Friends() {
	}

	public Friends(String aid, String fid, String sure) {
		super();
		this.aid = aid;
		this.fid = fid;
		this.sure = sure;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getSure() {
		return sure;
	}

	public void setSure(String sure) {
		this.sure = sure;
	}

	@Override
	public String toString() {
		return "\nFriends [aid=" + aid + ", fid=" + fid + ", sure=" + sure + "]";
	}

}
