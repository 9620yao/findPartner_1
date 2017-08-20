package com.yc.ssm.entity;

import java.io.Serializable;
import java.util.List;

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
	private Users user;
	private List<Replys> Replys;
	private String c_uuid;// 标识符

	public Comments() {
	}

	public Comments(String cid, String callid, String detail, String comuserid, String comTime, Users user) {
		this.cid = cid;
		this.callid = callid;
		this.detail = detail;
		this.comuserid = comuserid;
		this.comTime = comTime;
		this.user = user;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Replys> getReplys() {
		return Replys;
	}

	public void setReplys(List<Replys> replys) {
		Replys = replys;
	}

	public String getC_uuid() {
		return c_uuid;
	}

	public void setC_uuid(String c_uuid) {
		this.c_uuid = c_uuid;
	}

	@Override
	public String toString() {
		return "\nComments [cid=" + cid + ", callid=" + callid + ", detail=" + detail + ", comuserid=" + comuserid
				+ ", comTime=" + comTime + ", user=" + user + ", Replys=" + Replys + ", c_uuid=" + c_uuid + "]";
	}

}
