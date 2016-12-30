package org.kb141.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

/**
 * 
 * Thanks to 단색화
 * @author Camellia
 *
 */

@Repository
public class FaceAPIUtils {
/*
 * 	1. 프로그램 등록 할 때 PersonGroupId 생성됨 (CreatePersonGroup.java)
	2. 수강신청 완료되면 PersonId 생성됨 (CreatePerson.java)
	3. 인증용 사진 등록- faceId생성됨 (AddPersonFace.java)
	4. 카메라 앞을 지나갈 때 얼굴이 인식되고 사진이 찍히면
	   DetectFace.java에서 faceId가 리턴됨
	   IdentifyFace.java에 파라미터로 위의 faceId가 들어가서 해당하는 PersonId가 리턴됨
 * 
 */
	
	// PARAM : 강좌명, personGroupId,
	// RETURN : 없음
	
	private HttpClient httpclient = HttpClients.createDefault();
	
	public void createPersonGroupId(String pcourse, String personGroupId) {
//		HttpClient httpclient = HttpClients.createDefault();

		try {
			URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/face/v1.0/persongroups/" + personGroupId);

			URI uri = builder.build();
			HttpPut request = new HttpPut(uri);
			request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", "935f6dcdc2154d5aa9a794fe1e53e0e6");

			// Request body
			StringEntity reqEntity = new StringEntity("{'name':'"+ pcourse +"'}");
			request.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				System.out.println("TEST.....");
				System.out.println("ENTITY: "+entity);
				System.out.println("RESPONSE: " + response);
				System.out.println(EntityUtils.toString(entity));

				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	// RETURN : personId
	public String createPersonId(String sid, String personGroupId) {
		
//		HttpClient httpclient = HttpClients.createDefault();

		String personId = null;
		
        try {
            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/face/v1.0/persongroups/"+personGroupId+"/persons");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "935f6dcdc2154d5aa9a794fe1e53e0e6");


            // Request body
            StringEntity reqEntity = new StringEntity("{'name':'"+ sid +"'}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
				String data = EntityUtils.toString(entity);
				JSONParser parser = new JSONParser();
				JSONObject obj = (JSONObject) parser.parse(data);
				personId = (String) obj.get("personId");
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return personId;
	}
	
	// RETURN : persistedFaceId
	public String addPersonFace(String imgURL, String personId, String personGroupId) {
//		HttpClient httpclient = HttpClients.createDefault();
		
		String persistedFaceId = null;

        try
        {
            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/face/v1.0/persongroups/"+personGroupId+"/persons/"+personId+"/persistedFaces");

            builder.setParameter("userData", "test1");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "935f6dcdc2154d5aa9a794fe1e53e0e6");
            
            StringEntity reqEntity = new StringEntity("{'url':'"+imgURL+"'}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
				String data = EntityUtils.toString(entity);
				JSONParser parser = new JSONParser();
				JSONObject obj = (JSONObject) parser.parse(data);
				persistedFaceId = (String) obj.get("persistedFaceId");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return persistedFaceId;
	}
	
	// RETURN : 없어야 정상
	public void trainPersonGroup(String personGroupId) {
//		HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/face/v1.0/persongroups/"+personGroupId+"/train");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "935f6dcdc2154d5aa9a794fe1e53e0e6");


//            // Request body
//            StringEntity reqEntity = new StringEntity("{body}");
//            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
		
		
	}
	
	
	// RETURN : 'faceId','faceId','faceId', 
	public String detectFace(String imgURL) {
//		HttpClient httpclient = HttpClients.createDefault();
		
		String str = "";

		try {
			URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/face/v1.0/detect");

			builder.setParameter("returnFaceId", "true");

			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);
			request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", "935f6dcdc2154d5aa9a794fe1e53e0e6");

//			String filePath = "D:\\zzz\\identifytest.jpg";
//			File image = new File(filePath);
//			System.out.println(image.getName());
//			FileEntity reqEntity = new FileEntity(image);
			// Request body
			StringEntity reqEntity = new StringEntity("{'url':'"+imgURL+"'}");
			request.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			//결과값 JSON처럼 생긴 String
			String data = EntityUtils.toString(entity);

			//String을 JSON으로 변환
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(data);
			
			//JSON에서 faceId 추출해서 'faceId','faceId','faceId',  << 이모양으로 만들어서 str에 저장
			for(int i = 0 ; i < array.size(); i++){
				 JSONObject obj = (JSONObject) array.get(i);
				 str +=  "'" + obj.get("faceId") + "'," ;
			}

			if (entity != null) {
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return str;
	}
	
	
	
	
	public List<String> identifyFace(String faceIds, String personGroupId) {
//		HttpClient httpclient = HttpClients.createDefault();

		List<String> result = new ArrayList<String>();
		
        try
        {
            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/face/v1.0/identify");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "935f6dcdc2154d5aa9a794fe1e53e0e6");


            // Request body
            StringEntity reqEntity = new StringEntity("{'faceIds':["+faceIds+"],'personGroupId':'"+personGroupId+"','maxNumOfCandidatesReturned':1}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            
            String data = EntityUtils.toString(entity);
            
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(data);
            
//            JSONObject obj = (JSONObject) array.get(0);
//            JSONArray candidatesArray = (JSONArray) obj.get("candidates");
//            JSONObject candidatesObj = (JSONObject) candidatesArray.get(0);
//            String personId = (String) candidatesObj.get("personId");
//            JSONObject jsonObj = (JSONObject) parser.parse(data);
//            System.out.println(jsonObj);
            
            if (entity != null) 
            {
            	System.out.println(EntityUtils.toString(entity));
            	 for(int i = 0 ; i < array.size(); i++){
                 	JSONObject obj = (JSONObject) array.get(i);
                 	JSONArray candidatesArray = (JSONArray) obj.get("candidates");
                 	for(int j=0; j<candidatesArray.size(); j++){
                 		JSONObject candidatesObj = (JSONObject) candidatesArray.get(j);
                 		String personId = (String) candidatesObj.get("personId");
//                 		System.out.println(personId);
                 		result.add(personId);                 		
                 	}
                 }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return result;
        
	}
	
	public List<String> detectAndIdentifyFace(String imgURL, String personGroupId) {
		
		return identifyFace(detectFace(imgURL), personGroupId);
		
	}
	
	public List<String> emotionAPI(String imgURL){
		
//		HttpClient httpclient = HttpClients.createDefault();

		List<String> result = new ArrayList<String>();
		
		try {
			URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/emotion/v1.0/recognize");

			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);
			request.setHeader("Content-Type", "application/octet-stream");
			request.setHeader("Ocp-Apim-Subscription-Key", "5eb977da66c547adaa56953f6fee8410");
			
//			String filePath = "D:\\zzz\\jjh1.jpg";
//            File image = new File(filePath);
//            System.out.println(image.getName());
//            FileEntity reqEntity = new FileEntity(image);
			
			// Request body
			StringEntity reqEntity = new StringEntity("{'url':'"+imgURL+"'}");
			request.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				String data = EntityUtils.toString(entity);
				JSONParser parser = new JSONParser();
				JSONArray array = (JSONArray)parser.parse(data);
				
				for(int i = 0 ; i < array.size() ; i++){
					JSONObject obj = (JSONObject) array.get(i);
					String emotion = obj.get("scores").toString();
					result.add(emotion);
				}
				
				System.out.println(EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
		
	}
	
	
}
