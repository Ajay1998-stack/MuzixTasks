package com.stackroute.Muzix.Application.service;

import com.stackroute.Muzix.Application.tracks.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track);

    public List getAllTracks();

    public Track updateTrack(int id,Track track);

    public List updatedTracks(Track track,int id);

    public Optional<Track> findByTrackName(String trackName);
}
