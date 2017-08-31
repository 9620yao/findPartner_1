package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 相册集
 * 
 * @author 姚秋林
 *
 */
public class Albumpic implements Serializable {

	private static final long serialVersionUID = 1L;
	private String apid; // 相片编号
	private String abid; // 相册编号
	private String apic; // 图片
	private String apiccontent; // 图片描述
	private String apicdate; // 图片上传时间
	private String ap_uuid; // 唯一标识符
	private String uid; // 唯一标识符
	private Users user;

	public Albumpic() {
	}

	public Albumpic(String apid, String abid, String apic, String apiccontent, String apicdate) {
		this.apid = apid;
		this.abid = abid;
		this.apic = apic;
		this.apiccontent = apiccontent;
		this.apicdate = apicdate;
	}

	public String getApid() {
		return apid;
	}

	public void setApid(String apid) {
		this.apid = apid;
	}

	public String getAbid() {
		return abid;
	}

	public void setAbid(String abid) {
		this.abid = abid;
	}

	public String getApic() {
		return apic;
	}

	public void setApic(String apic) {
		this.apic = apic;
	}

	public String getApiccontent() {
		return apiccontent;
	}

	public void setApiccontent(String apiccontent) {
		this.apiccontent = apiccontent;
	}

	public String getApicdate() {
		return apicdate;
	}

	public void setApicdate(String apicdate) {
		this.apicdate = apicdate;
	}

	public String getAp_uuid() {
		return ap_uuid;
	}

	public void setAp_uuid(String ap_uuid) {
		this.ap_uuid = ap_uuid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "\nAlbumpic [apid=" + apid + ", abid=" + abid + ", apic=" + apic + ", apiccontent=" + apiccontent
				+ ", apicdate=" + apicdate + ", ap_uuid=" + ap_uuid + ", uid=" + uid + ", user=" + user + "]";
	}

}
