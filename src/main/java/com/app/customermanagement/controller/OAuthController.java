package com.app.customermanagement.controller;

import java.util.Base64;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.customermanagement.config.ParamConfig;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/oauth2")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class OAuthController {

	private final WebClient webClient;
	private final ParamConfig paramConfig;

	
	@PostMapping("/exchange-token")
    public Mono<Map<String, Object>> exchangeToken(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString("client:secret".getBytes());

        return webClient.post()
                .uri(paramConfig.getIssuerUri() + "/oauth2/token")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .header(HttpHeaders.AUTHORIZATION, basicAuth)
                .bodyValue("grant_type=authorization_code" +
                        "&code=" + code +
                        "&" + paramConfig.getRedirectUri())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {});
    }
	
    @PostMapping("/refresh-token")
    public Mono<Map<String, Object>> refreshToken(@RequestBody Map<String, String> request) {
    	String basicAuth = "Basic " + Base64.getEncoder().encodeToString("client:secret".getBytes());
        return webClient.post()
                .uri(paramConfig.getIssuerUri() + "/oauth2/token")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .header(HttpHeaders.AUTHORIZATION, basicAuth)
                .body(BodyInserters.fromFormData("grant_type", "refresh_token")
                        .with("refresh_token", request.get("refreshToken")))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
    }
	
	
	
	
}