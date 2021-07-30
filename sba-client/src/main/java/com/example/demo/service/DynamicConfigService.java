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

	public Map<String, String> getConfig() {
		Map<String, String> map = new HashMap<>();
		map.put("test.user.age", profile);
		map.put("test.comm", comment);
		return map;
	}
}
