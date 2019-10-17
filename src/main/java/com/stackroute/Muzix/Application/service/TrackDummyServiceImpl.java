package com.stackroute.Muzix.Application.service;

import com.stackroute.Muzix.Application.domain.Track;
import com.stackroute.Muzix.Application.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.Application.exceptions.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Qualifier("trackDummyServiceImpl")
public class TrackDummyServiceImpl implements TrackService {
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public List getAllTracks() {
        return null;
    }

    @Override
    public Track updateTrack(int id, Track track) {
        return null;
    }

    @Override
    public List updatedTracks(Track track, int id) {
        return null;
    }

    @Override
    public Optional<Track> findByTrackName(String trackName) throws TrackNotFoundException {
        return Optional.empty();
    }
}
