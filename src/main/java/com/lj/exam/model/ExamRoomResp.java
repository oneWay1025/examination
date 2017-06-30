package com.lj.exam.model;

import java.io.Serializable;

public class ExamRoomResp<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3218759904061373504L;
	/**
	 * 
	 */
	private String code;
	
	private String msg;

	private T body;


	public ExamRoomResp() {
       
    }
	
	public ExamRoomResp(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public ExamRoomResp(String code, String msg, T body){
		this.code = code;
		this.msg = msg;
		this.body = body;
	}
	
	public ExamRoomResp( T body) {
		this.body = body;
	}

	/**
	 * @return the body
	 */
	public T getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(T body) {
		this.body = body;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
