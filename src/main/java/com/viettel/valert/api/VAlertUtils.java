package com.viettel.valert.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.viettel.valert.api.model.ContentRequest;
import com.viettel.valert.api.model.ReallocateDocumentResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class VAlertUtils {

    public static ReallocateDocumentResponse createSMSForBusiness(ContentRequest contentRequest) {
        ReallocateDocumentResponse response;
        String urlApi = Constant.URL + Constant.BSMS;
        response = (ReallocateDocumentResponse) sendPostRequest(urlApi, contentRequest, ReallocateDocumentResponse.class);
        return response;
    }

    public static ReallocateDocumentResponse createSMSForUsers(ContentRequest contentRequest) {
        ReallocateDocumentResponse response;
        String urlApi = Constant.URL + Constant.USMS;
        response = (ReallocateDocumentResponse) sendPostRequest(urlApi, contentRequest, ReallocateDocumentResponse.class);
        return response;
    }

    public static ReallocateDocumentResponse createEmailForBusiness(ContentRequest contentRequest) {
        ReallocateDocumentResponse response;
        String urlApi = Constant.URL + Constant.BMAIL;
        response = (ReallocateDocumentResponse) sendPostRequest(urlApi, contentRequest, ReallocateDocumentResponse.class);
        return response;
    }

    public static ReallocateDocumentResponse createEmailForUsers(ContentRequest contentRequest) {
        ReallocateDocumentResponse response;
        String urlApi = Constant.URL + Constant.UMAIL;
        response = (ReallocateDocumentResponse) sendPostRequest(urlApi, contentRequest, ReallocateDocumentResponse.class);
        return response;
    }

    public static Object sendPostRequest(String urlApi, ContentRequest contentRequest, Class responseClass) {
        Gson gson = new Gson();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            String secretKey = getSecretKey();
            HttpPost httpPost = new HttpPost(urlApi);
            httpPost.setHeader("Authorization", "Bearer 0ff7113bcba18a38dbfd2a5bb54323bc578dfcb427233a301f3b85616fd9f728");
            StringEntity postingString = new StringEntity(gson.toJson(contentRequest));
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(postingString);
            HttpResponse response = httpClient.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            return objectMapper.readValue(responseString, responseClass);
        } catch (Exception exception) {
            return null;
        }
    }

    private static String getSecretKey() {
        return "";
    }
}
