package com.hug.models;

import java.util.List;

public class GenericResponseEntity<T> {

	private List<T> dataList;
	private ErrorResponseEntity errorResponse;
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public ErrorResponseEntity getErrorResponse() {
		return errorResponse;
	}
	public void setErrorResponse(ErrorResponseEntity errorResponse) {
		this.errorResponse = errorResponse;
	}
	
}
