package com.lj.exam.model;

import java.io.Serializable;

public class ExamRoomReq<T> implements Serializable{
	
	private static final long serialVersionUID = 4449086858595933530L;

	private boolean useCache = true;
	
	private T body;

	/**
	 * @return the useCache
	 */
	public boolean isUseCache() {
		return useCache;
	}

	/**
	 * @param useCache the useCache to set
	 */
	public void setUseCache(boolean useCache) {
		this.useCache = useCache;
	}

	/**
	 * @return the body
	 */
	public T getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(T body) {
		this.body = body;
	}

}
