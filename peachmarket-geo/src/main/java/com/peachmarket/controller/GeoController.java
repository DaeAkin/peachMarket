package com.peachmarket.controller;


import com.peachmarket.geo.GeoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** TODO
 * 1. x,y 좌표를 행정구역으로 반환
 * 2. 사용자가 자기네 동네를 입력하면 그 동네를 반환
 */
@RequestMapping("/v1/api/geo")
@AllArgsConstructor
public abstract class GeoController {


    /** Resonse를 어떻게줄까.
     * 추후에 Kakao가 아닌 다른 지도 API를 쓸 경우를 고려해봐야함.
     * Kakao API로 response로 받고, API 종속되지 않는 Response를 하나 만들어서
     * 그 Response에 맵핑시켜줘야겠다.
     */
    //x,y좌표를 행정구역으로 반환
    @GetMapping
   abstract public ResponseEntity<GeoResponse> getMyLocationByXAndY(@RequestParam float x,@RequestParam float y);

//    @GetMapping("/query")
//    abstract public ResponseEntity<>

}
