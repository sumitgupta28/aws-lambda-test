package com.aws.lambda.widget.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.lambda.widget.model.Widget;
import com.aws.lambda.widget.model.WidgetRequest;

public class GetWidgetHandler implements RequestHandler<WidgetRequest, Widget> {

	@Override
	public Widget handleRequest(WidgetRequest widgetRequest, Context context) {
		System.out.println("Received Request " + widgetRequest.toString());
		System.out.println("---------- Env Variable -------");
		System.out.println("APPLICATION_TYPE --> " + System.getenv("APPLICATION_TYPE"));
		return new Widget(widgetRequest.getId(), "My Widget " + widgetRequest.getId());
	}

}
