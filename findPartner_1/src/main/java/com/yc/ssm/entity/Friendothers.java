package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 好友表
 * 
 * @author 苏利
 *
 */
public class Friendothers implements Serializable {

	private static final long serialVersionUID = 1L;
	private String aid; // 用户编号
	private String fid; // 好友编号
	private String othersure; // 屏蔽状态
	private String otherfriend; // 是否为陌生人

	public Friendothers() {

	}

	public Friendothers(String aid, String fid, String othersure, String otherfriend) {
		this.aid = aid;
		this.fid = fid;
		this.othersure = othersure;
		this.otherfriend = otherfriend;
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

	public String getOthersure() {
		return othersure;
	}

	public void setOthersure(String othersure) {
		this.othersure = othersure;
	}

	public String getOtherfriend() {
		return otherfriend;
	}

	public void setOtherfriend(String otherfriend) {
		this.otherfriend = otherfriend;
	}

	@Override
	public String toString() {
		return "\nFriendothers [aid=" + aid + ", fid=" + fid + ", othersure=" + othersure + ", otherfriend="
				+ otherfriend + "]";
	}

}
