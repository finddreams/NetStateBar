package com.finddreams.bean;
/**
 * @Description:消息bean
 * @author http://blog.csdn.net/finddreams
 */ 
public class RecentChat {
	private String userName;
	private String userFeel;
	private String userTime;
	private String imgPath;
	public RecentChat(String userName, String userFeel, String userTime, String img) {
		super();
		this.userName = userName;
		this.userFeel = userFeel;
		this.userTime = userTime;
		this.imgPath = img;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserFeel() {
		return userFeel;
	}
	public void setUserFeel(String userFeel) {
		this.userFeel = userFeel;
	}
	public String getUserTime() {
		return userTime;
	}
	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String img) {
		this.imgPath = img;
	}
}
