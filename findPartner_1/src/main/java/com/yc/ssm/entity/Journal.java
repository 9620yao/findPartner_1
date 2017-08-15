package com.yc.ssm.entity;

/**
 * 日志模块
 * 
 * @author 姚秋林
 *
 */
public class Journal {

	private int jid;//
	private int uid;// 用户编号
	private String content;// 上传内容
	private String jdate;// 上传时间

	public Journal() {
	}

	public Journal(int jid, int uid, String content, String jdate) {
		this.jid = jid;
		this.uid = uid;
		this.content = content;
		this.jdate = jdate;
	}

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getJdate() {
		return jdate;
	}

	public void setJdate(String jdate) {
		this.jdate = jdate;
	}

	@Override
	public String toString() {
		return "\nJournal [jid=" + jid + ", uid=" + uid + ", content=" + content + ", jdate=" + jdate + "]";
	}

}
