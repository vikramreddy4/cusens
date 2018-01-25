package com.pce;

import org.springframework.web.client.RestTemplate;

public class RestTestClient {
    
    private RestTemplate restTemplate;
    private UrlFactory urlFactory;
    
    public RestTestClient(RestTemplate template, String baseURI) {
        this.restTemplate = template;
        this.urlFactory = new UrlFactory(baseURI);
    }

//    public ResponseEntity<String> initiateAttPurchase(InitiatePurchaseRequest request) {
//        return restTemplate.postForEntity(urlFactory.initAttPurchaseUrl(), request, String.class);
//    }
//    
//    public ResponseEntity<String> initiateAttPurchaseForBadJason(InvalidInitiatePurchaseRequest request) {
//        return restTemplate.postForEntity(urlFactory.initAttPurchaseUrl(), request, String.class);
//    }
//    
//    public ResponseEntity<com.rhapsody.rpi.sprint.GetUserInfoResponse> sprintGetUserInfo(String mdn) {
//        return restTemplate.getForEntity(urlFactory.getUserInfoSprintUrl(), com.rhapsody.rpi.sprint.GetUserInfoResponse.class, mdn);
//    }
    
    public UrlFactory getRpiwsUrl() {
        return urlFactory;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}
