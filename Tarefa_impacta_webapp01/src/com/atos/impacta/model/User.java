package com.atos.impacta.model;

public class User{
  private String login="atos";
  private String pass="123";
  
  public User(){
  }
  
  public String getLogin(){
	return this.login;
  }
  
  public void setLogin(String value){
    this.login=value;
  }
  
  public String getPass(){
	return this.pass;
  }
  
  public void setPass(String value){
    this.pass=value;
  }
}