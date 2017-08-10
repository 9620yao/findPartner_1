package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 说说
 * 
 * @author 姚秋林
 *
 */
public class Speaks implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sid; // 说说编号
	private String content; // 说说内容
	private String speakman; // 说说发表人编号
	private String files; // 上传文件，视频，音乐等
	private String senddate; // 发说说时间

	public Speaks() {
	}

	public Speaks(String sid, String content, String speakman, String files, String senddate) {
		this.sid = sid;
		this.content = content;
		this.speakman = speakman;
		this.files = files;
		this.senddate = senddate;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSpeakman() {
		return speakman;
	}

	public void setSpeakman(String speakman) {
		this.speakman = speakman;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getSenddate() {
		return senddate;
	}

	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}

	@Override
	public String toString() {
		return "\nSpeaks [sid=" + sid + ", content=" + content + ", speakman=" + speakman + ", files=" + files
				+ ", senddate=" + senddate + "]";
	}

}
