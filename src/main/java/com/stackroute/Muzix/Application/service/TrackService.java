package com.stackroute.Muzix.Application.service;

import com.stackroute.Muzix.Application.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.Application.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.Application.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List getAllTracks();

    public Track updateTrack(int id,Track track);

    public List updatedTracks(Track track,int id);

    public Optional<Track> findByTrackName(String trackName) throws TrackNotFoundException;
}
