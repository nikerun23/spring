package org.zerock.dto;

public class LoginDTO {

	private String uid;
	private String upw;
	private boolean useCookis;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public boolean isUseCookis() {
		return useCookis;
	}
	public void setUseCookis(boolean useCookis) {
		this.useCookis = useCookis;
	}
	
	
}
