package com.example.weather.integration.weather;


import com.example.weather.WeatherAppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class CovidService {
    private static final String COVID_URL =
            "https://api.covidtracking.com/v1/states/{state}/{20200501}.json";

    //Default CountryCode to USA
//    private static final String COUNTRY_CODE="us";

    private static final Logger logger = LoggerFactory.getLogger(CovidService.class);

    private final RestTemplate restTemplate;

//    private final String apiKey;

    public CovidService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
//        this.apiKey = properties.getApi().getKey();
    }


    public CovidDetails getCovidDetailsByState(String state ,long date) {
        logger.info("Requesting covid details for {}/{}", state, date);
        URI url = new UriTemplate(COVID_URL).expand(state, date );
        return invoke(url, CovidDetails.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate
                .exchange(request, responseType);
        return exchange.getBody();
    }

}


