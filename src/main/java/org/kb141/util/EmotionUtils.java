package org.kb141.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.kb141.domain.CheckTimeVO;
import org.kb141.domain.CheckVO;
import org.springframework.stereotype.Repository;

@Repository
public class EmotionUtils {

	private String[] keys = { "happiness", "neutral", "sadness", "anger", "fear","surprise"};
	
	private JSONParser parser = new JSONParser();
	
	public Map<String, Integer> emotionCounter(List<CheckTimeVO> resultList) throws ParseException {
		Map<String, Integer> emotionMap = new HashMap<String, Integer>();

		for (String key : keys) {
			emotionMap.put(key, 0);
		}
		
		for (CheckTimeVO checkTimeVO : resultList) {
			JSONObject obj = (JSONObject) parser.parse("{" + checkTimeVO.getEmotion() + "}");
			long highScore = -1;
			long currScore;
			String state = null;
			for (String key : keys) {
				currScore = (Long) obj.get(key);
				if(highScore < currScore) {
					highScore = currScore;
					state = key;
				}
			}
			emotionMap.put(state, emotionMap.get(state) + 1);		
		}
		
		return emotionMap;
		
	}
	
	public List<String> emotionHandler(List<CheckVO> resultList) throws ParseException {
		List<String> result = new ArrayList<String>();
		
		for (CheckVO checkVO : resultList) {
			JSONObject obj = (JSONObject) parser.parse("{" + checkVO.getEmotion() + "}");
			double highScore = -1;
			double currScore;
			String state = null;
			for (String key : keys) {
				currScore = (Double) obj.get(key);
				if(highScore < currScore) {
					highScore = currScore;
					state = key;
				}
			}
			result.add(state);		
		}
		
		return result;
		
	}
	
	
}
