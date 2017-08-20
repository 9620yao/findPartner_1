package com.yc.ssm.entity;

import java.io.Serializable;
import java.util.List;

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
	private List<Comments> comments;// 评论
	private Users user;// 回复
	private String s_uuid; // 标识幅

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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public String getS_uuid() {
		return s_uuid;
	}

	public void setS_uuid(String s_uuid) {
		this.s_uuid = s_uuid;
	}

	@Override
	public String toString() {
		return "\nSpeaks [sid=" + sid + ", content=" + content + ", speakman=" + speakman + ", files=" + files
				+ ", senddate=" + senddate + ", comments=" + comments + ", user=" + user + ", s_uuid=" + s_uuid + "]";
	}

}
