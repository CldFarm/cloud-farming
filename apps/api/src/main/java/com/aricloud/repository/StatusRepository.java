package com.aricloud.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

}