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
	private String uid; // 用户编号
	private String fid; // 好友编号
	private String sure; // 状态

	public Friends() {
	}

	public Friends(String uid, String fid, String sure) {
		this.uid = uid;
		this.fid = fid;
		this.sure = sure;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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
		return "\nFriends [uid=" + uid + ", fid=" + fid + ", sure=" + sure + "]";
	}

}
