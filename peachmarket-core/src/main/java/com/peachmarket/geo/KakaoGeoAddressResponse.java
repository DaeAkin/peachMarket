package com.peachmarket.geo;

import lombok.*;

import java.util.List;

@Data

public class KakaoGeoAddressResponse {

    private Meta meta;
    private List<Document> documents;

   @Data
    static public class Meta {
        private Integer total_count;
    }

    @Data
    static public class Document {
        private Address address;

        @Data
        static public class Address{
            private String address_name;
            private String region_1depth_name;
            private String region_2depth_name;
            private String region_3depth_name;

        }

    }

    public GeoResponse toGeoResponse() {
       return GeoResponse.builder()
               .location(getDocuments().get(0).getAddress().getRegion_1depth_name() +" " +
                       getDocuments().get(0).getAddress().getRegion_2depth_name() +" " +
                       getDocuments().get(0).getAddress().getRegion_3depth_name())
               .build();
    }

}

