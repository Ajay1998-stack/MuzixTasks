package com.stackroute.Muzix.Application.seeds;

import com.stackroute.Muzix.Application.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.Application.service.TrackService;
import com.stackroute.Muzix.Application.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Autowired
    @Qualifier("trackServiceImpl")
    private TrackService trackService ;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        Track track1 = new Track();

        track1.setId(1);
        track1.setComments("lite");
        track1.setTrackName("hello hello");
        try {
            trackService.saveTrack(track1);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }

    }
}
