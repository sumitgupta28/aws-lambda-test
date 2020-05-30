package com.aws.lambda.widget.model;

public class WidgetRequest {
	private String id;

	public WidgetRequest() {
	}

	public WidgetRequest(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WidgetRequest [id=" + id + "]";
	}

}
