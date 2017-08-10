package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 相册
 * 
 * @author 姚秋林
 *
 */
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;
	private String abid; // 相册编号
	private String abname; // 相册名称
	private String auid; // 相册发表人编号
	private String alcontent; // 相册内容（相册描述）
	private String allocation; // 相册上传位置
	private String aldate; // 相册上传时间
	private String aheader; // 相册最外面显示的图片

	public Album() {
	}

	public Album(String abid, String abname, String auid, String alcontent, String allocation, String aldate,
			String aheader) {
		this.abid = abid;
		this.abname = abname;
		this.auid = auid;
		this.alcontent = alcontent;
		this.allocation = allocation;
		this.aldate = aldate;
		this.aheader = aheader;
	}

	public String getAbid() {
		return abid;
	}

	public void setAbid(String abid) {
		this.abid = abid;
	}

	public String getAbname() {
		return abname;
	}

	public void setAbname(String abname) {
		this.abname = abname;
	}

	public String getAuid() {
		return auid;
	}

	public void setAuid(String auid) {
		this.auid = auid;
	}

	public String getAlcontent() {
		return alcontent;
	}

	public void setAlcontent(String alcontent) {
		this.alcontent = alcontent;
	}

	public String getAllocation() {
		return allocation;
	}

	public void setAllocation(String allocation) {
		this.allocation = allocation;
	}

	public String getAldate() {
		return aldate;
	}

	public void setAldate(String aldate) {
		this.aldate = aldate;
	}

	public String getAheader() {
		return aheader;
	}

	public void setAheader(String aheader) {
		this.aheader = aheader;
	}

	@Override
	public String toString() {
		return "\nAlbum [abid=" + abid + ", abname=" + abname + ", auid=" + auid + ", alcontent=" + alcontent
				+ ", allocation=" + allocation + ", aldate=" + aldate + ", aheader=" + aheader + "]";
	}

}
