package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 评论表
 * 
 * @author 姚秋林
 *
 */

public class Comments implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cid;// 评论编号
	private String callid;// 说说/相册/相片/留言 的编号
	private String detail;// 评论内容
	private String comuserid;// 评论用户编号
	private String comTime;// 评论时间
	private Users users;

	public Comments() {
	}

	public Comments(String cid, String callid, String detail, String comuserid, String comTime, Users users) {
		this.cid = cid;
		this.callid = callid;
		this.detail = detail;
		this.comuserid = comuserid;
		this.comTime = comTime;
		this.users = users;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCallid() {
		return callid;
	}

	public void setCallid(String callid) {
		this.callid = callid;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getComuserid() {
		return comuserid;
	}

	public void setComuserid(String comuserid) {
		this.comuserid = comuserid;
	}

	public String getComTime() {
		return comTime;
	}

	public void setComTime(String comTime) {
		this.comTime = comTime;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "\nComments [cid=" + cid + ", callid=" + callid + ", detail=" + detail + ", comuserid=" + comuserid
				+ ", comTime=" + comTime + ", users=" + users + "]";
	}

}
