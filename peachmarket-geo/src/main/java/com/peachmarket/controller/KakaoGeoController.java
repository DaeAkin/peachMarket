package com.peachmarket.controller;

import com.peachmarket.geo.GeoResponse;
import com.peachmarket.geo.KakaoGeoAddressResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Slf4j
@RestController
//@RequestMapping("/v1/api/geo")
public class KakaoGeoController extends GeoController{

    private final WebClient webClient = WebClient.builder().build();
    private final String API_KEY = "65f9cd448f85f73f1e20f99636e77420";
    private final String HOST = "https://dapi.kakao.com";

    @Override
    public ResponseEntity<GeoResponse> getMyLocationByXAndY(float x, float y) {
        String request_url = HOST + "/v2/local/geo/coord2address.json?x="+x+"&y="+y;

        KakaoGeoAddressResponse kakaoGeoAddressResponse = webClient.get()
                .uri(request_url)
                .header("Authorization","KakaoAK "+API_KEY)
                .retrieve()
                .bodyToMono(KakaoGeoAddressResponse.class)
                .block();

        GeoResponse geoResponse = kakaoGeoAddressResponse.toGeoResponse();


        return new ResponseEntity<>(geoResponse, HttpStatus.OK);
    }
}
