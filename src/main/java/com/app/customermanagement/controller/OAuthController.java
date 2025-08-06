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

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/oauth2")
@CrossOrigin(origins = "*")
public class OAuthController {

	private WebClient webClient;

	public OAuthController(WebClient webClient) {
		this.webClient = webClient;
	}
	
	@PostMapping("/exchange-token")
    public Mono<Map<String, Object>> exchangeToken(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString("client:secret".getBytes());

        return webClient.post()
                .uri("http://localhost:9005/oauth2/token")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .header(HttpHeaders.AUTHORIZATION, basicAuth)
                .bodyValue("grant_type=authorization_code" +
                        "&code=" + code +
                        "&redirect_uri=http://localhost:4200/oauth2/callback")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {});
    }
	
    @PostMapping("/refresh-token")
    public Mono<Map<String, Object>> refreshToken(@RequestParam String refreshToken) {
        return webClient.post()
                .uri("http://localhost:9005/oauth2/token")
                .headers(headers -> headers.setBasicAuth("client", "secret"))
                .body(BodyInserters.fromFormData("grant_type", "refresh_token")
                        .with("refresh_token", refreshToken))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
    }
	
	
	
	
}