package com.stackroute.Muzix.Application.service;

import com.stackroute.Muzix.Application.Repository.TrackRepository;
import com.stackroute.Muzix.Application.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.Application.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.Application.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
@Qualifier("trackServiceImpl")
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("track already exists");
        }
        Track savedTrack = trackRepository.save(track);
        if(savedTrack== null){
            throw  new TrackAlreadyExistsException("track exists");
        }
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
    public Optional<Track> findByTrackName(String trackName) throws TrackNotFoundException {
     Optional<Track> track  = trackRepository.findByTrackName(trackName);
        if(!(track.isPresent())){
            throw new TrackNotFoundException("not found");
        }
            return track;
    }
}
