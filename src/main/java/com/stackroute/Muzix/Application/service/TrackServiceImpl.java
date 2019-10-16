package com.stackroute.Muzix.Application.service;

import com.stackroute.Muzix.Application.Repository.TrackRepository;
import com.stackroute.Muzix.Application.tracks.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List getAllTracks() {
        List trackList = trackRepository.findAll();
        return trackList;
    }

    @Override
    public Track updateTrack(int id,Track track) {
        Optional<Track> updatedTrack1 = trackRepository.findById(id);
        track.setId(id);

        return track;
    }

    @Override
    public List updatedTracks(Track track,int id) {
        trackRepository.deleteById(id);
        List updatedTracks= trackRepository.findAll();
        return updatedTracks;
    }

    @Override
    public Optional<Track> findByTrackName(String trackName) {
     Optional<Track> track  = trackRepository.findByTrackName(trackName);
        return track;
    }
}
