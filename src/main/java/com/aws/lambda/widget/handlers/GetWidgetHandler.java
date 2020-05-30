package com.aws.lambda.widget.handlers;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
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
		// Create a connection to DynamoDB
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDB dynamoDB = new DynamoDB(client);

		// Get a reference to the Widget table
		Table table = dynamoDB.getTable("Widget");

		// Get our item by ID
		Item item = table.getItem("id", widgetRequest.getId());
		if (item != null) {
			System.out.println(item.toJSONPretty());

			// Return a new Widget object
			return new Widget(widgetRequest.getId(), item.getString("name"));
		} else {
			return new Widget();
		}
	}

}
