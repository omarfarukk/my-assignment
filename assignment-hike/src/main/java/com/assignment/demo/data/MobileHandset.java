package com.assignment.demo.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@Document("mobile-handset")
@Data
@NoArgsConstructor
public class MobileHandset {
    @Id
    private Long id;
    private String brand;
    private String phone;
    private String picture;
    private Release release;
    private String sim;
    private String resolution;
    private Hardware hardware;

    @Data
    @NoArgsConstructor
    static class Release{
        private String announceDate;
        private String priceEur;
    }
    @Data
    @NoArgsConstructor
    static class Hardware{
        private String audioJack;
        private String gps;
        private String battery;
    }
}
