package cn.sinapp.txai.domain;

import com.google.gson.annotations.SerializedName;

public class WeixinSession {
	
	@SerializedName("openid") 
	private String openid;	//用户唯一标识
	
	@SerializedName("session_key") 
	private String sessionKey;	//会话密钥
	
	@SerializedName("unionid") 
	private String unionid;
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	

}
