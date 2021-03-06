package com.yc.ssm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 回复：回复评论，或者针对回复进行回复
 * 
 * @author 姚秋林
 *
 */
public class Replys implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rid; // 回复编号
	private String rcid; // 评论编号和回复编号
	private String ruserid; // 当前回复用户的编号
	private String rtargetid; // 目标用户编号
	private String rcontent; // 回复内容
	private String rtime; // 回复时间
	private Users user;
	private Users puser;
	private List<Replys> replys; // 回复时间
	private String r_uuido; // 标识符
	private String r_uuidt; // 存储标识符

	public Replys() {
	}

	public Replys(String rid, String rcid, String ruserid, String rtargetid, String rcontent, String rtime) {
		this.rid = rid;
		this.rcid = rcid;
		this.ruserid = ruserid;
		this.rtargetid = rtargetid;
		this.rcontent = rcontent;
		this.rtime = rtime;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRcid() {
		return rcid;
	}

	public void setRcid(String rcid) {
		this.rcid = rcid;
	}

	public String getRuserid() {
		return ruserid;
	}

	public void setRuserid(String ruserid) {
		this.ruserid = ruserid;
	}

	public String getRtargetid() {
		return rtargetid;
	}

	public void setRtargetid(String rtargetid) {
		this.rtargetid = rtargetid;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public List<Replys> getReplys() {
		return replys;
	}

	public void setReplys(List<Replys> replys) {
		this.replys = replys;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getPuser() {
		return puser;
	}

	public void setPuser(Users puser) {
		this.puser = puser;
	}

	public String getR_uuido() {
		return r_uuido;
	}

	public void setR_uuido(String r_uuido) {
		this.r_uuido = r_uuido;
	}

	public String getR_uuidt() {
		return r_uuidt;
	}

	public void setR_uuidt(String r_uuidt) {
		this.r_uuidt = r_uuidt;
	}

	@Override
	public String toString() {
		return "\nReplys [rid=" + rid + ", rcid=" + rcid + ", ruserid=" + ruserid + ", rtargetid=" + rtargetid
				+ ", rcontent=" + rcontent + ", rtime=" + rtime + ", user=" + user + ", puser=" + puser + ", replys="
				+ replys + ", r_uuido=" + r_uuido + ", r_uuidt=" + r_uuidt + "]";
	}

}
