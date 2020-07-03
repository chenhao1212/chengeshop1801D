package com.chenhao.user.common;

/**
 * 
 * @author 45466
 *
 */
public class MsgData {
	
	// 正常返回
	int errorCode = 0;
	// 错误信息
	String errorInfo="";
	// 返回的数据
	Object Data;
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
	
	public MsgData(int errorCode, String errorInfo) {
		super();
		this.errorCode = errorCode;
		this.errorInfo = errorInfo;
	}
	
	public MsgData(Object data) {
		super();
		Data = data;
	}
	
	

}
