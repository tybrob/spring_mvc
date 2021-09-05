package com.oreilly.mvc_example.services;

import com.oreilly.mvc_example.json.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

    private static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

    private RestTemplate resTemplate;

    @Autowired
    public JokeService (RestTemplateBuilder builder) {
        resTemplate = builder.build();
    }

    public String getJoke(String first, String last) {
        String url = String.format("%s&firstName=%s&lastName=%s",BASE,first,last);
        JokeResponse response = resTemplate.getForObject(url,JokeResponse.class);
        return response.getValue().getJoke();
    }
}
