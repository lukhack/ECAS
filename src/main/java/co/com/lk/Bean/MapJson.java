/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.primefaces.model.map.LatLng;
/**
 *
 * @author lukhack
 */
public class MapJson {
    
    
    public static LatLng readJson(String url) throws Exception{
            
            InputStream inputStream = null;
            String json = "";

        try {           
                
                CloseableHttpClient client = HttpClientBuilder.create().build();
                HttpPost httpPostRequest = new HttpPost(url);
                
                HttpResponse response = client.execute(httpPostRequest);
                HttpEntity entity = response.getEntity();
                inputStream = entity.getContent();
              
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"),8);
                StringBuilder sbuild = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sbuild.append(line);
                }
                inputStream.close();
                json = sbuild.toString();               
           


                //now parse
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(json);
                JSONObject jb = (JSONObject) obj;

                //now read

                String jsonResult =  jb.get("status").toString();

                if(Objects.equals(jsonResult.toLowerCase(), "ok")){

                    JSONArray jsonObject1 = (JSONArray) jb.get("results");
                    JSONObject jsonObject2 = (JSONObject)jsonObject1.get(0);
                    JSONObject jsonObject3 = (JSONObject)jsonObject2.get("geometry");
                    JSONObject location = (JSONObject) jsonObject3.get("location");

                    System.out.println( "Lat = "+location.get("lat"));
                    System.out.println( "Lng = "+location.get("lng"));

                    return new LatLng(Double.valueOf((String) location.get("lat")), Double.valueOf((String)location.get("lng")));

                }else{
                    throw new Exception("No se procesaron los datos");
                }

            } catch(Exception e) {
                throw new Exception(e.getMessage());
            }

        }
}
