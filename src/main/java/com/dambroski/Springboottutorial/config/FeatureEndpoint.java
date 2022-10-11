package com.dambroski.Springboottutorial.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
	private final Map<String,Feature> fetuareMap = new ConcurrentHashMap<>();
	
	public FeatureEndpoint() {
		fetuareMap.put("Department",new Feature(true));
		fetuareMap.put("User",new Feature(false));
		fetuareMap.put("Authentication",new Feature(false));
	}
	
	@ReadOperation
	public Map<String,Feature> feastures(){
		return fetuareMap;
	}
	
	@ReadOperation
	public Feature feature(@Selector String featureName) {
		return fetuareMap.get(featureName);
	}
	
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class Feature{
		private boolean isEnabled;
	}
}
