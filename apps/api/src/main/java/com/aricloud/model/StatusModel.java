package com.aricloud.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.aricloud.interfaces.Status;

@DynamoDBTable(tableName = "PlotData")
public class StatusModel extends Status {

}