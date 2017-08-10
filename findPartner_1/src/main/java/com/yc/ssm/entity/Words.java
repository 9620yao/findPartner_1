package com.yc.ssm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author 姚秋林，李文文
 *
 */
public class Words implements Serializable {// 留言板
	private static final long serialVersionUID = 3689509625432377305L;
	private String wid;
	private String waid;
	private String wfrendid;
	private String wcontent;
	private String waddress;
	private String wdate;
	private List<Comments> comments;
	private List<Replys> replys;

	public Words() {
	}

	public Words(String wid, String waid, String wfrendid, String wcontent, String waddress, String wdate,
			List<Comments> comments, List<Replys> replys) {
		this.wid = wid;
		this.waid = waid;
		this.wfrendid = wfrendid;
		this.wcontent = wcontent;
		this.waddress = waddress;
		this.wdate = wdate;
		this.comments = comments;
		this.replys = replys;
	}

	public List<Replys> getReplys() {
		return replys;
	}

	public void setReplys(List<Replys> replys) {
		this.replys = replys;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getWaid() {
		return waid;
	}

	public void setWaid(String waid) {
		this.waid = waid;
	}

	public String getWfrendid() {
		return wfrendid;
	}

	public void setWfrendid(String wfrendid) {
		this.wfrendid = wfrendid;
	}

	public String getWcontent() {
		return wcontent;
	}

	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}

	public String getWaddress() {
		return waddress;
	}

	public void setWaddress(String waddress) {
		this.waddress = waddress;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "\nWords [wid=" + wid + ", waid=" + waid + ", wfrendid=" + wfrendid + ", wcontent=" + wcontent
				+ ", waddress=" + waddress + ", wdate=" + wdate + ", comments=" + comments + ", replys=" + replys + "]";
	}

}
