package it.sella.operationalrisksuite.core.view;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="userInfo") 
public class UserInfoView implements Serializable {

  /**
   * 
  */
  private static final long serialVersionUID = 1L;

  private String name;
  
  private String surName;
  
  private String fullName;
  
  private String emailAddress;
  
  private String groupUserCode;
  
  private String userCode;
  
  private String clientIpAddress;

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getSurName() {
	return surName;
  }

  public void setSurName(String surName) {
	this.surName = surName;
  }

  public String getFullName() {
	return fullName;
  }

  public void setFullName(String fullName) {
	this.fullName = fullName;
  }

  public String getEmailAddress() {
	return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
  }

  public String getGroupUserCode() {
	return groupUserCode;
  }

  public void setGroupUserCode(String groupUserCode) {
	this.groupUserCode = groupUserCode;
  }

  public String getUserCode() {
	return userCode;
  }

  public void setUserCode(String userCode) {
	this.userCode = userCode;
  }

  public String getClientIpAddress() {
	return clientIpAddress;
  }

  public void setClientIpAddress(String clientIpAddress) {
	this.clientIpAddress = clientIpAddress;
  }
  
  public String toString(){
    return "User code :"+this.userCode+"  Name :"+this.name+" Email address :"+this.emailAddress+"  client IP :"+this.clientIpAddress;
  }
  
}
