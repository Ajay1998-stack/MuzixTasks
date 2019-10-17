package com.stackroute.Muzix.Application.seeds;

import com.stackroute.Muzix.Application.service.TrackService;
import com.stackroute.Muzix.Application.domain.Track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {


    @Autowired
    @Qualifier("trackServiceImpl")
    TrackService trackService;


    @Value("${track.trackName}")
    private String trackName;

    @Value("${track.comments}")
    private String comments;

    @Value("${track.id}")
    private int id;

    @Override
    public void run(String... args) throws Exception {
        Track track= new Track(id,trackName,comments);

        trackService.saveTrack(track);
    }
}
