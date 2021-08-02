package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class DynamicConfigService {
	
	@Value("${test.user.age}")
	private String profile;
	@Value("${test.comm}")
	private String comment;

	@Value("${test1.comm}")
	private String comment1;

	public Map<String, String> getConfig() {
		Map<String, String> map = new HashMap<>();
		map.put("test.user.age", profile);
		map.put("test.comm", comment);
		map.put("test1.comm", comment1);
		return map;
	}
}
